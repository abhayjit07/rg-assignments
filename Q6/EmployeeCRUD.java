import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeCRUD {
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Create
    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    // Read
    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    // Update
    public void updateEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new department: ");
                String dept = scanner.nextLine();
                emp.setName(name);
                emp.setDepartment(dept);
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // Delete
    public void deleteEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee CRUD Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    crud.addEmployee(new Employee(id, name, dept));
                    break;
                case 2:
                    crud.viewEmployees();
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    crud.updateEmployee(updateId);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    crud.deleteEmployee(deleteId);
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
