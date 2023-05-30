import java.util.Scanner;

public class LinkedlistBenchmark {
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
    }

    /***********************
     *  (2) Remove Course  *
     ***********************/
    public static void removeCourse(String rmvCourseName) {
        //check if the list is empty
        if (head == null) {
            return;
        }

        //search for the course with the matching name
        Course currentCourse = head;
        while (currentCourse != null && !currentCourse.courseName.equals(rmvCourseName)) {
            currentCourse = currentCourse.courseNext;
        }
        //reach the end of the linkedList without finding a matching course name
        if (currentCourse == null) {
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
    }

    /***********************
     *  (3) Modify Course  *
     ***********************/
    public static void modifyCourse(String modCourseName, String day, String startTime, String endTime, String lecturerName) {
        //check if the list is empty
        if (head == null) {
            return;
        }

        //search for course with matching name
        Course currentCourse = head;
        while (currentCourse != null && !currentCourse.courseName.equals(modCourseName)) {
            currentCourse = currentCourse.courseNext;
        }
        //if the course is not found
        if (currentCourse == null) {
            return;
        }

        //update course
        currentCourse.courseDay = day;
        currentCourse.courseStartTime = startTime;
        currentCourse.courseEndTime = endTime;
        currentCourse.courseLecturerName = lecturerName;

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
                //check if there are any enrolled students in the course
                if (currentCourse.studentListHead == null) {
                } else {
                    Course.Student currentStudent = currentCourse.studentListHead;
                    while (currentStudent != null) {
                        //display details of each enrolled student
                        currentStudent = currentStudent.studentNext;
                    }
                }
                found = true;
            }
            currentCourse = currentCourse.courseNext;
        }

    }

    /*********************************
     *  (6) Add Student to a course  *
     *********************************/
    public static void addStudent(String name, String id, String addTo) {
        //check if the course list is empty
        if (head == null) {
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
                return;
            }
            currentCourse = currentCourse.courseNext;
        }
    }

    /**************************************
     *  (7) Remove Student from a course  *
     **************************************/
    public static void removeStudent(String rmvName, String rmvId) {
        //check if the course list is empty
        if (head == null) {
            return;
        }

        //search for course with matching name
        Course currentCourse = head;
        while (currentCourse != null && !currentCourse.courseName.equals(rmvName)) {
            currentCourse = currentCourse.courseNext;
        }
        if (currentCourse == null) {
            return;
        }

        //search for student with matching ID
        Course.Student currentStudent = currentCourse.studentListHead;
        while (currentStudent != null && !currentStudent.studentId.equals(rmvId)) {
            currentStudent = currentStudent.studentNext;
        }
        if (currentStudent == null) {
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
    }
}