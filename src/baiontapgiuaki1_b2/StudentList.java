package baiontapgiuaki1_b2;

import java.util.ArrayList;
import java.util.Date;

public class StudentList extends Student {

    public ArrayList<Student> studentList;

    public StudentList() {
        this.studentList = new  ArrayList<>();
    }

    public StudentList(ArrayList<Student> studentList, float gpa, String major, float tuition, float scholarship, String id, String fullName, Date dateOfBirth) {
        super(gpa, major, tuition, scholarship, id, fullName, dateOfBirth);
        this.studentList = studentList;
    }

   

    public void addStudent(Student student) {
        studentList.add(student);

    }

    public void deleteStudentByID(String iD) {
        studentList.removeIf(Student -> Student.getId().equals(iD));
    }

    public Student findStudentByID(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudent() {
        for (Student student : studentList) {
            student.displayInfor();
            System.out.println();
        }
    }

    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }

        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;

    }

    public void displayScholarshipStudent() {
        System.out.println("Student have schoolarship");
        for (Student student : studentList) {
            if (student.getGpa() >= 9) {
                System.out.println(student.getFullName() + " " + "have a schoolarship");
                student.displayInfor();

            }
        }
    }

    public float calculateTuiitionOfAllStudents() {
        float totalTuiition = 0;
        for (Student student : studentList) {
            totalTuiition += student.calculateTuition();
        }
        return totalTuiition;
    }

}
