import java.util.Scanner;

public class LinkedlistDemo {
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

    //create a course node
    private static class Course {
        private String courseName;
        private String courseId;
        private String courseDay;
        private String courseStartTime;
        private String courseEndTime;
        private String courseLecturerName;
        private Course coursePrevious;
        private Course courseNext;
        private Student studentListHead;
        private Student studentListTail;

        //constructor for course
        public Course(String courseName, String courseId, String courseDay, String courseStartTime, String courseEndTime, String courseLecturerName, Student studentListHead) {
            this.courseName = courseName;
            this.courseId = courseId;
            this.courseDay = courseDay;
            this.courseStartTime = courseStartTime;
            this.courseEndTime = courseEndTime;
            this.courseLecturerName = courseLecturerName;
            this.studentListHead = studentListHead;
            this.coursePrevious = null;
            this.courseNext = null;
        }

        //create a student node
        private static class Student {
            private String studentName;
            private String studentId;
            private Student studentPrevious;
            private Student studentNext;

            public Student(String studentName, String studentId){
                this.studentName = studentName;
                this.studentId = studentId;
                this.studentPrevious = null;
                this.studentNext = null;
            }
        }
    }

    private static Course head, tail = null;

    /**********************
     *   (1) Add Course   *
     **********************/
    public static void addCourse(String courseName, String courseId, String courseDay, String courseStartTime, String courseEndTime, String courseLecturerName, Course.Student studentList) {

        //create a new course object
        Course newCourse = new Course(courseName, courseId, courseDay, courseStartTime, courseEndTime, courseLecturerName, studentList);

        if (head==null) {
            //if the list is empty, make the new course the head and tail
            head = tail = newCourse;
            head.coursePrevious = null;
            tail.courseNext = null;
        } else {
            //if the list is not empty, append the course to the end
            tail.courseNext = newCourse;
            newCourse.coursePrevious = tail;
            tail = newCourse;
            tail.courseNext = null;
        }

        System.out.println("\n✅The course has been successfully added");
    }

    /***********************
     *  (2) Remove Course  *
     ***********************/
    public static void removeCourse(String rmvCourseName) {
        //check if the list is empty
        if (head == null) {
            System.out.println("\n❌No course available!");
            return;
        }

        //search for the course with the matching name
        Course currentCourse = head;
        while (currentCourse != null && !currentCourse.courseName.equals(rmvCourseName)) {
            currentCourse = currentCourse.courseNext;
        }
        //reach the end of the linkedList without finding a matching course name
        if (currentCourse == null) {
            System.out.println("\n❌No course found with that name!");
            return;
        }

        //if found, remove the course from the linkedList
        if (currentCourse.coursePrevious == null) {
            head = head.courseNext;
        } else {
            currentCourse.coursePrevious.courseNext = currentCourse.courseNext;
        }

        if (currentCourse.courseNext != null) {
            currentCourse.courseNext.coursePrevious = currentCourse.coursePrevious;  //update next course's previous reference
        }
        System.out.println("\n✅Successfully removed course!");
    }

