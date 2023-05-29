package finalProject;

import java.util.ArrayList;
import java.util.Scanner;

//create a student class as a collection of students for arraylist
class Student {
    private String studentName;
    private String studentId;

    //Constructor for Student class
    public Student(String studentName, String studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String toString() {
        return "Student name: " + studentName + ", Student Id: " + studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getStudentId() {
        return this.studentId;
    }
}

//create a course class as a collection of courses for arraylist
class Course {
    private String courseName;
    private String courseId;
    private String courseDay;
    private String courseStartTime;
    private String courseEndTime;
    private String courseLecturerName;
    private ArrayList<Student> students;

    //constructor for Course class
    public Course(String courseName, String courseId, String courseDay, String courseStartTime, String courseEndTime, String courseLecturerName) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseDay = courseDay;
        this.courseStartTime = courseStartTime;
        this.courseEndTime = courseEndTime;
        this.courseLecturerName = courseLecturerName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseDay(String courseDay) {
        this.courseDay = courseDay;
    }

    public void setCourseStartTime(String courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    public void setCourseEndTime(String courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public void setCourseLecturerName(String courseLecturerName) {
        this.courseLecturerName = courseLecturerName;
    }

    public String getCourseDay() {
        return courseDay;
    }

    public String getCourseStartTime() {
        return courseStartTime;
    }

    public String getCourseEndTime() {
        return courseEndTime;
    }

    public String getCourseLecturerName() {
        return courseLecturerName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

public class ArrayList {
    //create a courseList arrayList that will store all courses
    private static ArrayList<Course> courseList = new ArrayList<>();
    public static void displayMenu() {
        System.out.println("\n🏫Welcome Admin to our course management system!");
        System.out.println("\n******************************");
        System.out.println("(1) Add course");
        System.out.println("(2) Remove course");
        System.out.println("(3) Edit course");
        System.out.println("(4) View course details");
        System.out.println("(5) Search course by name");
        System.out.println("(6) Add student to a course");
        System.out.println("(7) Remove student from a course");
        System.out.println("(8) Exit");
        System.out.println("******************************");
        System.out.print("Choose a command: ");
    }

    /**********************
     *   (1) Add Course   *
     **********************/
    public static void addCourse() {
        Scanner input = new Scanner(System.in);
        //prompt for course details
        System.out.print("\nCourse Name: ");
        String courseName = input.next();
        System.out.print("Course Id: ");
        String courseId = input.next();
        System.out.print("Day: ");
        String courseDay = input.next();
        System.out.print("Start Time: ");
        String courseStartTime = input.next();
        System.out.print("End Time: ");
        String courseEndTime = input.next();
        System.out.print("Lecturer Name: ");
        String courseLecturerName = input.next();

        //create a new course object and add it to the courseList
        Course newCourse = new Course(courseName, courseId, courseDay, courseStartTime, courseEndTime, courseLecturerName);
        courseList.add(newCourse);

        System.out.println("\n✅The course has been successfully added");
    }

    /***********************
     *  (2) Remove Course  *
     ***********************/
    public static void removeCourse() {
        //check if the course list is empty
        if (courseList.isEmpty()) {
            System.out.println("\n❌No course available!");
            return;
        }

        Scanner input = new Scanner(System.in);
        //prompt for a course to be removed
        System.out.print("\nCourse name: ");
        String courseName = input.nextLine();

        //iterate over the course list in reverse order to find the matching course name
        for (int i=courseList.size()-1; i>=0; i--) {
            Course course = courseList.get(i);
            if (course.getCourseName().equals(courseName)) {
                courseList.remove(i);
                System.out.println("\n✅Successfully removed course!");
                return;
            }
        }

        //if no matching course is found
        System.out.println("❌No course found with that name!");
    }

    /***********************
     *  (3) Modify Course  *
     ***********************/
    public static void modifyCourse() {
        //check if the course list is empty
        if (courseList.isEmpty()) {
            System.out.println("\n❌No course available!");
            return;
        }

        Scanner input = new Scanner(System.in);
        //prompt for a course to be modified
        System.out.print("\nCourse name: ");
        String courseName = input.nextLine();

        //search for course with matching name
        for (Course course : courseList) {
            if (course.getCourseName().equals(courseName)) {
                //display current course information
                System.out.println("\nCurrent Course Information: ");
                System.out.println("Course Name: " + course.getCourseName());
                System.out.println("Course ID: " + course.getCourseId());
                System.out.println("Day: " + course.getCourseDay());
                System.out.println("Start Time: " + course.getCourseStartTime());
                System.out.println("End Time: " + course.getCourseEndTime());
                System.out.println("Lecturer Name: " + course.getCourseLecturerName());

                //modify the specified course with new information
                System.out.println("\nEnter new course information: ");
                System.out.print("Day: ");
                String newCourseDay = input.nextLine();
                System.out.print("Start Time: ");
                String newCourseStartTime = input.nextLine();
                System.out.print("End Time: ");
                String newCourseEndTime = input.nextLine();
                System.out.print("Lecturer Name: ");
                String newCourseLecturerName = input.nextLine();

                //update course by setting all the modified information
                course.setCourseDay(newCourseDay);
                course.setCourseStartTime(newCourseStartTime);
                course.setCourseEndTime(newCourseEndTime);
                course.setCourseLecturerName(newCourseLecturerName);

                System.out.println("\n✅Successfully updated course!");
                return;
            }
        }

        //if no matching course is found
        System.out.println("❌ No course found with that name!");

    }

    /***********************
     *   (4) View Course   *
     ***********************/
    public static void viewCourse() {
        //check whether course list is empty
        if (courseList.isEmpty()) {
            System.out.println("\n❌No courses available");
        } else {
            //iterate over the course list to print out all the courses information
            for (Course course : courseList) {
                System.out.println("\n-Course Details-");
                System.out.println("Course Name: " + course.getCourseName());
                System.out.println("Course Id: " + course.getCourseId());
                System.out.println("Day: " + course.getCourseDay());
                System.out.println("Start Time: " + course.getCourseStartTime());
                System.out.println("End Time: " + course.getCourseEndTime());
                System.out.println("Lecturer Name: " + course.getCourseLecturerName());
            }
        }
    }

    /*******************************
     *  (5) Search Course by Name  *
     *******************************/
    public static void searchCoursebyName() {
        Scanner input = new Scanner(System.in);
        //prompt for a course to search
        System.out.print("\nCourse Name: ");
        String courseName = input.nextLine();

        //iterate over the course list to find the specified course
        for (Course course : courseList) {
            if (course.getCourseName().equals(courseName)) {
                System.out.println("\n-Course Details-");
                System.out.println("Course Name: " + course.getCourseName());
                System.out.println("Course ID: " + course.getCourseId());
                System.out.println("Day: " + course.getCourseDay());
                System.out.println("Start Time: " + course.getCourseStartTime());
                System.out.println("End Time: " + course.getCourseEndTime());
                System.out.println("Lecturer Name: " + course.getCourseLecturerName() + "\n");

                //check if there are any enrolled students in the course
                if (course.getStudents().size() == 0) {
                    System.out.println("No students enrolled.");
                } else {
                    System.out.println("-Enrolled Students-");
                    //display details of each enrolled student
                    for (Student student : course.getStudents()) {
                        System.out.println("Name (ID): " + student.getStudentName() + " (" + student.getStudentId() + ")");
                    }
                }
                return;
            }
        }

        //if no matching course is found
        System.out.println("❌No course found with that name!");
    }

    /*********************************
     *  (6) Add Student to a course  *
     *********************************/
    public static void addStudent() {
        //check if the course list is empty
        if (courseList.isEmpty()) {
            System.out.println("\n❌No course available!");
            return;
        }

        Scanner input = new Scanner(System.in);
        //prompt for student details
        System.out.print("\nEnter student name: ");
        String studentName = input.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = input.nextLine();

        //create a new student object
        Student newStudent = new Student(studentName, studentId);

        //prompt for course name to add the student
        System.out.print("Enter course name to add the student: ");
        String courseName = input.nextLine();

        //iterate over the course list to find the specified course
        for (Course course : courseList) {
            if (course.getCourseName().equals(courseName)) {
                //if the specified course if found, adding the student to the course
                course.getStudents().add(newStudent);
                System.out.println("\n✅Student added to the course successfully.");
                return;
            }
        }

        //if the specified course is not found
        System.out.println("❌Course not found.");
    }

    /**************************************
     *  (7) Remove Student from a course  *
     **************************************/
    public static void removeStudent() {
        //check if the course list is empty
        if (courseList.isEmpty()) {
            System.out.println("\n❌No course available!");
            return;
        }

        Scanner input = new Scanner(System.in);
        //prompt the course name and student id to be removed
        System.out.print("\nCourse Name: ");
        String courseName = input.nextLine();
        System.out.print("Student ID: ");
        String studentId = input.nextLine();

        //iterate over the course list in reverse order to find the matching course name
        for (int i=courseList.size()-1; i>=0; i--) {
            Course course = courseList.get(i);
            if (course.getCourseName().equals(courseName)) {
                for (int j=course.getStudents().size()-1; j>=0; j--) {
                    Student student = course.getStudents().get(j);
                    if (student.getStudentId().equals(studentId)) {
                        course.getStudents().remove(j);
                        System.out.println("\n✅Successfully removed " + student.getStudentName() + " from course!");
                        return;
                    }
                }
                //if no matching student ID is found
                System.out.println("❌No student found with that ID!");
                return;
            }
        }

        //if no matching course is found
        System.out.println("❌No course found with that name!");
    }

    //Main Method and Program Execution//
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            displayMenu();
            choice = input.nextLine();

            switch (choice) {
                case "1" -> addCourse();
                case "2" -> removeCourse();
                case "3" -> modifyCourse();
                case "4" -> viewCourse();
                case "5" -> searchCoursebyName();
                case "6" -> addStudent();
                case "7" -> removeStudent();
            }
        } while(!choice.equals("8"));
    }
}
