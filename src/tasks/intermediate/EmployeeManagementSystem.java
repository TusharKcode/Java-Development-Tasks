package tasks.intermediate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Employee{

    private final int id;           // ID won't change as it is in final state
    private String name;
    private double salary;

    public Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
                                    // getters and setters
    public int getId() {
        return id;
    }

    public String getName() {           // getName can be used later to update EMS
        return name;
    }

    public double getSalary() {         // getSalary can be used later to update EMS
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + " , Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    private static final ArrayList<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. View Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1 -> addEmployee();
                case 2 -> updateEmployee();
                case 3 -> viewEmployee();
                case 4 -> deleteEmployee();
                case 5 -> System.out.println("Exiting....Thank You!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    private static void addEmployee(){
        System.out.println("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();                         //newline
        System.out.println("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully!");
    }

    private static void updateEmployee(){
        System.out.println("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Employee emp : employees){
            if (emp.getId() == id){
                System.out.println("Enter new name: ");
                String name = scanner.nextLine();
                System.out.println("Enter new salary: ");
                double salary = scanner.nextDouble();

                emp.setName(name);
                emp.setSalary(salary);
                System.out.println("Employee details updated successfully!");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found!");
    }

    private static void viewEmployee(){
        if (employees.isEmpty()){
            System.out.println("No employee found!");
        } else {
            System.out.println("\n---- Employee List ----");
            for (Employee emp : employees){
                System.out.println(emp);
            }
        }
    }

    private static void deleteEmployee(){
        System.out.println("Enter Employee ID to delete: ");
        int id = scanner.nextInt();

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee emp = iterator.next();
            if (emp.getId() == id){
                iterator.remove();      // safer way to remove during iteration
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found!");
    }
}
