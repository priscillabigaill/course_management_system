public class BinarysearchtreeBenchmark {

    private static class Course {
        // inner class representing a course
        private String courseName;
        private String courseId;
        private String courseDay;
        private String courseStartTime;
        private String courseEndTime;
        private String courseLecturerName;
        private Course left;
        private Course right;
        private Course parent;
        private Student studentListHead;
        private Student studentListTail;

        // constructor for the class
        public Course(String courseName, String courseId, String courseDay, String courseStartTime, String courseEndTime, String courseLecturerName) {
            this.courseName = courseName;
            this.courseId = courseId;
            this.courseDay = courseDay;
            this.courseStartTime = courseStartTime;
            this.courseEndTime = courseEndTime;
            this.courseLecturerName = courseLecturerName;
            this.left = null;
            this.right = null;
            this.studentListHead = null;
            this.studentListTail = null;
        }

        private static class Student {
            // inner class representing a student
            private String studentName;
            private String studentId;
            private Student next;

            // constructor for student class
            public Student(String studentName, String studentId) {
                this.studentName = studentName;
                this.studentId = studentId;
                this.next = null;
            }
        }
    }

    private static Course root = null;

    /**********************
     *   (1) Add Course   *
     **********************/
    public static void addCourse(String courseName, String courseId, String courseDay, String courseStartTime, String courseEndTime, String courseLecturerName) {
        // create a new course object
        Course newCourse = new Course(courseName, courseId, courseDay, courseStartTime, courseEndTime, courseLecturerName);

        if (root == null) {
            // if the root is null, make the new course the root
            root = newCourse;
        } else {
            // find the appropriate position to insert the new course in the binary tree
            Course current = root;
            while (true) {
                // compare the course name to determine if it should go left or right
                if (courseName.compareToIgnoreCase(current.courseName) < 0) {
                    if (current.left == null) {
                        // if the left node is null, insert the new course here
                        current.left = newCourse;
                        break;
                    } else {
                        // otherwise, continue traversing down the left subtree
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        // if the right node is null, insert the new course here
                        current.right = newCourse;
                        break;
                    } else {
                        // otherwise, continue traversing down the right subtree
                        current = current.right;
                    }
                }
            }
        }
    }

    /***********************
     *  (2) Remove Course  *
     ***********************/
    public static void removeCourse(String courseName) {
        // Check if the tree is empty
        if (root == null) {
            System.out.println("\n❌No courses available.");
            return;
        }

        // Find the course to be removed and its parent node
        Course current = root;
        Course parent = null;

        while (current != null && !current.courseName.equalsIgnoreCase(courseName)) {
            parent = current;
            int cmp = courseName.compareToIgnoreCase(current.courseName);

            if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // If the course is not found
        if (current == null) {
            System.out.println("❌Course not found.");
            return;
        }

        // Remove the course from the tree
        if (current == root) {
            root = removeCourseNode(current);
        } else if (parent.left == current) {
            parent.left = removeCourseNode(current);
        } else {
            parent.right = removeCourseNode(current);
        }

        System.out.println("✅Course successfully removed.");
    }

    // Helper method to remove the course node
    private static Course removeCourseNode(Course course) {
        // Case 1: The course has no children
        if (course.left == null && course.right == null) {
            return null;
        }

        // Case 2: The course has only one child
        if (course.left == null) {
            return course.right;
        }
        if (course.right == null) {
            return course.left;
        }

        // Case 3: The course has two children
        Course successor = findSuccessor(course.right);
        successor.left = course.left;
        return course.right;
    }

    // Helper method to find the successor node (smallest node in the right subtree)
    private static Course findSuccessor(Course node) {
        Course parent = null;
        while (node.left != null) {
            parent = node;
            node = node.left;
        }
        if (parent != null) {
            parent.left = node.right;
            node.right = null;
        }
        return node;
    }

    /***********************
     *  (3) Modify Course  *
     ***********************/
    public static void modifyCourse(String courseName, String day, String startTime, String endTime, String lecturerName) {
        // search for course with matching name
        Course currentCourse = root;
        while (currentCourse != null && !currentCourse.courseName.equals(courseName)) {
            currentCourse = currentCourse.left != null ? currentCourse.left : currentCourse.right;
        }

        // if the course is not found
        if (currentCourse == null) {
            return;
        }

        // if course is found

        // modify course with new information
        currentCourse.courseDay = day;
        currentCourse.courseStartTime = startTime;
        currentCourse.courseEndTime = endTime;
        currentCourse.courseLecturerName = lecturerName;
    }


    /*******************************
     *  (5) Search Course by Name  *
     *******************************/
    public static void searchCoursebyName(String courseName) {
        // Recursively search for the specified course in the tree
        boolean found = searchCoursebyName(root, courseName);

        // If the course was not found, display a message
        if (!found) {
        }
    }

    // a recursive method that searches for a course by its name
    // returns true if the course is found, and false otherwise
    private static boolean searchCoursebyName(Course node, String courseName) {
        // check if current node is empty
        if (node == null) {
            return false;
        }
        // if the current node matches the specified course name, display the course details
        if (node.courseName.equals(courseName)) {

            //check if there are any enrolled students in the course
            if (node.studentListHead == null) {
            } else {
                Course.Student currentStudent = node.studentListHead;
                while (currentStudent != null) {
                    currentStudent = currentStudent.next;
                }
            }
            return true;
        }

        // Recursively search the left and right subtrees
        boolean foundLeft = searchCoursebyName(node.left, courseName);
        boolean foundRight = searchCoursebyName(node.right, courseName);
        return foundLeft || foundRight;
    }



    /*********************************
     *  (6) Add Student to a course  *
     *********************************/

    public static void addStudent(String name, String id, String courseName) {
        // check if the tree is empty (no courses available)
        if (root == null) {
            return;
        }

        // create new student object with inputted details
        Course.Student newStudent = new Course.Student(name, id);

        // search for course and add the student if found
        boolean found = addStudentToCourse(root, courseName, newStudent);

        // if course was not found
        if (!found) {
        }
    }

    // a recursive method that searches for a course with the specified id
    // returns true if course is found, false otherwise
    private static boolean addStudentToCourse(Course node, String courseName, Course.Student newStudent) {
        // checks if current node is null
        if (node == null) {
            return false;
        }
        // if the current node matches the specified course ID, add the student to the course
        if (node.courseId.equals(courseName)) {
            if (node.studentListHead == null) {
                // if the student list is empty, set the new student as the head of the list
                node.studentListHead = node.studentListTail = newStudent;
                node.studentListHead.next = null;
                node.studentListTail.next = null;
            } else {
                // if the student list is not empty, iterate to the end of the list and add the new student
                node.studentListTail.next = newStudent;
                newStudent.next = null;
                node.studentListTail = newStudent;
            }
            return true;
        }

        // recursively search the left and right subtrees
        boolean found = addStudentToCourse(node.left, courseName, newStudent);
        if (!found) {
            found = addStudentToCourse(node.right, courseName, newStudent);
        }
        return found;
    }

    /**************************************
     *  (7) Remove Student from a course  *
     **************************************/

    public static void removeStudent(String courseName, String studentId) {
        // check if tree is empty
        if (root == null) {
            return;
        }

        // recursively search for the course with the specified ID in the tree
        Course course = findCourseById(root, courseName);

        // if the course was not found
        if (course == null) {
            return;
        }

        // if course is found
        // remove student from the course
        boolean removed = removeStudentFromCourse(course, studentId);

        // if student was not found in the course
        if (!removed) {
        } else {
        }
    }

    // helper method to find the course with the specified id
    private static Course findCourseById(Course node, String courseName) {
        // check if node is empty
        if (node == null) {
            return null;
        }
        // if the current node matches the specified course id
        if (node.courseId.equals(courseName)) {
            return node;
        }
        // recursively search the left and right subtrees
        Course found = findCourseById(node.left, courseName);
        if (found == null) {
            found = findCourseById(node.right, courseName);
        }
        // return course that was found
        return found;
    }

    // helper method to remove the student from the course
    private static boolean removeStudentFromCourse(Course course, String studentId) {
        // pointer to current student
        Course.Student current = course.studentListHead;
        // pointer to previous student
        Course.Student prev = null;

        // traverse the student list and find the student to remove
        while (current != null) {
            if (current.studentId.equals(studentId)) {
                // if the student is found
                // check if student is the head of the list
                if (prev == null) {
                    // if the student is the head of the list, update the head
                    course.studentListHead = current.next;
                } else {
                    // update the previous student's next pointer
                    prev.next = current.next;
                }
                // update the tail if the student is the tail of the list
                if (current == course.studentListTail) {
                    course.studentListTail = prev;
                }
                return true;
            }
            // update previous student
            prev = current;
            // move to next student
            current = current.next;
        }
        return false;
    }
}
