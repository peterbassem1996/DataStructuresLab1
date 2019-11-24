import java.util.Objects;

public class Course {
    private String courseName;
    private int sectionNumber;
    private int numberOfCredits;
    private Course link;

    public Course(String courseName, int sectionNumber, int numberOfCredits, Course link) {
        this.courseName = courseName;
        this.sectionNumber = sectionNumber;
        this.numberOfCredits = numberOfCredits;
        this.link = link;
    }

    public Course() {
        this.courseName = "";
        this.sectionNumber = 0;
        this.numberOfCredits = 0;
        this.link = null;
    }

    public Course(Course another) {
        this.courseName = another.getCourseName();
        this.sectionNumber = another.getSectionNumber();
        this.numberOfCredits = another.getNumberOfCredits();
        this.link = another.getLink();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public Course getLink() {
        return link;
    }

    public void setLink(Course link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return this.courseName + "-" + this.sectionNumber + " " + this.numberOfCredits + " credits";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return sectionNumber == course.sectionNumber &&
                numberOfCredits == course.numberOfCredits &&
                courseName.equals(course.courseName);
    }
}
