package demo_coffee.dao;

import demo_coffee.model.Staff;

import java.sql.*;
import java.util.ArrayList;
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
        String SELECT_ALL_STAFFS = "SELECT * FROM staffs WHERE status_staff = 1";
        List<Staff> staffs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STAFFS);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String gender = rs.getString("gender") ;
                String date_of_birth = rs.getString("date_of_birth") ;
                String id_card = rs.getString("id_card") ;
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String image = rs.getString("image");
                String position = rs.getString("position_staff");
                long pay = rs.getLong("pay");
                boolean status_staff = rs.getBoolean("status_staff");
                String description_staff = rs.getString("description_staff") ;
                staffs.add(new Staff(id, full_name,gender,date_of_birth,id_card,email, phone, address,image,position,pay,status_staff,description_staff));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staffs;
    }

    @Override
    public boolean save(Staff staff) {
        String INSERT_STAFF_SQL = "INSERT INTO staffs(full_name ,gender ,date_of_birth,id_card,email,phone,address,image,position_staff,pay,status_staff,description_staff)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        boolean isInsert = false;
        System.out.println(INSERT_STAFF_SQL);
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STAFF_SQL);
            preparedStatement.setString(1, staff.getFullName());
            preparedStatement.setString(2, staff.getGender());
            preparedStatement.setString(3, staff.getDateOfBirth());
            preparedStatement.setString(4, staff.getIdCard());
            preparedStatement.setString(5, staff.getEmail());
            preparedStatement.setString(6, staff.getPhone());
            preparedStatement.setString(7, staff.getAddress());
            preparedStatement.setString(8, staff.getImage());
            preparedStatement.setString(9, staff.getPosition());
            preparedStatement.setLong(10, staff.getPay());
            preparedStatement.setBoolean(11, staff.isStatus());
            preparedStatement.setString(12, staff.getDescription());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            isInsert = true;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isInsert;
    }

    @Override
    public Staff findById(int id) {
        String SELECT_STAFF_BY_ID = "SELECT * FROM staffs WHERE id = ?";
        Staff staff = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STAFF_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String full_name = rs.getString("full_name");
                String gender = rs.getString("gender") ;
                String date_of_birth = rs.getString("date_of_birth") ;
                String id_card = rs.getString("id_card") ;
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String image = rs.getString("image");
                String position = rs.getString("position_staff");
                long pay = rs.getLong("pay");
                boolean status_staff = rs.getBoolean("status_staff");
                String description_staff = rs.getString("description_staff") ;
                staff= new Staff(id, full_name,gender,date_of_birth,id_card,email, phone, address,image,position,pay,status_staff,description_staff);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staff;
    }

    @Override
    public boolean update(Staff staff) {
        return false;
    }

    @Override
    public boolean delete(Staff staff) {
        return false;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
