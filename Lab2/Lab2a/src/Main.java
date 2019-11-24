import Locker.*;
import java.util.*;
public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to the smart lock app!");
        System.out.println("In this app you will create a lock with the combination of three numbers, ranges from 0 to 39.");
        System.out.print("\nUnlocking stages:\n" +
                "        1. make one complete revolution from where you are forward\n" +
                "        2. go to \"code1\" forwardly\n" +
                "        3.make one complete revolution from where you are backward\n" +
                "        4. go to \"code2\" backwardly\n" +
                "        5. go to \"code3\" forwardly\n\n");
        System.out.println("First Please enter three number. (each of them is from 0 to 39)");
        Scanner userInput = new Scanner(System.in);
        int code1 = setCode(userInput);
        int code2 = setCode(userInput);
        int code3 = setCode(userInput);
        Lock myLock = new Locker(code1, code2, code3);
        mainMenu(userInput, myLock);
    }

    public static int setCode(Scanner userInput){
        int code;
        do{
            code = userInput.nextInt();
        }while( code < 0 || code > 39);
        return code;
    }

    public static void mainMenu(Scanner userInput, Lock lock){
        System.out.println();
        System.out.println("To change the lock code press 1");
        System.out.println("To turn the nob press 2");
        System.out.println("To close the lock press 3");
        System.out.println("To attempt to open the lock press 4");
        System.out.println("To inquire about the status of the lock press 5");
        System.out.println("To know at which number the nob is pointing press 6");
        System.out.println("To rotate the nob three complete turns to reset it press 7");
        System.out.println("To close the app press 8");

        boolean again;
        do{
            int input = userInput.nextInt();
            again = false;
            switch (input){
                case 1:
                    alter(userInput, lock);
                    break;
                case 2:
                    turn(userInput, lock);
                    break;
                case 3:
                    lock.close();
                    mainMenu(userInput, lock);
                    break;
                case 4:
                    lock.attempt();
                    mainMenu(userInput, lock);
                    break;
                case 5:
                    if(lock.inquire()){
                        System.out.println("The lock is open.");
                    }
                    else{
                        System.out.println("The lock is closed.");
                    }
                    mainMenu(userInput, lock);
                    break;
                case 6:
                    System.out.println("The nob is currently pointing towards " + lock.currently());
                    mainMenu(userInput, lock);
                    break;
                case 7:
                    lock.reset();
                    mainMenu(userInput, lock);
                    break;
                case 8:
                    System.exit(1);
                    break;
                default:
                    again = true;

            }
        }while(again);
    }

    public static void alter(Scanner userInput, Lock lock){
        System.out.println();
        System.out.println("Please enter three number. (each of them is from 0 to 39)");
        int code1 = setCode(userInput);
        int code2 = setCode(userInput);
        int code3 = setCode(userInput);
        lock.alter(code1, code2, code3);
        mainMenu(userInput, lock);
    }

    public static void turn(Scanner userInput, Lock lock){
        System.out.println();
        System.out.println("Enter the number you want to go to. (Note to make a complete Cycle enter " + lock.currently() + ")");
        int goTo = setCode(userInput);
        int dir;
        System.out.println("To go forward press 1 to go backward press 2");
        do{
            dir = userInput.nextInt();
        }while(dir != 1 && dir != 2);
        if (dir == 1){
            lock.turn(goTo, true);
        }
        else {
            lock.turn(goTo, false);
        }
        int whereNext;
        System.out.println("To continue turning the nob press 1 to go back to main menu press 2");
        do{
            whereNext = userInput.nextInt();
            if(whereNext == 1) turn(userInput, lock);
            if(whereNext == 2) mainMenu(userInput, lock);
        }while(whereNext != 1 && whereNext !=2);
        mainMenu(userInput, lock);
    }
}
