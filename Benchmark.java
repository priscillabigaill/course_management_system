public class Benchmark {


        public static void main(String[] args) {
            long startTime = System.currentTimeMillis();

            // Perform your operations

            //
            BinarySearchTree test = new BinarySearchTree();

            // add course
            test.addCourse("Math", "1234", "Monday", "12.00", "14.00", "Abigail");
            test.addCourse("Chemistry", "2345", "Tuesday", "12.00", "14.00", "Jeffrey");
            test.addCourse("History", "3456", "Wednesday", "12.00", "14.00", "Audrey");
            test.addCourse("Economics", "4567", "Thursday", "12.00", "14.00", "Lenno");
            test.addCourse("Biology", "5678", "Friday", "12.00", "14.00", "Randy");

            // remove course
            test.removeCourse("Economics");

            // modify course
            test.modifyCourse("Chemistry","Physics", "7777", "Thursday", "12.00", "14.00", "Aubert");

            // view course
            test.viewCourses();

            // search course by name
            test.searchCourseByName("Math");

            // add student
            test.addStudent("Abigail", "7777", "2345");
            test.addStudent("Jeffrey", "7887", "3456");

            // remove student


            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;

            System.out.println("\nTime used: " + elapsedTime + " milliseconds");
        }

}
