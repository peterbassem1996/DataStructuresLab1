public interface StudentsADT {
    public abstract void addStudent(String id);
    public abstract void addCourse(Course cor, String id);
    public abstract void dropCourse(Course cor, String id);
    public abstract String toString();
}
