package demo_coffee.service;

import demo_coffee.model.Drinks;
import demo_coffee.model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrinksService implements IDrinksService{

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


    @Override
    public List<Drinks> findAll() {
        String SELECT_ALL_DRINKS = "SELECT * FROM drinks";
        List<Drinks> drinksList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRINKS);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                boolean status = rs.getBoolean("status");
                String description = rs.getString("description");
                boolean status_order = rs.getBoolean("status_order");
                drinksList.add(new Drinks(id, name, quantity, price, status, description, status_order,image));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return drinksList;
    }

    @Override
    public List<Drinks> findAllActive() {
        String SELECT_ALL_DRINKS_ACTIVE = "SELECT * FROM drinks WHERE status = 1";
        List<Drinks> drinksList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRINKS_ACTIVE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                boolean status = rs.getBoolean("status");
                String description = rs.getString("description");
                boolean status_order = rs.getBoolean("status_order");
                drinksList.add(new Drinks(id, name, quantity, price, status, description, status_order,image));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return drinksList;
    }

    @Override
    public List<Drinks> findAllInactive() {
        String SELECT_ALL_DRINKS_INACTIVE = "SELECT * FROM drinks WHERE status = 0";
        List<Drinks> drinksList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRINKS_INACTIVE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                boolean status = rs.getBoolean("status");
                String description = rs.getString("description");
                boolean status_order = rs.getBoolean("status_order");
                drinksList.add(new Drinks(id, name, quantity, price, status, description, status_order,image));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return drinksList;
    }

    @Override
    public boolean save(Drinks drinks) throws SQLException {
        String INSERT_DRINKS_SQL = "INSERT INTO drinks(id,name,quantity,price,status,description,image) VALUES (?,?,?,?,?,?,?)";
        boolean isInsert = false;
        System.out.println(INSERT_DRINKS_SQL);
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DRINKS_SQL);
            preparedStatement.setString(1, drinks.getId());
            preparedStatement.setString(2, drinks.getName());
            preparedStatement.setInt(3, drinks.getQuantity());
            preparedStatement.setInt(4, drinks.getPrice());
            preparedStatement.setBoolean(5, drinks.isStatus());
            preparedStatement.setString(6,drinks.getDescription());
            preparedStatement.setString(7,drinks.getImage());

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
    public Drinks findById(int id) {
        return null;
    }

    @Override
    public boolean update(Drinks drinks) throws SQLException {
        return false;
    }

    @Override
    public void restore(int id) throws SQLException {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void updateStatusAccount(int id) {

    }

    @Override
    public List<Drinks> search(String properties, String search) {
        return null;
    }

    @Override
    public List<Drinks> searchStaffInactive(String properties, String search) {
        return null;
    }

    @Override
    public boolean removeData(int id) throws SQLException {
        return false;
    }
}
