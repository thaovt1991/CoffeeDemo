package demo_coffee.service;

import demo_coffee.model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffService implements IStaffService {

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
        String SELECT_ALL_STAFFS = "SELECT * FROM staffs";
        List<Staff> staffs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STAFFS);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String gender = rs.getString("gender");
                String date_of_birth = rs.getString("date_of_birth");
                String id_card = rs.getString("id_card");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String image = rs.getString("image");
                String position = rs.getString("position_staff");
                long pay = rs.getLong("pay");
                boolean status_staff = rs.getBoolean("status_staff");
                String description_staff = rs.getString("description_staff");
                staffs.add(new Staff(id, full_name, gender, date_of_birth, id_card, email, phone, address, image, position, pay, status_staff, description_staff));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staffs;
    }

    @Override
    public List<Staff> findAllActive() {
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
                String gender = rs.getString("gender");
                String date_of_birth = rs.getString("date_of_birth");
                String id_card = rs.getString("id_card");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String image = rs.getString("image");
                String position = rs.getString("position_staff");
                Boolean isAccount = rs.getBoolean("status_account");
                long pay = rs.getLong("pay");
                boolean status_staff = rs.getBoolean("status_staff");
                String description_staff = rs.getString("description_staff");
                staffs.add(new Staff(id, full_name, gender, date_of_birth, id_card, email, phone, address, image, position, pay, status_staff, description_staff,isAccount));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staffs;
    }

    @Override
    public List<Staff> findAllInactive() {
        String SELECT_ALL_STAFFS = "SELECT * FROM staffs WHERE status_staff = 0";
        List<Staff> staffs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STAFFS);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String gender = rs.getString("gender");
                String date_of_birth = rs.getString("date_of_birth");
                String id_card = rs.getString("id_card");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String image = rs.getString("image");
                String position = rs.getString("position_staff");
                long pay = rs.getLong("pay");
                boolean status_staff = rs.getBoolean("status_staff");
                String description_staff = rs.getString("description_staff");
                staffs.add(new Staff(id, full_name, gender, date_of_birth, id_card, email, phone, address, image, position, pay, status_staff, description_staff));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staffs;
    }

    @Override
    public boolean save(Staff staff) throws SQLException {
        String INSERT_STAFF_SQL = "INSERT INTO staffs(full_name ,gender ,date_of_birth,id_card,email,phone,address,image,position_staff,pay,status_staff,description_staff)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        boolean isInsert = false;
        System.out.println(INSERT_STAFF_SQL);
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
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
            connection.commit();
        } catch (SQLException e) {
            printSQLException(e);
            connection.rollback();
            isInsert = false;
        } finally {
            connection.setAutoCommit(true);
            connection.close();
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
                String gender = rs.getString("gender");
                String date_of_birth = rs.getString("date_of_birth");
                String id_card = rs.getString("id_card");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String image = rs.getString("image");
                String position = rs.getString("position_staff");
                long pay = rs.getLong("pay");
                boolean status_staff = rs.getBoolean("status_staff");
                String description_staff = rs.getString("description_staff");
                staff = new Staff(id, full_name, gender, date_of_birth, id_card, email, phone, address, image, position, pay, status_staff, description_staff);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staff;
    }

    @Override
    public boolean update(Staff staff) throws SQLException {
        String UPDATE_STAFF_SQL = "UPDATE staffs SET full_name = ? ,gender = ?, date_of_birth =?, id_card = ?, email=?, phone= ?, address = ?,image = ?,position_staff =? ,pay = ?, status_staff =?,description_staff = ? WHERE id = ?";
        boolean rowUpdated = false;
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(UPDATE_STAFF_SQL);
            statement.setString(1, staff.getFullName());
            statement.setString(2, staff.getGender());
            statement.setString(3, staff.getDateOfBirth());
            statement.setString(4, staff.getIdCard());
            statement.setString(5, staff.getEmail());
            statement.setString(6, staff.getPhone());
            statement.setString(7, staff.getAddress());
            statement.setString(8, staff.getImage());
            statement.setString(9, staff.getPosition());
            statement.setLong(10, staff.getPay());
            statement.setBoolean(11, staff.isStatus());
            statement.setString(12, staff.getDescription());
            statement.setInt(13, staff.getId());

            rowUpdated = statement.executeUpdate() > 0;
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            rowUpdated = false;
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        return rowUpdated;
    }

    @Override
    public void delete(int id) {
        String UPDATE_STATUS_STAFF_SQL_INACTIVE = "UPDATE staffs SET status_staff = ? WHERE id = ?";
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS_STAFF_SQL_INACTIVE);
            statement.setInt(1, 0);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatusAccount(int id) {
        String UPDATE_STATUS_ACCOUNT_SQL_INACTIVE = "UPDATE staffs SET status_account = ? WHERE id = ?";
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS_ACCOUNT_SQL_INACTIVE);
            statement.setInt(1, 1);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Staff> search(String properties, String search) {
        List<Staff> staffs = findAllActive();
        List<Staff> staffsSearch = new ArrayList<>();
        switch (properties) {
            case "Gender":
                for (Staff staff : staffs) {
                    if (staff.getGender().contains(search)) {
                        staffsSearch.add(staff);
                    }
                }
                break;
            case "Position":
                for (Staff staff : staffs) {
                    if (staff.getPosition().contains(search)) {
                        staffsSearch.add(staff);
                    }
                }
                break;
            default:
                for (Staff staff : staffs) {
                    if (staff.getFullName().contains(search)) {
                        staffsSearch.add(staff);
                    }
                }

                break;
        }

        return staffsSearch;
    }

    @Override
    public List<Staff> searchStaffInactive(String properties, String search) {
        List<Staff> staffs = findAllInactive();
        List<Staff> staffsSearch = new ArrayList<>();
        switch (properties) {
            case "Gender":
                for (Staff staff : staffs) {
                    if (staff.getGender().contains(search)) {
                        staffsSearch.add(staff);
                    }
                }
                break;
            case "Position":
                for (Staff staff : staffs) {
                    if (staff.getPosition().contains(search)) {
                        staffsSearch.add(staff);
                    }
                }
                break;
            default:
                for (Staff staff : staffs) {
                    if (staff.getFullName().contains(search)) {
                        staffsSearch.add(staff);
                    }
                }
                break;
        }
        return staffsSearch;
    }

    @Override
    public boolean removeData(int id) throws SQLException {
        String DELETE_STAFF_SQL = "DELETE FROM staffs WHERE id = ?";
        Connection connection = null;
        boolean isRemoveData = false ;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STAFF_SQL);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            isRemoveData = preparedStatement.executeUpdate() >0;

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        return isRemoveData ;
    }

    @Override
    public List<Staff> listStaffNotHaveAccount() {
//       String SELECT_STAFF_NOT_HAVE_ACCOUNT = "SELECT * FROM staffs WHERE id NOT IN (SELECT id FROM accounts) AND status_staff = 1" ;
        String SELECT_STAFF_NOT_HAVE_ACCOUNT = "SELECT * FROM staffs WHERE  staff_account = 1" ;
        List<Staff> staffs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STAFF_NOT_HAVE_ACCOUNT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String gender = rs.getString("gender");
                String date_of_birth = rs.getString("date_of_birth");
                String id_card = rs.getString("id_card");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String image = rs.getString("image");
                String position = rs.getString("position_staff");
                long pay = rs.getLong("pay");
                boolean status_staff = rs.getBoolean("status_staff");
                String description_staff = rs.getString("description_staff");
                staffs.add(new Staff(id, full_name, gender, date_of_birth, id_card, email, phone, address, image, position, pay, status_staff, description_staff));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staffs;
    }


    @Override
    public void restore(int id) {
        String UPDATE_STATUS_STAFF_SQL_RESTORE = "UPDATE staffs SET status_staff = ? WHERE id = ?";
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS_STAFF_SQL_RESTORE);
            statement.setInt(1, 1);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
