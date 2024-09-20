package baiontapgiuaki1_b2;

import baiontapgiuaki1_b2.Student;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) throws ParseException {
        StudentList studentList = new StudentList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("******Choose an option*********");
                System.out.println("1. Add a new Student");
                System.out.println("2. Update a student by id");
                System.out.println("3. Delete a student by id");
                System.out.println("4. Display all students");
                System.out.println("5. Find the student with highest GPA");
                System.out.println("6. Display a student have scholarship ");
                System.out.println("7. Displays the total tuition fees of all students");
                System.out.println("8. Exit");
                System.out.println("--------Choose the number----------");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter full name: ");
                        String fullName = sc.nextLine();

                        System.out.print("Enter Date of birth (dd/MM/yyyy): ");
                        String date = sc.nextLine();
                        Date dateOfBirth = sdf.parse(date);

                        System.out.print("Enter GPA: ");
                        float GPA = sc.nextFloat();
                        sc.nextLine();

                        System.out.print("Enter major: ");
                        String major = sc.nextLine();

                        studentList.addStudent(new Student(GPA, major, GPA, GPA, id, fullName, dateOfBirth));
                        System.out.println();
                        break;

                    case 2:
                        System.out.print("Enter ID: ");
                        String ID = sc.nextLine();
                        Student studentToUpdate = studentList.findStudentByID(ID);

                        if (studentToUpdate != null) {
                            System.out.println("ID: " + ID);
                            System.out.print("Enter new name: ");
                            String newfullName = sc.nextLine();
                            studentToUpdate.setFullName(newfullName);

                            System.out.print("Enter new date of birth(dd/MM/yyyy): ");
                            String newDateOfBirth = sc.nextLine();
                            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                            Date newDate = sd.parse(newDateOfBirth);

                            System.out.print("Enter new major: ");
                            String newMajor = sc.nextLine();

                            System.out.print("Enter new GPA: ");
                            float newGpa = sc.nextFloat();
                            sc.nextLine();
                            studentToUpdate.setGpa(newGpa);

                            System.out.println("Student updated successfully.");
                            System.out.println("-----------");
                        } else {
                            System.out.println("Student not found");
                            System.out.println("-----------");
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID of the student to delete: ");
                        String deleteID = sc.nextLine();
                        studentList.deleteStudentByID(deleteID);
                        System.out.println("Student deleted succesfully");

                        break;

                    case 4:
                        studentList.displayAllStudent();
                        break;

                    case 5:
                        Student topStudent = studentList.findTopStudent();
                        if (topStudent != null) {
                            System.out.println("Student with the highest GPA");
                            topStudent.displayInfor();
                        } else {
                            System.out.println("No students in the list");
                            System.out.println();
                        }
                        break;

                    case 6:
                        studentList.displayScholarshipStudent();
                        break;
                    case 7:
                        float totalTuition = studentList.calculateTuition();
                        System.out.println("Total tuition fees of all student: " + totalTuition);
                        System.out.println();
                        break;
                    case 8:
                        System.out.println("Exiting the program");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please choice again.");
                        System.out.println();
                        break;

                }
            } catch (ParseException e) {
                System.out.println("Invalid date foramt. Please try again");
            }
            
        }
        sc.close();
    }
   
}