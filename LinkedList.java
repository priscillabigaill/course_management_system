import java.util.Scanner;

public class LinkedList {
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

    //Creating a course node
    private static class Course {
        private String courseName;
        private String courseId;
        private String courseDay;
        private String courseStartTime;
        private String courseEndTime;
        private String courseLecturerName;
        private Course courseNext;
        private Student studentListHead;

        public Course(String courseName, String courseId, String courseDay, String courseStartTime, String courseEndTime, String courseLecturerName, Student studentListHead) {
            this.courseName = courseName;
            this.courseId = courseId;
            this.courseDay = courseDay;
            this.courseStartTime = courseStartTime;
            this.courseEndTime = courseEndTime;
            this.courseLecturerName = courseLecturerName;
            this.studentListHead = studentListHead;
            this.courseNext = null;
        }

        private static class Student {
            private String studentName;
            private String studentId;
            private Student studentNext;

            public Student(String studentName, String studentId){
                this.studentName = studentName;
                this.studentId = studentId;
                this.studentNext = null;
            }
        }
    }

    private static Course head = null;

    /*********************
    *   (1) Add Course   *
    **********************/
    public static void addCourse() {
        Scanner input = new Scanner(System.in);
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
        Course.Student studentList = null;
        Course newCourse = new Course(courseName, courseId, courseDay, courseStartTime, courseEndTime, courseLecturerName, studentList);

        if (head==null) {
            head = newCourse;
        } else {
            Course currentCourse = head;
            while (currentCourse.courseNext != null) {
                currentCourse = currentCourse.courseNext;
            }
            currentCourse.courseNext = newCourse;
        }
        System.out.println("\n✅The course has been successfully added");
    }

    /**********************
    *  (2) Remove Course  *
    ***********************/
    public static void removeCourse() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nCourse Name: ");
        String courseName = input.nextLine();