    /***********************
     *  (3) Modify Course  *
     ***********************/
    public static void modifyCourse(String modCourseName, String day, String startTime, String endTime, String lecturerName) {
        //check if the list is empty
        if (head == null) {
            System.out.println("\n❌No course available!");
            return;
        }

        //search for course with matching name
        Course currentCourse = head;
        while (currentCourse != null && !currentCourse.courseName.equals(modCourseName)) {
            currentCourse = currentCourse.courseNext;
        }
        //if the course is not found
        if (currentCourse == null) {
            System.out.println("\n❌No course found with that name!");
            return;
        }

        //display current course information
        System.out.println("\nCurrent Course Information: ");
        System.out.println("Course Name: " + currentCourse.courseName);
        System.out.println("Course ID: " + currentCourse.courseId);
        System.out.println("Day: " + currentCourse.courseDay);
        System.out.println("Start Time: " + currentCourse.courseStartTime);
        System.out.println("End Time: " + currentCourse.courseEndTime);
        System.out.println("Lecturer Name: " + currentCourse.courseLecturerName);

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
        if (head == null) {
            System.out.println("\n❌No courses available.");
        } else {
            Course currentCourse = head;
            while (currentCourse != null) {
                //display course details
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

    /*******************************
     *  (5) Search Course by Name  *
     *******************************/
    public static void searchCoursebyName(String srchCourse) {

        Course currentCourse = head;
        boolean found = false;

        //iterate over the course list to find the specified course
        while (currentCourse != null) {
            //check if the current course matches the specified course name
            if (currentCourse.courseName.equals(srchCourse)) {
                System.out.println("\n-Course Details-");
                System.out.println("Course Name: " + currentCourse.courseName);
                System.out.println("Course ID: " + currentCourse.courseId);
                System.out.println("Day: " + currentCourse.courseDay);
                System.out.println("Start Time: " + currentCourse.courseStartTime);
                System.out.println("End Time: " + currentCourse.courseEndTime);
                System.out.println("Lecturer Name: " + currentCourse.courseLecturerName + "\n");

                //check if there are any enrolled students in the course
                if (currentCourse.studentListHead == null) {
                    System.out.println("No students enrolled.");
                } else {
                    System.out.print("-Enrolled Students-");
                    Course.Student currentStudent = currentCourse.studentListHead;
                    while (currentStudent != null) {
                        //display details of each enrolled student
                        System.out.println("\nName (ID): " + currentStudent.studentName + " (" + currentStudent.studentId + ")");
                        currentStudent = currentStudent.studentNext;
                    }
                }
                found = true;
            }
            currentCourse = currentCourse.courseNext;
        }

        //if no matching course is found
        if (!found) {
            System.out.println("❌No course found with that name!");
        }
    }

    /*********************************
     *  (6) Add Student to a course  *
     *********************************/
    public static void addStudent(String name, String id, String addTo) {
        //check if the course list is empty
        if (head == null) {
            System.out.println("\n❌No course available!");
            return;
        }

        //create a new student object
        Course.Student newStudent = new Course.Student(name, id);

        Course currentCourse = head;

        //iterate over the course list to find the specified course
        while (currentCourse != null) {
            if (currentCourse.courseName.equals(addTo)) {
                //if the specified course is found, adding the student to the course
                if (currentCourse.studentListHead == null) {
                    //if the student list is empty, setting the new student as the head of the list
                    currentCourse.studentListHead = currentCourse.studentListTail = newStudent;
                    currentCourse.studentListHead.studentPrevious = null;
                    currentCourse.studentListTail.studentNext = null;
                } else {
                    //if the student list is not empty, iterating to the end of the list and adding the new student
                    currentCourse.studentListTail.studentNext = newStudent;
                    newStudent.studentPrevious = currentCourse.studentListTail;
                    currentCourse.studentListTail = newStudent;
                    currentCourse.studentListTail.studentNext = null;
                }
                System.out.println("\n✅Student added to the course successfully.");
                return;
            }
            currentCourse = currentCourse.courseNext;
        }

        //if the specified course is not found
        System.out.println("❌Course not found.");
    }

    /**************************************
     *  (7) Remove Student from a course  *
     **************************************/
    public static void removeStudent(String rmvName, String rmvId) {
        //check if the course list is empty
        if (head == null) {
            System.out.println("\n❌No course available!");
            return;
        }

        //search for course with matching name
        Course currentCourse = head;
        while (currentCourse != null && !currentCourse.courseName.equals(rmvName)) {
            currentCourse = currentCourse.courseNext;
        }
        if (currentCourse == null) {
            System.out.println("\n❌No course found with that name!");
            return;
        }

        //search for student with matching ID
        Course.Student currentStudent = currentCourse.studentListHead;
        while (currentStudent != null && !currentStudent.studentId.equals(rmvId)) {
            currentStudent = currentStudent.studentNext;
        }
        if (currentStudent == null) {
            System.out.println("\n❌No student found with that ID!");
            return;
        }

        //remove student from list
        if (currentStudent.studentPrevious == null) {
            currentCourse.studentListHead = currentStudent.studentNext;
        } else {
            currentStudent.studentPrevious.studentNext = currentStudent.studentNext;
        }

        if (currentStudent.studentNext != null) {
            currentStudent.studentNext.studentPrevious = currentStudent.studentPrevious;      //update next student's previous reference
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

            switch (choice) {
                case "1" :
                    Scanner cAdd = new Scanner(System.in);
                    //prompt for course details
                    System.out.print("\nCourse Name: ");
                    String courseName = cAdd.next();
                    System.out.print("Course Id: ");
                    String courseId = cAdd.next();
                    System.out.print("Day: ");
                    String courseDay = cAdd.next();
                    System.out.print("Start Time: ");
                    String courseStartTime = cAdd.next();
                    System.out.print("End Time: ");
                    String courseEndTime = cAdd.next();
                    System.out.print("Lecturer Name: ");
                    String courseLecturerName = cAdd.next();
                    Course.Student studentList = null;
                    addCourse(courseName, courseId, courseDay, courseStartTime, courseEndTime, courseLecturerName, studentList);
                    break;
                case "2" :
                    Scanner cRmv = new Scanner(System.in);
                    //prompt for a course to be removed
                    System.out.print("\nCourse Name: ");
                    String rmvCourseName = cRmv.nextLine();
                    removeCourse(rmvCourseName);
                    break;
                case "3" :
                    Scanner cModify = new Scanner(System.in);
                    //prompt for a course to be modified
                    System.out.print("\nCourse Name: ");
                    String modCourseName = cModify.nextLine();
                    //modify course with new information
                    System.out.println("\nEnter new course information: ");
                    System.out.print("Day: ");
                    String day = cModify.nextLine();
                    System.out.print("Start Time: ");
                    String startTime = cModify.nextLine();
                    System.out.print("End Time: ");
                    String endTime = cModify.nextLine();
                    System.out.print("Lecturer Name: ");
                    String lecturerName = cModify.nextLine();
                    modifyCourse(modCourseName, day, startTime, endTime, lecturerName);
                    break;
                case "4" :
                    viewCourse();
                    break;
                case "5" :
                    Scanner srchName = new Scanner(System.in);
                    //prompt for a course to search
                    System.out.print("\nCourse Name: ");
                    String srchCourse = srchName.nextLine();
                    searchCoursebyName(srchCourse);
                    break;
                case "6" :
                    Scanner addStud = new Scanner(System.in);
                    //prompt for student details
                    System.out.print("\nEnter student name: ");
                    String name = addStud.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = addStud.nextLine();
                    //prompt for course name to add the student
                    System.out.print("Enter course name to add the student: ");
                    String addTo = addStud.nextLine();
                    addStudent(name, id, addTo);
                    break;
                case "7" :
                    Scanner rmvStud = new Scanner(System.in);
                    //prompt the course name and student id to be removed
                    System.out.print("\nCourse Name: ");
                    String rmvName = rmvStud.nextLine();
                    System.out.print("Student ID: ");
                    String rmvId = rmvStud.nextLine();
                    removeStudent(rmvName, rmvId);
                    break;
            }
        } while(!choice.equals("8"));
    }
}
