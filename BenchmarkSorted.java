import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BenchmarkSorted {

    //sorting method
    public static void sortFileData(String filename) {
        try {
            // Read the file data into a list
            ArrayList<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // Sort the data in alphabetical order
            Collections.sort(lines);

            // Write the sorted data back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (String sortedLine : lines) {
                writer.write(sortedLine);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            return;
        }
    }

    public static void main(String[] args) {
        // call sorting method
        sortFileData("studentData.txt");
        sortFileData("courseData.txt");

        Scanner input = new Scanner(System.in);
        // call readCourse function
        long startTime1, startTime2, startTime3, startTime4, endTime1, endTime2, endTime3, endTime4;
        int n;
        readCourse();
        readStudent();
        ArraylistBenchmark arrayList = new ArraylistBenchmark();
        for (int i=0; i<150 && i<courseCount; i++) {
            arrayList.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
        }
        HashmapBenchmark hashMap = new HashmapBenchmark();
        for (int i=0; i<150 && i<courseCount; i++) {
            hashMap.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
        }
        BinarysearchtreeBenchmark binarySearchTree = new BinarysearchtreeBenchmark();
        for (int i=0; i<150 && i<courseCount; i++) {
            binarySearchTree.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
        }
        LinkedlistBenchmark linkedList = new LinkedlistBenchmark();
        for (int i=0; i<150 && i<courseCount; i++) {
            linkedList.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i], null);
        }

        System.out.println("Choose the method that you want to test:");
        System.out.println("1 - Search course by name");
        System.out.print("Enter your choice: ");
        String choice = input.nextLine();

        switch (choice) {
            /*********************
             * 1 - Search course *
             *********************/
            case "1":
                //Array List
                System.out.println("\nArrayList: ");
                System.out.print("Searching course: ");
                startTime1 = System.nanoTime();
                arrayList.searchCoursebyName("Topology");
                endTime1 = System.nanoTime();
                getTime(startTime1, endTime1);

                //Hashmap
                System.out.println("\nHash Map: ");
                System.out.print("Searching course: ");
                startTime2 = System.nanoTime();
                hashMap.searchCoursebyName("Topology");
                endTime2 = System.nanoTime();
                getTime(startTime2, endTime2);

                //Binary Search Tree
                System.out.println("\nBinary Search Tree: ");
                System.out.print("Searching course: ");
                startTime3 = System.nanoTime();
                binarySearchTree.searchCoursebyName("Topology");
                endTime3 = System.nanoTime();
                getTime(startTime3, endTime3);

                //Linked list
                System.out.println("\nLinkedList: ");
                System.out.print("Searching course: ");
                startTime4 = System.nanoTime();
                linkedList.searchCoursebyName("Topology");
                endTime4 = System.nanoTime();
                getTime(startTime4, endTime4);

                break;
        }
    }

    static void getTime(long startTime, long endTime) {
        double elapsedTime = (endTime - startTime) / 1_000.0;  //milliseconds
        System.out.println("Time used: " + elapsedTime + " milisecond(s)");
        // System.out.printf("\nTime used: %.2f milliseconds", elapsedTime);
    }

    static String[] courseName = new String[150];
    static String[] courseId = new String[150];
    static String[] courseDay = new String[150];
    static String[] courseStartTime = new String[150];
    static String[] courseEndTime = new String[150];
    static String[] lecturerName = new String[150];


    // Counter variable to keep track of the number of users
    private static int courseCount = 0;

    public static void readCourse() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("courseData.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
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
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }


    static String[] studentName = new String[150];
    static String[] studentId = new String[150];


    // Counter variable to keep track of the number of users
    private static int studentCount = 0;

    public static void readStudent() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("courseData.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
                String name = parts[0];
                String id = parts[1];

                studentName[studentCount] = name;
                studentId[studentCount] = id;
                studentCount++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}
