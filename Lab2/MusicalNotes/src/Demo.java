import java.util.*;
public class Demo {
    public static void main(String[] args){
        Note myNote = new Note();
        System.out.println("To create a note you have to provide the app with both the length and the value. And the program would give all the info about this note.");
        int value, length;
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter an integer that represents the length of a note from 0 to 4: ");
        boolean move;
        do{
            length = userInput.nextInt();
            move = true;
            if(length < 0 || length > 4){
                System.out.println("Please, enter a value between 0 and 4!");
                move = false;
            }
        }while(!move);
        myNote.setLength(length);

        System.out.print("Please enter an integer that represents the value of a note from -9 to 2: ");
        do{
            value = userInput.nextInt();
            move = true;
            if(value < -9 || value > 2){
                System.out.println("Please, enter a value between -9 and 2!");
                move = false;
            }
        }while(!move);
        myNote.setValue(value);

        System.out.println(myNote);
    }
}
