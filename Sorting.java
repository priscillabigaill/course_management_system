import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
    public static void sortAndPrintFileData(String filename) {
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

            // Print the sorted data
            for (String sortedLine : lines) {
                System.out.println(sortedLine);
            }

            System.out.println("File data sorted successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while sorting the file data: " + e.getMessage());
        }
    }


    public static void main(String[] args) {

        sortAndPrintFileData("studentData.txt");
        sortAndPrintFileData("courseData.txt");

        readCourse();
        readStudent();

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

