
import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
    int empId;
    String name;
    String department;
    double salary;

    Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

public class q3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine();

            Employee[] employees = new Employee[n];

            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details of Employee " + (i + 1));

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Department: ");
                String department = sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();

                employees[i] = new Employee(id, name, department, salary);
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("employees.dat"))) {

                oos.writeObject(employees);
                System.out.println("\nEmployee records saved successfully.");
            }

            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("employees.dat"))) {

                Employee[] savedEmployees = (Employee[]) ois.readObject();

                System.out.println("\nRetrieved Employee Records:");

                for (Employee emp : savedEmployees) {
                    emp.display();
                }
            }

        } catch (IOException e) {
            System.out.println("File handling error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found.");
        } finally {
            sc.close();
        }
    }
}
