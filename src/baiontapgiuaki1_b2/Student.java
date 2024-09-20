package baiontapgiuaki1_b2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {

    private float gpa;
    private String major;
    private final float tuition = 10000000;
    private float scholarship;

    public Student() {
    }

    public Student(float gpa, String major, float tuition, float scholarship, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
        this.scholarship = this.scholarship;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuition() {
        return tuition;
    }

    public float isScholarship() {
        return scholarship;
    }

    public void setScholarship(float scholarship) {
        this.scholarship = this.scholarship;
    }

    public void addStudent(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gpa = gpa;
        this.major = major;
    }

    @Override
    public void displayInfor() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(dateOfBirth);
        System.out.println("ID: " + id);
        System.out.println("Full name: " + fullName);
        System.out.println("Date of birth(dd/MM/yyyy): " + formattedDate);
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        
        if (gpa >= 9){
            System.out.println("Scholarship: Yes (Students receive a 50% discount on tuition fees)");
        } else {
            System.out.println("Scholarship : No");
        }
        
        System.out.println("TuiTion fee: " + calculateTuition() + "VND");
        System.out.println();
    }

    public float calculateTuition() {
        if (gpa >= 9) {
            return tuition * 0.5f;
        } else {
            return tuition;
        }
    }

}