        //check if list is empty
        if (head == null) {
            System.out.println("\n❌No course found with that name!");
            return;
        }
        //check if first course has matching name
        else if (head.courseName.equals(courseName)) {
            head = head.courseNext; //remove first contact
            System.out.println("\n✅Successfully removed course!");
            return;
        }
        //search for course with matching name
        Course current = head;
        while (current.courseNext != null && !current.courseNext.courseName.equals(courseName)) {
            current = current.courseNext;
        }
        //reaching the end of the linkedList without finding a matching course name
        if (current.courseNext == null) {
            System.out.println("\n❌No course found with that name!");
            return;
        }
        //if found, remove contact from linkedList
        current.courseNext = current.courseNext.courseNext;
        System.out.println("\n✅Successfully removed course!");
    }

    /**********************
    *  (3) Modify Course  *
    ***********************/
    public static void modifyCourse() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nCourse Name: ");
        String courseName = input.nextLine();

        //Search for course with matching name
        Course current = head;
        while (current != null && !current.courseName.equals(courseName)) {
            current = current.courseNext;
        }
        //If course not found
        if (current == null) {
            System.out.println("\n❌No course found with that name!");
            return;
        }

        //Display current course information
        System.out.println("\nCurrent Course Information: ");
        System.out.println("Course Name: " + current.courseName);
        System.out.println("Course ID: " + current.courseId);
        System.out.println("Day: " + current.courseDay);
        System.out.println("Start Time: " + current.courseStartTime);
        System.out.println("End Time: " + current.courseEndTime);
        System.out.println("Lecturer Name: " + current.courseLecturerName);

        //Modify course with new information
        System.out.println("\nEnter new course information: ");
        System.out.print("Day: ");
        String day = input.nextLine();
        System.out.print("Start Time: ");
        String startTime = input.nextLine();
        System.out.print("End Time: ");
        String endTime = input.nextLine();
        System.out.print("Lecturer Name: ");
        String lecturerName = input.nextLine();

        //Update course
        current.courseDay = day;
        current.courseStartTime = startTime;
        current.courseEndTime = endTime;
        current.courseLecturerName = lecturerName;

        System.out.println("\n✅Successfully updated course!");
    }

    /**********************
    *   (4) View Course   *
    ***********************/
    public static void viewCourse() {
       if (head == null) {
           System.out.println("No courses available.");
       } else {
           Course currentCourse = head;
           while (currentCourse != null) {
                System.out.println("\n-Course Details-");
                System.out.println("Course Name: " + currentCourse.courseName);
                System.out.println("Course ID: " + currentCourse.courseId);
                System.out.println("Day: " + currentCourse.courseDay);
                System.out.println("Start Time: " + currentCourse.courseStartTime);
                System.out.println("End Time: " + currentCourse.courseEndTime);
                System.out.println("Lecturer Name: " + currentCourse.courseLecturerName);
                currentCourse = currentCourse.courseNext;
           }
       }
    }

    /******************************
    *  (5) Search Course by Name  *
    *******************************/
    public static void searchCoursebyName() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nCourse Name: ");
        String courseName = input.nextLine();

        Course currentCourse = head;
        boolean found = false;

        while(currentCourse != null) {
            if (currentCourse.courseName.equals(courseName)) {
                System.out.println("\n-Course Details-");
                System.out.println("Course Name: " + currentCourse.courseName);
                System.out.println("Course ID: " + currentCourse.courseId);
                System.out.println("Day: " + currentCourse.courseDay);
                System.out.println("Start Time: " + currentCourse.courseStartTime);
                System.out.println("End Time: " + currentCourse.courseEndTime);
                System.out.println("Lecturer Name: " + currentCourse.courseLecturerName);
                System.out.println();

                if (currentCourse.studentListHead == null) {
                    System.out.println("No students enrolled.");
                } else {
                    System.out.print("-Enrolled Students-");
                    Course.Student currentStudent = currentCourse.studentListHead;
                    while (currentStudent != null) {
                        System.out.println("\nName (ID): " + currentStudent.studentName + " (" + currentStudent.studentId + ")");
                        currentStudent = currentStudent.studentNext;
                    }
                }
                found = true;
            }
            currentCourse = currentCourse.courseNext;
        }

        if (!found){
            System.out.println("\n❌No course found with that name!");
        }
    }

    /********************************
    *  (6) Add Student to a course  *
    *********************************/
    public static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        // Prompting for student details
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        // Creating a new student object
        Course.Student newStudent = new Course.Student(name, id);

        // Checking if the course list is empty
        if (head == null) {
            System.out.println("No courses available.");
            return;
        }

        // Prompting for course ID to add the student
        System.out.print("Enter course ID to add the student: ");
        String courseName = scanner.nextLine();

        Course currentCourse = head;

        // Iterating over the course list to find the specified course
        while (currentCourse != null) {
            if (currentCourse.courseId.equals(courseName)) {
                // If the specified course is found, adding the student to the course
                if (currentCourse.studentListHead == null) {
                    // If the student list is empty, setting the new student as the head of the list
                    currentCourse.studentListHead = newStudent;
                } else {
                    // If the student list is not empty, iterating to the end of the list and adding the new student
                    Course.Student lastStudent = currentCourse.studentListHead;
                    while (lastStudent.studentNext != null) {
                        lastStudent = lastStudent.studentNext;
                    }
                    lastStudent.studentNext = newStudent;
                }
                System.out.println("\nStudent added to the course successfully.");
                return;
            }
            currentCourse = currentCourse.courseNext;
        }

        // If the specified course is not found
        System.out.println("Course not found.");
    }

    /*************************************
    *  (7) Remove Student from a course  *
    **************************************/
    public static void removeStudent() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nCourse ID: ");
        String courseId = input.nextLine();
        System.out.print("Student ID: ");
        String studentId = input.nextLine();

        // Search for course with matching ID
        Course currentCourse = head;
        while (currentCourse != null && !currentCourse.courseId.equals(courseId)) {
            currentCourse = currentCourse.courseNext;
        }
        if (currentCourse == null) {
            System.out.println("\n❌No course found with that name!");
            return;
        }

        // Search for student with matching ID
        Course.Student currentStudent = currentCourse.studentListHead;
        Course.Student prevStudent = null;
        while (currentStudent != null && !currentStudent.studentId.equals(studentId)) {
            prevStudent = currentStudent;
            currentStudent = currentStudent.studentNext;
        }
        if (currentStudent == null) {
            System.out.println("\n❌No student found with that ID!");
            return;
        }

        // Remove student from list
        if (prevStudent == null) {
            currentCourse.studentListHead = currentStudent.studentNext;
        } else {
            prevStudent.studentNext = currentStudent.studentNext;
        }
        System.out.println("\n✅Successfully removed " + currentStudent.studentName + " from course!");
    }

    //Main Method and Program Execution//
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            displayMenu();
            choice = input.nextLine();

            if (choice.equals("1")) {
                addCourse();
            } else if (choice.equals("2")) {
                removeCourse();
            } else if (choice.equals("3")) {
                modifyCourse();
            } else if (choice.equals("4")) {
                viewCourse();
            } else if (choice.equals("5")) {
                searchCoursebyName();
            } else if (choice.equals("6")) {
                addStudent();
            } else if (choice.equals("7")) {
                removeStudent();
            }
        } while(!choice.equals("8"));
    }
}


