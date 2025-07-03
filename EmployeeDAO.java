
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO() throws SQLException {
        conn = DBConnection.getConnection();
    }

    public void addEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, emp.getName());
        stmt.setString(2, emp.getPosition());
        stmt.setDouble(3, emp.getSalary());
        stmt.executeUpdate();
        System.out.println("✅ Employee added.");
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            list.add(new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("position"),
                rs.getDouble("salary")
            ));
        }
        return list;
    }

    public void updateEmployee(Employee emp) throws SQLException {
        String sql = "UPDATE employees SET name=?, position=?, salary=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, emp.getName());
        stmt.setString(2, emp.getPosition());
        stmt.setDouble(3, emp.getSalary());
        stmt.setInt(4, emp.getId());
        stmt.executeUpdate();
        System.out.println("✅ Employee updated.");
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("✅ Employee deleted.");
    }

    public void close() throws SQLException {
        if (conn != null) conn.close();
    }
}
