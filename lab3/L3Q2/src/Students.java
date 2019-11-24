import java.util.*;
public class Students implements StudentsADT{
    private int maxNumberOfStudents;
    private int numOfStudents;
    private Student[] students;

    public Students(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.students = new Student[maxNumberOfStudents];
        this.numOfStudents = 0;
    }
    public Students() {
        this.maxNumberOfStudents = 100;
        this.numOfStudents = 0;
        this.students = new Student[maxNumberOfStudents];
    }
    public Students(Students stud) {
        this.maxNumberOfStudents = stud.maxNumberOfStudents;
        this.numOfStudents = stud.numOfStudents;
        this.students = new Student[maxNumberOfStudents];
        for(int i = 0; i < stud.numOfStudents; i++){
            this.students[i] = new Student(stud.students[i]);
        }
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        Student[] temp = new Student[maxNumberOfStudents];
        for(int i = 0; i < this.numOfStudents; i++){
            temp[i] = this.students[i];
        }
        students = temp;
    }

    public void addStudent(String id){
        students[numOfStudents] = new Student(id);
        numOfStudents++;
    }

    public void addCourse(Course cor, String id){
        for(int i = 0; i < this.numOfStudents; i++){
            if(students[i].getId().equals(id)){
                students[i].addCourse(cor);
            }
        }
    }

    public void dropCourse(Course cor, String id){
        for(int i = 0; i < this.numOfStudents; i++){
            if(students[i].getId().equals(id)){
                students[i].dropCourse(cor);
            }
        }
    }

    @Override
    public String toString() {
        String returnedVal = String.format("%-4s | COURSES\n", "ID");
        for(int i = 0; i < this.numOfStudents; i++){
            returnedVal += this.students[i]+"\n";
        }
        return returnedVal;
    }

    private class Student{
        private String id;
        private Course firstCourse;

        public Student(String id) {
            this.id = id;
            this.firstCourse = null;
        }

        public Student() {
            this.id = null;
            this.firstCourse = null;
        }

        public Student(Student s) {
            this.id = s.id;
            this.firstCourse = s.firstCourse;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setCourses(Course firstCourse) {
            this.firstCourse = firstCourse;
        }

        public void getCourses(){
            Course current = this.firstCourse;
            while (current != null){
                System.out.println(current);
                current = current.getLink();
            }
        }

        public void addCourse(Course cor){
            if(firstCourse == null){
                firstCourse = cor;
            }
            else{
                Course current = firstCourse;
                while (current.getLink() != null){
                    current = current.getLink();
                }
                current.setLink(cor);
            }
        }
        public void dropCourse(Course cor){
            if(firstCourse == null){
                System.out.println("The student has no courses to drop!");
            }
            else{
                Course current = firstCourse;
                Course prev = null;
                while (current != null){
                    if(current.equals(cor)){
                        if (prev== null){
                            firstCourse = current.getLink();
                        }
                        else{
                            prev.setLink(current.getLink());
                        }
                        break;
                    }
                    prev = current;
                    current = current.getLink();
                }
            }
        }

        @Override
        public String toString() {
            String returnedVal = id + " | ";
            Course current = firstCourse;
            while(current != null){
                returnedVal += current + ", ";
                current = current.getLink();
            }
            return returnedVal.substring(0, returnedVal.length()-2);
        }
    }
}
