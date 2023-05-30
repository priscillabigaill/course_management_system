import java.util.*;

public class HashMapBenchmark {
    private static HashMap<String, Course> courses = new HashMap<>();

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
    public static void addCourse(String courseName, String courseId, String courseDay, String courseStartTime, String courseEndTime, String courseLecturerName) {
        // create a new course object
        Course newCourse = new Course(courseName, courseId, courseDay, courseStartTime, courseEndTime, courseLecturerName);

        courses.put(courseName, newCourse);
    }

    /***********************
     *  (2) Remove Course  *
     ***********************/
    public static void removeCourse(String courseName) {

        if (courses.containsKey(courseName)) {
            courses.remove(courseName);
        } else {
        }
    }

    /***********************
     *  (3) Modify Course  *
     ***********************/
    public static void modifyCourse(String courseName, String day, String startTime, String endTime, String lecturerName) {
        if (!courses.containsKey(courseName)) {
            return;
        }

        Course currentCourse = courses.get(courseName);

        //update course
        currentCourse.courseDay = day;
        currentCourse.courseStartTime = startTime;
        currentCourse.courseEndTime = endTime;
        currentCourse.courseLecturerName = lecturerName;
    }

    /***********************
     *   (4) View Course   *
     ***********************/
    public static void viewCourse() {
        //check if the course list is empty
        if (courses.isEmpty()) {
        } else {
            for (Map.Entry<String, Course> entry : courses.entrySet()) {
                Course currentCourse = entry.getValue();
            }
        }
    }

    /*******************************
     *  (5) Search Course by Name  *
     *******************************/
    public static void searchCoursebyName(String courseName) {
        // search for the course in the HashMap
        Course course = courses.get(courseName);

        if (course != null) {
            // if the course is found, display its details

            // display the list of enrolled students
            if (course.studentMap.isEmpty()) {

            } else {
                for (String studentId : course.studentMap.keySet()) {
                    Course.Student student = course.studentMap.get(studentId);
                }
            }
        } else {
            // if the course is not found, display an error message
        }
    }

    /*********************************
     *  (6) Add Student to a course  *
     *********************************/
    public static void addStudent(String name, String id, String courseName) {
        //check if the list is empty
        if (courses.isEmpty()) {
            return;
        }

        //create a new student object
        Course.Student newStudent = new Course.Student(name, id);

        //find the course with the specified ID
        Course currentCourse = courses.get(courseName);

        if (currentCourse != null) {
            //if the specified course is found, adding the student to the course
            currentCourse.studentMap.put(id, newStudent);
        } else {
            //if the specified course is not found
        }
    }

    /**************************************
     *  (7) Remove Student from a course  *
     **************************************/
    public static void removeStudent(String courseName, String studentId) {
        //check if the map is empty
        if (courses.isEmpty()) {
            return;
        }

        //get the course with matching ID
        Course currentCourse = courses.get(courseName);
        if (currentCourse == null) {
            return;
        }

        //get the student with matching ID
        Course.Student currentStudent = currentCourse.studentMap.get(studentId);
        if (currentStudent == null) {
            return;
        }

        //remove student from map
        currentCourse.studentMap.remove(studentId);
    }
}

