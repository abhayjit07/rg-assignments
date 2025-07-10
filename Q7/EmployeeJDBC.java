import java.sql.*;
import java.util.Scanner;

public class EmployeeJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // CREATE
    public void addEmployee(Employee emp) {
        String query = "INSERT INTO employee (id, name, department) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDepartment());
            ps.executeUpdate();
            System.out.println("Employee added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public void viewEmployees() {
        String query = "SELECT * FROM employee";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Employee emp = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
                System.out.println(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateEmployee(int id, String newName, String newDept) {
        String query = "UPDATE employee SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, newName);
            ps.setString(2, newDept);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee updated.");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee deleted.");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // MAIN method for testing
    public static void main(String[] args) {
        EmployeeJDBC crud = new EmployeeJDBC();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee JDBC CRUD Menu ---");
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
                    sc.nextLine();
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
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new Department: ");
                    String newDept = sc.nextLine();
                    crud.updateEmployee(uid, newName, newDept);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    crud.deleteEmployee(did);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
