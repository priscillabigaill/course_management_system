import java.util.*;
public class Hashmap {
    private static HashMap<String, Course> courses = new HashMap<>();

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

    // create a course node
    private static class Course {
        private String courseName;
        private String courseId;
        private String courseDay;
        private String courseStartTime;
        private String courseEndTime;
        private String courseLecturerName;
        private HashMap<String, Student> studentMap = new HashMap<>();

        // constructor for course
        public Course(String courseName, String courseId, String courseDay, String courseStartTime, String courseEndTime, String courseLecturerName) {
            this.courseName = courseName;
            this.courseId = courseId;
            this.courseDay = courseDay;
            this.courseStartTime = courseStartTime;
            this.courseEndTime = courseEndTime;
            this.courseLecturerName = courseLecturerName;
        }

        // create a student node
        private static class Student {
            private String studentName;
            private String studentId;

            public Student(String studentName, String studentId) {
                this.studentName = studentName;
                this.studentId = studentId;
            }
        }
    }

    /**********************
     *   (1) Add Course   *
     **********************/
    public static void addCourse() {
        Scanner input = new Scanner(System.in);
        // prompt for course details
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

        // create a new course object
        Course newCourse = new Course(courseName, courseId, courseDay, courseStartTime, courseEndTime, courseLecturerName);

        courses.put(courseName, newCourse);

        System.out.println("\n✅The course has been successfully added");
    }

    /***********************
     *  (2) Remove Course  *
     ***********************/
    public static void removeCourse() {
        Scanner input = new Scanner(System.in);
        // prompt for a course to remove
        System.out.print("\nCourse Name: ");
        String courseName = input.nextLine();

        if (courses.containsKey(courseName)) {
            courses.remove(courseName);
            System.out.println("\n✅Successfully removed course!");
        } else {
            System.out.println("\n❌No course found with that name!");
        }
    }

    /***********************
     *  (3) Modify Course  *
     ***********************/
    public static void modifyCourse() {
        Scanner input = new Scanner(System.in);
        //prompt for a course to modify
        System.out.print("\nCourse Name: ");
        String courseName = input.nextLine();

        if (!courses.containsKey(courseName)) {
            System.out.println("\n❌No course found with that name!");
            return;
        }

        Course currentCourse = courses.get(courseName);
        //display current course information
        System.out.println("\nCurrent Course Information: ");
        System.out.println("Course Name: " + courseName);
        System.out.println("Course ID: " + currentCourse.courseId);
        System.out.println("Day: " + currentCourse.courseDay);
        System.out.println("Start Time: " + currentCourse.courseStartTime);
        System.out.println("End Time: " + currentCourse.courseEndTime);
        System.out.println("Lecturer Name: " + currentCourse.courseLecturerName);

        //modify course with new information
        System.out.println("\nEnter new course information: ");
        System.out.print("Day: ");
        String day = input.nextLine();
        System.out.print("Start Time: ");
        String startTime = input.nextLine();
        System.out.print("End Time: ");
        String endTime = input.nextLine();
        System.out.print("Lecturer Name: ");
        String lecturerName = input.nextLine();

        //update course
        currentCourse.courseDay = day;
        currentCourse.courseStartTime = startTime;
        currentCourse.courseEndTime = endTime;
        currentCourse.courseLecturerName = lecturerName;

        System.out.println("\n✅Successfully updated course!");
    }

    /***********************
     *   (4) View Course   *
     ***********************/
    public static void viewCourse() {
        //check if the course list is empty
        if (courses.isEmpty()) {
            System.out.println("\n❌No courses available.");
        } else {
            for (Map.Entry<String, Course> entry : courses.entrySet()) {
                Course currentCourse = entry.getValue();
                //display course details
                System.out.println("\n-Course Details-");
                System.out.println("Course Name: " + currentCourse.courseName);
                System.out.println("Course ID: " + currentCourse.courseId);
                System.out.println("Day: " + currentCourse.courseDay);
                System.out.println("Start Time: " + currentCourse.courseStartTime);
                System.out.println("End Time: " + currentCourse.courseEndTime);
                System.out.println("Lecturer Name: " + currentCourse.courseLecturerName);
            }
        }
    }

    /*******************************
     *  (5) Search Course by Name  *
     *******************************/
    public static void searchCoursebyName() {
        Scanner input = new Scanner(System.in);
        // prompt for a course to search
        System.out.print("\nCourse Name: ");
        String courseName = input.nextLine();

        // search for the course in the HashMap
        Course course = courses.get(courseName);

        if (course != null) {
            // if the course is found, display its details
            System.out.println("\n-Course Details-");
            System.out.println("Course Name: " + course.courseName);
            System.out.println("Course ID: " + course.courseId);
            System.out.println("Day: " + course.courseDay);
            System.out.println("Start Time: " + course.courseStartTime);
            System.out.println("End Time: " + course.courseEndTime);
            System.out.println("Lecturer Name: " + course.courseLecturerName + "\n");

            // display the list of enrolled students
            if (course.studentMap.isEmpty()) {
                System.out.println("No students enrolled.");
            } else {
                System.out.println("-Enrolled Students-");
                for (String studentId : course.studentMap.keySet()) {
                    Course.Student student = course.studentMap.get(studentId);
                    System.out.println("Name (ID): " + student.studentName + " (" + studentId + ")");
                }
            }
        } else {
            // if the course is not found, display an error message
            System.out.println("❌No course found with that name!");
        }
    }

    /*********************************
     *  (6) Add Student to a course  *
     *********************************/
    public static void addStudent() {
        //check if the list is empty
        if (courses.isEmpty()) {
            System.out.println("\n❌No course available!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        //prompt for student details
        System.out.print("\nEnter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        //create a new student object
        Course.Student newStudent = new Course.Student(name, id);

        //prompt for course ID to add the student
        System.out.print("Enter course name to add the student: ");
        String courseName = scanner.nextLine();

        //find the course with the specified ID
        Course currentCourse = courses.get(courseName);

        if (currentCourse != null) {
            //if the specified course is found, adding the student to the course
            currentCourse.studentMap.put(id, newStudent);
            System.out.println("\n✅Student added to the course successfully.");
        } else {
            //if the specified course is not found
            System.out.println("❌Course not found.");
        }
    }

    /**************************************
     *  (7) Remove Student from a course  *
     **************************************/
    public static void removeStudent() {
        //check if the map is empty
        if (courses.isEmpty()) {
            System.out.println("\n❌No course available!");
            return;
        }

        Scanner input = new Scanner(System.in);
        //prompt the course id and student id to be removed
        System.out.print("\nCourse Name: ");
        String courseName = input.nextLine();
        System.out.print("Student ID: ");
        String studentId = input.nextLine();

        //get the course with matching ID
        Course currentCourse = courses.get(courseName);
        if (currentCourse == null) {
            System.out.println("\n❌No course found with that ID!");
            return;
        }

        //get the student with matching ID
        Course.Student currentStudent = currentCourse.studentMap.get(studentId);
        if (currentStudent == null) {
            System.out.println("\n❌No student found with that ID!");
            return;
        }

        //remove student from map
        currentCourse.studentMap.remove(studentId);
        System.out.println("\n✅Successfully removed " + currentStudent.studentName + " from course!");
    }


    //Main Method and Program Execution//
    public static void main (String[]args){
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
        } while (!choice.equals("8"));
    }
}

