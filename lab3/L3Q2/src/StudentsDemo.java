import java.util.Scanner;
public class StudentsDemo {
    public static void main(String[] args){
        Students middlesex = new Students(10);
        Scanner usrInput = new Scanner(System.in);
        mainMenu(usrInput, middlesex);
    }

    public static void mainMenu(Scanner usrInput, Students middlesex){
        System.out.println("What action would you like to implement?");
        System.out.println("1: Show all Students");
        System.out.println("2: Add a Course");
        System.out.println("3: Drop a Course");
        System.out.println("4: Add a Student");
        System.out.println("9: Quit");
        boolean good = true;
        do {
            int selection = usrInput.nextInt();usrInput.nextLine();
            switch (selection) {
                case 1:
                    System.out.println(middlesex);
                    mainMenu(usrInput, middlesex);
                case 2:
                    addCourse(usrInput,middlesex);
                case 3:
                    dropCourse(usrInput,middlesex);
                case 4:
                    addStudent(usrInput,middlesex);
                case 9:
                    System.exit(1);
                default:
                    System.out.println("Invalid selection please select again!");
                    good = false;
            }
        } while(!good);
    }

    public static void addCourse(Scanner usrInput, Students middlesex){
        System.out.println("Please enter the student ID:");
        String id = usrInput.nextLine();
        System.out.println("Please enter the course name");
        String courseName = usrInput.nextLine();
        System.out.println("Please enter the section number");
        int section = usrInput.nextInt();usrInput.nextLine();
        System.out.println("Please enter the number of credits");
        int credits = usrInput.nextInt();usrInput.nextLine();
        middlesex.addCourse(new Course(courseName, section, credits, null), id);
        mainMenu(usrInput, middlesex);
    }
    public static void dropCourse(Scanner usrInput, Students middlesex){
        System.out.println("Please enter the student ID:");
        String id = usrInput.nextLine();
        System.out.println("Please enter the course name");
        String courseName = usrInput.nextLine();
        System.out.println("Please enter the section number");
        int section = usrInput.nextInt();usrInput.nextLine();
        System.out.println("Please enter the number of credits");
        int credits = usrInput.nextInt();usrInput.nextLine();
        middlesex.dropCourse(new Course(courseName, section, credits, null), id);
        mainMenu(usrInput, middlesex);
    }
    public static void addStudent(Scanner usrInput, Students middlesex){
        System.out.println("Please enter the student ID:");
        String id = usrInput.nextLine();
        middlesex.addStudent(id);
        mainMenu(usrInput, middlesex);
    }
}
