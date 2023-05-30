import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Benchmark {

    public static void main(String[] args) {
        // call readCourse function
        readCourse();

        // BST
        BinarySearchTreeBenchmark test = new BinarySearchTreeBenchmark();

        long startTime = System.nanoTime();

        // add course (10 course)
        for (int i=0; i<10 && i<courseCount; i++) {
            test.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
        }

        // remove course
        for (int i=0; i<10 && i<courseCount; i++) {
            test.removeCourse(courseName[i]);
        }

        // modify course
        for (int i=0; i<10 && i<courseCount; i++) {
            test.modifyCourse(courseName[i], "Physics", "7777", "Thursday", "12.00", "14.00", "Auber");
        }

        // search course by name
//        test.searchCourseByName("Math");
//        test.searchCourseByName("Biology");
//        test.searchCourseByName("Physics");
//        test.searchCourseByName("History");
        // add student
//        test.addStudent("Abigail", "3532", "7777");
//        test.addStudent("Jeffrey", "7887", "3456");
        // remove student
//        test.removeStudent("7777", "3532");
//        test.removeStudent("3456", "7887");


        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000.0;

        // DecimalFormat decimalFormat = new DecimalFormat();
        // System.out.println("\nTime used: " + decimalFormat.format(elapsedTime) + " milliseconds");
        System.out.println("\nTime used: " + elapsedTime + " milisecond(s)");

        // System.out.printf("\nTime used: %.2f miliseconds", elapsedTime);
    }

    static String[] courseName = new String[30];
    static String[] courseId = new String[30];
    static String[] courseDay = new String[30];
    static String[] courseStartTime = new String[30];
    static String[] courseEndTime = new String[30];
    static String[] lecturerName = new String[30];


    // Counter variable to keep track of the number of users
    private static int courseCount = 0;

    public static void readCourse(){
        try {
            String fileName = "courseData.txt";
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            // Read each line of the file until reaching the end (null)
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts.length >= 8) {
                    String name = parts[0];
                    String id = parts[1];
                    String day = parts[2];
                    String start = parts[3];
                    String end = parts[4];
                    String lname = parts[5];

                    courseName[courseCount] = name;
                    courseId[courseCount] = id;
                    courseDay[courseCount] = day;
                    courseStartTime[courseCount] = start;
                    courseEndTime[courseCount] = end;
                    lecturerName[courseCount] = lname;
                    courseCount++;
                }
            }
            // Handle the case where the file is not found
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            // Handle the case where there is an error reading the file
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }


    static String[] studentName = new String[30];
    static String[] studentId = new String[30];


    // Counter variable to keep track of the number of users
    private static int studentCount = 0;

    public static void readStudent(){
        try {
            String fileName = "studentData.txt";
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            // Read each line of the file until reaching the end (null)
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts.length >= 8) {
                    String name = parts[0];
                    String id = parts[1];

                    studentName[studentCount] = name;
                    studentId[studentCount] = id;
                    studentCount++;
                }
            }
            // Handle the case where the file is not found
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            // Handle the case where there is an error reading the file
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
}
