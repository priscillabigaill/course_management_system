import java.util.ArrayList;
import java.util.Scanner;

public class ArraylistBenchmark {
    //create a courseList arrayList that will store all courses
    private static ArrayList<Course> courseList = new ArrayList<>();

    //create a course class as a collection of courses for arraylist
    private static class Course {
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

        //setters and getters method
        public String getCourseName() {
            return this.courseName;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public void setCourseID(String courseId) {
            this.courseId = courseId;
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

        //create a student class as a collection of students for arraylist
        private static class Student {
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
    }

    /**********************
     *   (1) Add Course   *
     **********************/
    public static void addCourse(String courseName, String courseId, String courseDay, String courseStartTime, String courseEndTime, String courseLecturerName) {
        //create a new course object and add it to the courseList
        Course newCourse = new Course(courseName, courseId, courseDay, courseStartTime, courseEndTime, courseLecturerName);
        courseList.add(newCourse);
    }

    /***********************
     *  (2) Remove Course  *
     ***********************/
    public static void removeCourse(String courseName) {
        //check if the course list is empty
        if (courseList.isEmpty()) {
            return;
        }

        //iterate over the course list in reverse order to find the matching course name
        for (int i = courseList.size() - 1; i >= 0; i--) {
            Course course = courseList.get(i);
            //if found, remove the course from the courseList
            if (course.getCourseName().equals(courseName)) {
                courseList.remove(i);
                return;
            }
        }
    }

    /***********************
     *  (3) Modify Course  *
     ***********************/
    public static void modifyCourse(String courseName, String newCourseDay, String newCourseStartTime, String newCourseEndTime, String newCourseLecturerName) {
        //search for course with matching course name
        for (Course course : courseList) {
            if (course.getCourseName().equals(courseName)) {
                //update the course by setting all the modified course information
                course.setCourseDay(newCourseDay);
                course.setCourseStartTime(newCourseStartTime);
                course.setCourseEndTime(newCourseEndTime);
                course.setCourseLecturerName(newCourseLecturerName);
                return;
            }
        }
    }

    /*******************************
     *  (5) Search Course by Name  *
     *******************************/
    public static boolean searchCoursebyName(String courseNameToSearch) {
        boolean courseFound = false;

        //iterate over the course list to find the specified course
        for (Course course : courseList) {
            //if found, print the course details
            if (course.getCourseName().equals(courseNameToSearch)) {
                courseFound = true;
                break;
            }
        }
        return courseFound;
    }

    /*********************************
     *  (6) Add Student to a course  *
     *********************************/
    public static void addStudent(String studentName, String studentId, String courseName) {
        //check if the course list is empty
        if (courseList.isEmpty()) {
            return;
        }

        //create a new student object
        Course.Student newStudent = new Course.Student(studentName, studentId);

        //iterate over the course list to find the specified course
        for (Course course : courseList) {
            if (course.getCourseName().equals(courseName)) {
                //if the specified course if found, adding the student to the course
                course.getStudents().add(newStudent);
                return;
            }
        }
    }

    /**************************************
     *  (7) Remove Student from a course  *
     **************************************/
    public static void removeStudent(String courseNameToRemoveStudent, String studentIdToRemove) {
        //check if the course list is empty
        if (courseList.isEmpty()) {
            return;
        }

        //iterate over the course list in reverse order to find the matching course name
        for (int i = courseList.size() - 1; i >= 0; i--) {
            Course course = courseList.get(i);
            //if course is found, iterate over the student list to find the matching student with the ID
            if (course.getCourseName().equals(courseNameToRemoveStudent)) {
                for (int j = course.getStudents().size() - 1; j >= 0; j--) {
                    Course.Student student = course.getStudents().get(j);
                    //if the student exists in that course, remove the student from the studentList
                    if (student.getStudentId().equals(studentIdToRemove)) {
                        course.getStudents().remove(j);
                        return;
                    }
                }

                //if no matching student ID is found
                return;
            }
        }
    }
}
