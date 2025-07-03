
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            EmployeeDAO dao = new EmployeeDAO();
            int choice;

            do {
                System.out.println("\n--- Employee Menu ---");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Position: ");
                        String pos = sc.nextLine();
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();
                        dao.addEmployee(new Employee(name, pos, sal));
                    }
                    case 2 -> {
                        List<Employee> employees = dao.getAllEmployees();
                        System.out.println("\n--- Employee List ---");
                        for (Employee emp : employees) {
                            System.out.println(emp.getId() + " - " + emp.getName() +
                                " - " + emp.getPosition() + " - ₹" + emp.getSalary());
                        }
                    }
                    case 3 -> {
                        System.out.print("ID to update: ");
                        int id = sc.nextInt(); sc.nextLine();
                        System.out.print("New name: ");
                        String name = sc.nextLine();
                        System.out.print("New position: ");
                        String pos = sc.nextLine();
                        System.out.print("New salary: ");
                        double sal = sc.nextDouble();
                        dao.updateEmployee(new Employee(id, name, pos, sal));
                    }
                    case 4 -> {
                        System.out.print("ID to delete: ");
                        int id = sc.nextInt();
                        dao.deleteEmployee(id);
                    }
                    case 5 -> System.out.println("👋 Exiting...");
                    default -> System.out.println("❌ Invalid choice.");
                }

            } while (choice != 5);

            dao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
