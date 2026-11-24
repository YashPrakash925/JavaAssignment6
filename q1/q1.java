
import java.io.*;
import java.util.Scanner;

public class q1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("students.txt");
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details of Student " + (i + 1));
                System.out.print("Enter Roll Number: ");
                String roll = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Marks: ");
                String marks = sc.nextLine();
                fw.write("Roll Number: " + roll + "\n");
                fw.write("Name: " + name + "\n");
                fw.write("Marks: " + marks + "\n\n");
            }
            fw.close();
            System.out.println("\nStudent records saved successfully.");
            System.out.println("\nReading Student Records:");
            try (FileReader fr = new FileReader("students.txt")) {
                int ch;
                while ((ch = fr.read()) != -1) {
                    System.out.print((char) ch);
                }
            }
            System.out.print("\nEnter binary source file name: ");
            String source = sc.nextLine();
            System.out.print("Enter destination file name: ");
            String destination = sc.nextLine();
            try (FileInputStream fis = new FileInputStream(source);
                 FileOutputStream fos = new FileOutputStream(destination)) {
                int data;
                while ((data = fis.read()) != -1) {
                    fos.write(data);
                }
                System.out.println("\nBinary file copied successfully.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error while handling file: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
