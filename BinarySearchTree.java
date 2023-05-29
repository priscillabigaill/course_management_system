import java.util.Scanner;

public class BinarySearchTree {

    public static void displayMenu() {
        System.out.println("\n🏫 Welcome Admin to our course management system!");
        System.out.println("****************************************************");
        System.out.println("(1) Add course");
        System.out.println("(2) Remove course");
        System.out.println("(3) Edit course");
        System.out.println("(4) View course details");
        System.out.println("(6) Add student to a course");
        System.out.println("(7) Remove student from a course");
        System.out.println("(8) Exit");
        System.out.println("****************************************************");
        System.out.print("Choose a command: ");
    }

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
    public static void addCourse(String courseNew, String idNew, String dayNew, String startTimeNew, String endTimeNew, String lectureNameNew) {
        // create a new course object
        Course newCourse = new Course(courseNew, idNew, dayNew, startTimeNew, endTimeNew, lectureNameNew);

        if (root == null) {
            // if the root is null, make the new course the root
            root = newCourse;
        } else {
            // find the appropriate position to insert the new course in the binary tree
            Course current = root;
            while (true) {
                // compare the course name to determine if it should go left or right
                if (courseNew.compareToIgnoreCase(current.courseName) < 0) {
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
        System.out.println("\n✅ The course has been successfully added");
    }

    /***********************
     *  (2) Remove Course  *
     ***********************/

    // public static void removeCourse(String courseName) {
    //     // initialize a variable current as the root of the binary tree
    //     Course current = root;
    //     // traverse the binary tree to try and find a course with the inputted name
    //     while (current != null) {
    //         int cmp = courseName.compareToIgnoreCase(current.courseName);
    //         if (cmp == 0) {
    //             break;
    //         } else if (cmp < 0) {
    //             current = current.left;
    //         } else {
    //             current = current.right;
    //         }
    //     }
    //     // if course is not found
    //     if (current == null) {  
    //         System.out.println("Course not found.");
    //         return;
    //     }

    //     // If the node has no children
    //     if (current.left == null && current.right == null) {
    //         // if it is the root
    //         if (current == root) {
    //             // remove it
    //             root = null;
    //         } else {
    //             // if it is not the root
    //             Course parent = current.parent;
    //             // check whether current is its parent's left or right child, then remove it
    //             if (current == parent.left) {
    //                 parent.left = null;
    //             } else {
    //                 parent.right = null;
    //             }
    //         }

    //         // if the node has two children
    //     } else if (current.left != null && current.right != null) {
    //         // set successor as right child of current node
    //         // (because successor is always on the right subtree)
    //         Course successor = current.right;
    //         // traverse to the leftmost node (successor)
    //         while (successor.left != null) {
    //             successor = successor.left;
    //         }
    //         // swap left child of current node to the left child of successor
    //         successor.left = current.left;
    //         // if the successor is not the right child of the current node,
    //         // swap the right child of the current node with the right child of the successor
    //         if (successor != current.right) {
    //             successor.right = current.right;
    //         }
    //         // if the current node is the root, set the root to the successor
    //         if (current == root) {
    //             root = successor;

    //             // otherwise, set the parent's child pointer to the successor
    //         } else {
    //             Course parent = current.parent;
    //             if (current == parent.left) {
    //                 parent.left = successor;
    //             } else {
    //                 parent.right = successor;
    //             }
    //             successor.parent = parent;
    //         }
    //         //if the node only has one child
    //     } else {
    //         // remove it and connect the child to the parent
    //         Course child = current.left != null ? current.left : current.right;
    //         // if the current node is the root, set the root to the child
    //         if (current == root) {
    //             root = child;
    //         } else { // otherwise, set the parent's child pointer to the child
    //             Course parent = current.parent;
    //             // if current node is the left child
    //             if (current == parent.left) {
    //                 parent.left = child;
    //             } else { // if current node is the right child
    //                 parent.right = child;
    //             }
    //         }
    //     }

    //     System.out.println("Course successfully removed.");
    // }

    public static void removeCourse(String courseName) {
        // initialize a variable current as the root of the binary tree
        Course current = root;
        // initialize a variable parent as null
        Course parent = null;

        // traverse the binary tree to try and find a course with the inputted name
        while (current != null) {
            int cmp = courseName.compareToIgnoreCase(current.courseName);
            if (cmp == 0) {
                break;
            } else if (cmp < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }

        // if course is not found
        if (current == null) {
            System.out.println("Course not found.");
            return;
        }

        // If the node has no children
        if (current.left == null && current.right == null) {
            // if it is the root
            if (current == root) {
                // remove it
                root = null;
            } else {
                // if it is not the root
                // check whether current is its parent's left or right child, then remove it
                if (current == parent.left) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        // if the node has two children
        else if (current.left != null && current.right != null) {
            // set successor as right child of current node
            // (because successor is always on the right subtree)
            Course successor = current.right;
            // traverse to the leftmost node (successor)
            while (successor.left != null) {
                successor = successor.left;
            }
            // swap left child of current node to the left child of successor
            successor.left = current.left;
            // if the successor is not the right child of the current node,
            // swap the right child of the current node with the right child of the successor
            if (successor != current.right) {
                successor.right = current.right;
            }
            // if the current node is the root, set the root to the successor
            if (current == root) {
                root = successor;
            } else {
                // otherwise, set the parent's child pointer to the successor
                if (current == parent.left) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
            }
            successor.parent = parent;
        }
        // if the node only has one child
        else {
            // remove it and connect the child to the parent
            Course child = current.left != null ? current.left : current.right;
            // if the current node is the root, set the root to the child
            if (current == root) {
                root = child;
            } else {
                // otherwise, set the parent's child pointer to the child
                if (current == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }

        System.out.println("Course successfully removed.");
    }

    /***********************
    *  (3) Modify Course  *
    ***********************/
    public static void modifyCourse(String courseName, String newCourseName, String courseID, String day, String startTime, String endTime, String lecturerName) {
        // search for course with matching name
        Course currentCourse = root;
        while (currentCourse != null && !currentCourse.courseName.equals(courseName)) {
            currentCourse = currentCourse.left != null ? currentCourse.left : currentCourse.right;
        }

        // if the course is not found
        if (currentCourse == null) {
            System.out.println("\n❌No course found with that name!");
            return;
        }

        // if course is found
        
        // modify course with new information

        currentCourse.courseName = newCourseName;
        currentCourse.courseId = courseID;
        currentCourse.courseDay = day;
        currentCourse.courseStartTime = startTime;
        currentCourse.courseEndTime = endTime;
        currentCourse.courseLecturerName = lecturerName;

        System.out.println("\n✅Successfully updated course!");
    }


    /***********************
     *   (4) View Courses   *
     ***********************/

    public static void viewCourses() {

        // check if there are courses available
        if (root == null) {
            System.out.println("\n❌No courses available.");
        } else {
            // if there are courses available
            // calls the recursive method to traverse and print each course's details
            viewCourse(root);
        }
    }
    // the recursive method that prints the details of a course
    private static void viewCourse(Course node) {
        if (node != null) {
            // recursively calls the method on the left nodes
            viewCourse(node.left);

            System.out.println("\n-Course Details-");
            System.out.println("Course Name: " + node.courseName);
            System.out.println("Course ID: " + node.courseId);
            System.out.println("Day: " + node.courseDay);
            System.out.println("Start Time: " + node.courseStartTime);
            System.out.println("End Time: " + node.courseEndTime);
            System.out.println("Lecturer Name: " + node.courseLecturerName);

            // recursively calls the method on the right nodes
            viewCourse(node.right);
        }
    }


    /*******************************
    *  (5) Search Course by Name  *
    *******************************/

    public static void searchCourseByName(String courseName) {
        // Recursively search for the specified course in the tree
        boolean found = searchCourseByName(root, courseName);

        // If the course was not found, display a message
        if (!found) {
            System.out.println("❌No course found with that name!");
        }
    }

    // a recursive method that searches for a course by its name
    // returns true if the course is found, and false otherwise
    private static boolean searchCourseByName(Course node, String courseName) {
        // check if current node is empty
        if (node == null) {
            return false;
        }
        // if the current node matches the specified course name, display the course details
        if (node.courseName.equals(courseName)) {
            System.out.println("\n-Course Details-");
            System.out.println("Course Name: " + node.courseName);
            System.out.println("Course ID: " + node.courseId);
            System.out.println("Day: " + node.courseDay);
            System.out.println("Start Time: " + node.courseStartTime);
            System.out.println("End Time: " + node.courseEndTime);
            System.out.println("Lecturer Name: " + node.courseLecturerName + "\n");

            //check if there are any enrolled students in the course
            if (node.studentListHead == null) {
                System.out.println("No students enrolled.");
            } else {
                System.out.print("-Enrolled Students-");
                Course.Student currentStudent = node.studentListHead;
                while (currentStudent != null) {
                    //display details of each enrolled student
                    System.out.print("\nName (ID): " + currentStudent.studentName + " (" + currentStudent.studentId + ")");
                    currentStudent = currentStudent.next;
                }
                System.out.println("\n");
            }
            return true;
        }

        // Recursively search the left and right subtrees
        boolean foundLeft = searchCourseByName(node.left, courseName);
        boolean foundRight = searchCourseByName(node.right, courseName);
        return foundLeft || foundRight;
    }



    /*********************************
     *  (6) Add Student to a course  *
     *********************************/

    public static void addStudent(String name, String id, String courseId) {
        // check if the tree is empty (no courses available)
        if (root == null) {
            System.out.println("\n❌No course available!");
            return;
        }

        // create new student object with inputted details
        Course.Student newStudent = new Course.Student(name, id);

        // search for course and add the student if found
        boolean found = addStudentToCourse(root, courseId, newStudent);

        // if course was not found
        if (!found) {
            System.out.println("❌Course not found.");
        }
    }

    // a recursive method that searches for a course with the specified id
    // returns true if course is found, false otherwise
    private static boolean addStudentToCourse(Course node, String courseId, Course.Student newStudent) {
        // checks if current node is null
        if (node == null) {
            return false;
        }
        // if the current node matches the specified course ID, add the student to the course
        if (node.courseId.equals(courseId)) {
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
            System.out.println("\n✅ Student added to the course successfully.");
            return true;
        }

        // recursively search the left and right subtrees
        boolean found = addStudentToCourse(node.left, courseId, newStudent);
        if (!found) {
            found = addStudentToCourse(node.right, courseId, newStudent);
        }
        return found;
    }

    /**************************************
     *  (7) Remove Student from a course  *
     **************************************/

    public static void removeStudent(String rmvCourseId, String rmvStudentId) {
        // check if tree is empty
        if (root == null) {
            System.out.println("\n❌No course available!");
            return;
        }

        // recursively search for the course with the specified ID in the tree
        Course course = findCourseById(root, rmvCourseId);

        // if the course was not found
        if (course == null) {
            System.out.println("❌Course not found.");
            return;
        }

        // if course is found
        // remove student from the course
        boolean removed = removeStudentFromCourse(course, rmvStudentId);

        // if student was not found in the course
        if (!removed) {
            System.out.println("❌Student not found in the course.");
        } else {
            System.out.println("✅Student removed from the course successfully.");
        }
    }

    // helper method to find the course with the specified id
    private static Course findCourseById(Course node, String rmvCourseId) {
        // check if node is empty
        if (node == null) {
            return null;
        }
        // if the current node matches the specified course id
        if (node.courseId.equals(rmvCourseId)) {
            return node;
        }
        // recursively search the left and right subtrees
        Course found = findCourseById(node.left, rmvCourseId);
        if (found == null) {
            found = findCourseById(node.right, rmvCourseId);
        }
        // return course that was found
        return found;
    }

    // helper method to remove the student from the course
    private static boolean removeStudentFromCourse(Course course, String rmvStudentId) {
        // pointer to current student
        Course.Student current = course.studentListHead;
        // pointer to previous student
        Course.Student prev = null;

        // traverse the student list and find the student to remove
        while (current != null) {
            if (current.studentId.equals(rmvStudentId)) {
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
    
    //Main Method and Program Execution//
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            displayMenu();
            choice = input.nextLine();

            switch (choice) {
                case "1":
                    Scanner add = new Scanner(System.in);
                    // prompt for course details
                    System.out.print("\nCourse Name: ");
                    String courseNew = add.nextLine();
                    System.out.print("Course Id: ");
                    String idNew = add.nextLine();
                    System.out.print("Day: ");
                    String dayNew = add.nextLine();
                    System.out.print("Start Time: ");
                    String startTimeNew = add.nextLine();
                    System.out.print("End Time: ");
                    String endTimeNew = add.nextLine();
                    System.out.print("Lecturer Name: ");
                    String lectureNameNew = add.nextLine();
                    addCourse(courseNew, idNew, dayNew, startTimeNew, endTimeNew, lectureNameNew);
                case "2":
                    Scanner rmv = new Scanner(System.in);
                    System.out.print("Enter course name to remove: ");
                    String courseName = rmv.next();
                    removeCourse(courseName);
               case "3":
                    Scanner modify = new Scanner(System.in);
                    System.out.print("Enter the name of the course to modify: ");
                    String courseToModify = modify.nextLine();
                    System.out.print("Enter the new course name: ");
                    String newCourseName = modify.nextLine();
                    System.out.print("Enter the new course ID: ");
                    String newCourseID = modify.nextLine();
                    System.out.print("Enter the new course day: ");
                    String newCourseDay = modify.nextLine();
                    System.out.print("Enter the new course start time: ");
                    String newCourseStartTime = modify.nextLine();
                    System.out.print("Enter the new course end time: ");
                    String newCourseEndTime = modify.nextLine();
                    System.out.print("Enter the new course lecturer name: ");
                    String newLecturerName = modify.nextLine();
                    modifyCourse(courseToModify, newCourseName, newCourseID, newCourseDay, newCourseStartTime, newCourseEndTime, newLecturerName);
                case "4" : viewCourses();
                case "5":
                    Scanner search = new Scanner(System.in);
                    System.out.print("\nCourse Name: ");
                    String courseToSearch = search.nextLine();
                    searchCourseByName(courseToSearch);
                case "6":
                    // prompt user to input needed details
                    Scanner AddStud = new Scanner(System.in);
                    System.out.print("\nEnter student name: ");
                    String name = AddStud.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = AddStud.nextLine();
                    // prompt user to enter course id
                    System.out.print("Enter course ID to add the student: ");
                    String courseId = AddStud.nextLine();
                    addStudent(name, id, courseId);
                case "7": 
                    // prompt user to input course id ans student id
                    Scanner rmov = new Scanner(System.in);
                    System.out.print("\nCourse ID: ");
                    String rmvCourseId = rmov.nextLine();
                    System.out.print("Student ID: ");
                    String rmvStudentId = rmov.nextLine();
                    removeStudent(rmvCourseId, rmvStudentId);
                    removeStudent();
            }
        } while(!choice.equals("8"));
    }
}
