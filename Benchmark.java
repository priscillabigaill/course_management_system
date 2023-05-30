import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Benchmark {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // call readCourse function
        long startTime1, startTime2, startTime3, startTime4, endTime1, endTime2, endTime3, endTime4;
        readCourse();
        ArraylistBenchmark arrayList = new ArraylistBenchmark();
        HashmapBenchmark hashMap = new HashmapBenchmark();
        BinarysearchtreeBenchmark binarySearchTree = new BinarysearchtreeBenchmark();
        LinkedlistBenchmark linkedList = new LinkedlistBenchmark();

        System.out.print("Enter a number of courses to stimulate the speed (10/20/30): ");
        String choice = input.nextLine();

        switch (choice) {

            case "10":
                //add course
                //ArrayList
                System.out.print("ArrayList: ");
                startTime1 = System.nanoTime();
                for (int i=0; i<10 && i<courseCount; i++) {
                    arrayList.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
                }
                for (int i=0; i<5 && i<courseCount; i++) {
                    arrayList.removeCourse(courseName[i]);
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    arrayList.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Auber");
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    arrayList.searchCoursebyName(courseName[i]);
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    arrayList.addStudent(studentName[i], studentId[i], courseName[i]);
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    for (int s=0; s<10 && s<studentCount; s++){
                        arrayList.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    for (int s=0; s<5 && s<studentCount; s++) {
                        arrayList.removeStudent(courseName[i], studentId[s]);
                    }
                }
                endTime1 = System.nanoTime();
                getTime(startTime1, endTime1);

                //Hashmap
                System.out.print("Hash Map: ");
                startTime2 = System.nanoTime();
                for (int i=0; i<10 && i<courseCount; i++) {
                    hashMap.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
                }
                for (int i=0; i<5 && i<courseCount; i++) {
                    hashMap.removeCourse(courseName[i]);
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    hashMap.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Auber");
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    hashMap.searchCoursebyName(courseName[i]);
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    hashMap.addStudent(studentName[i], studentId[i], courseName[i]);
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    for (int s=0; s<10 && s<studentCount; s++){
                        hashMap.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    for (int s=0; s<5 && s<studentCount; s++) {
                        hashMap.removeStudent(courseName[i], studentId[s]);
                    }
                }
                endTime2 = System.nanoTime();
                getTime(startTime2, endTime2);

                //Binary Search Tree
                System.out.print("Binary Search Tree: ");
                startTime3 = System.nanoTime();
                for (int i=0; i<10 && i<courseCount; i++) {
                    binarySearchTree.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
                }
                for (int i=0; i<5 && i<courseCount; i++) {
                    binarySearchTree.removeCourse(courseName[i]);
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    binarySearchTree.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Auber");
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    binarySearchTree.searchCoursebyName(courseName[i]);
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    binarySearchTree.addStudent(studentName[i], studentId[i], courseName[i]);
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    for (int s=0; s<10 && s<studentCount; s++){
                        binarySearchTree.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    for (int s=0; s<5 && s<studentCount; s++) {
                        binarySearchTree.removeStudent(courseName[i], studentId[s]);
                    }
                }
                endTime3 = System.nanoTime();
                getTime(startTime3, endTime3);

                //Linked list
                System.out.print("LinkedList: ");
                startTime4 = System.nanoTime();
                for (int i=0; i<10 && i<courseCount; i++) {
                    linkedList.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i], null);
                }
                for (int i=0; i<5 && i<courseCount; i++) {
                    linkedList.removeCourse(courseName[i]);
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    linkedList.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Aubert");
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    linkedList.searchCoursebyName(courseName[i]);
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    for (int s=0; s<10 && s<studentCount; s++){
                        linkedList.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=5; i<10 && i<courseCount; i++) {
                    for (int s=0; s<5 && s<studentCount; s++){
                        linkedList.removeStudent(courseName[i], studentId[s]);
                    }
                }

                endTime4 = System.nanoTime();
                getTime(startTime4, endTime4);

                break;
            case "20":
                //add course
                //ArrayList
                System.out.print("ArrayList: ");
                startTime1 = System.nanoTime();
                for (int i=0; i<20 && i<courseCount; i++) {
                    arrayList.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
                }
                for (int i=0; i<10 && i<courseCount; i++) {
                    arrayList.removeCourse(courseName[i]);
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    arrayList.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Auber");
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    arrayList.searchCoursebyName(courseName[i]);
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    for (int s=0; s<20 && s<studentCount; s++){
                        arrayList.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    for (int s=0; s<10 && s<studentCount; s++) {
                        arrayList.removeStudent(courseName[i], studentId[s]);
                    }
                }
                endTime1 = System.nanoTime();
                getTime(startTime1, endTime1);

                //Hashmap
                System.out.print("Hash Map: ");
                startTime2 = System.nanoTime();
                for (int i=0; i<20 && i<courseCount; i++) {
                    hashMap.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
                }
                for (int i=0; i<10 && i<courseCount; i++) {
                    hashMap.removeCourse(courseName[i]);
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    hashMap.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Auber");
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    hashMap.searchCoursebyName(courseName[i]);
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    for (int s=0; s<20 && s<studentCount; s++){
                        hashMap.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    for (int s=0; s<10 && s<studentCount; s++) {
                        hashMap.removeStudent(courseName[i], studentId[s]);
                    }
                }
                endTime2 = System.nanoTime();
                getTime(startTime2, endTime2);

                //Binary Search Tree
                System.out.print("Binary Search Tree: ");
                startTime3 = System.nanoTime();
                for (int i=0; i<20 && i<courseCount; i++) {
                    binarySearchTree.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
                }
                for (int i=0; i<10 && i<courseCount; i++) {
                    binarySearchTree.removeCourse(courseName[i]);
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    binarySearchTree.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Aubert");
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    binarySearchTree.searchCoursebyName(courseName[i]);
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    for (int s=0; s<20 && s<studentCount; s++) {
                        binarySearchTree.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    for (int s=0; s<10 && s<studentCount; s++){
                        binarySearchTree.removeStudent(courseName[i], studentId[s]);
                    }
                }
                endTime3 = System.nanoTime();
                getTime(startTime3, endTime3);

                //Linked list
                System.out.print("LinkedList: ");
                startTime4 = System.nanoTime();
                for (int i=0; i<20 && i<courseCount; i++) {
                    linkedList.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i], null);
                }
                for (int i=0; i<10 && i<courseCount; i++) {
                    linkedList.removeCourse(courseName[i]);
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    linkedList.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Aubert");
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    linkedList.searchCoursebyName(courseName[i]);
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    for (int s=0; s<20 && s<studentCount; s++) {
                        linkedList.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=10; i<20 && i<courseCount; i++) {
                    for (int s=0; s<10 && s<studentCount; s++){
                        linkedList.removeStudent(courseName[i], studentId[s]);
                    }
                }
                endTime4 = System.nanoTime();
                getTime(startTime4, endTime4);

                break;
            case "30":
                //add course
                //ArrayList
                System.out.print("ArrayList: ");
                startTime1 = System.nanoTime();
                for (int i=0; i<30 && i<courseCount; i++) {
                    arrayList.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
                }
                for (int i=0; i<15 && i<courseCount; i++) {
                    arrayList.removeCourse(courseName[i]);
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    arrayList.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Auber");
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    arrayList.searchCoursebyName(courseName[i]);
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    for (int s=0; s<30 && s<studentCount; s++){
                        arrayList.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    for (int s=0; s<15 && s<studentCount; s++) {
                        arrayList.removeStudent(courseName[i], studentId[s]);
                    }
                }
                endTime1 = System.nanoTime();
                getTime(startTime1, endTime1);

                //Hashmap
                System.out.print("Hash Map: ");
                startTime2 = System.nanoTime();
                for (int i=0; i<30 && i<courseCount; i++) {
                    hashMap.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
                }
                for (int i=0; i<15 && i<courseCount; i++) {
                    hashMap.removeCourse(courseName[i]);
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    hashMap.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Auber");
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    hashMap.searchCoursebyName(courseName[i]);
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    for (int s=0; s<30 && s<studentCount; s++){
                        hashMap.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    for (int s=0; s<15 && s<studentCount; s++) {
                        hashMap.removeStudent(courseName[i], studentId[s]);
                    }
                }
                endTime2 = System.nanoTime();
                getTime(startTime2, endTime2);

                //Binary Search Tree
                System.out.print("Binary Search Tree: ");
                startTime3 = System.nanoTime();
                for (int i=0; i<30 && i<courseCount; i++) {
                    binarySearchTree.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i]);
                }
                for (int i=0; i<15 && i<courseCount; i++) {
                    binarySearchTree.removeCourse(courseName[i]);
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    binarySearchTree.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Auber");
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    binarySearchTree.searchCoursebyName(courseName[i]);
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    for (int s=0; s<30 && s<studentCount; s++){
                        binarySearchTree.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    for (int s=0; s<15 && s<studentCount; s++) {
                        binarySearchTree.removeStudent(courseName[i], studentId[s]);
                    }
                }
                endTime3 = System.nanoTime();
                getTime(startTime3, endTime3);

                //Linked list
                System.out.print("LinkedList: ");
                startTime4 = System.nanoTime();
                for (int i=0; i<30 && i<courseCount; i++) {
                    linkedList.addCourse(courseName[i], courseId[i], courseDay[i], courseStartTime[i], courseEndTime[i], lecturerName[i], null);
                }
                for (int i=0; i<15 && i<courseCount; i++) {
                    linkedList.removeCourse(courseName[i]);
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    linkedList.modifyCourse(courseName[i], "Thursday", "12.00", "14.00", "Aubert");
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    linkedList.searchCoursebyName(courseName[i]);
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    for (int s = 0; s < 30 && s < studentCount; s++) {
                        linkedList.addStudent(studentName[s], studentId[s], courseName[i]);
                    }
                }
                for (int i=15; i<30 && i<courseCount; i++) {
                    for (int s=0; s<15 && s<studentCount; s++){
                        linkedList.removeStudent(courseName[i], studentId[s]);
                    }
                }
                endTime4 = System.nanoTime();
                getTime(startTime4, endTime4);

                break;
        }
    }

    static void getTime(long startTime, long endTime) {
        double elapsedTime = (endTime - startTime) / 1_000.0;  //milliseconds
        System.out.println("\nTime used: " + elapsedTime + " milisecond(s)");
        // System.out.printf("\nTime used: %.2f milliseconds", elapsedTime);
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
