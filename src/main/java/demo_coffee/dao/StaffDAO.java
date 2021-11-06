package demo_coffee.dao;

import demo_coffee.model.Staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class StaffDAO implements IStaffDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/demo_coffee?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Staff> findAll() {
        return null;
    }

    @Override
    public void save(Staff staff) {

    }

    @Override
    public Staff findById() {
        return null;
    }

    @Override
    public boolean update(Staff staff) {
        return false;
    }

    @Override
    public boolean delete(Staff staff) {
        return false;
    }
}
