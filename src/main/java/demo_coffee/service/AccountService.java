package demo_coffee.service;

import demo_coffee.model.Account;
import demo_coffee.model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService implements IAccountService {

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
    public List<Account> findAll() {
        String SELECT_ALL_ACCOUNT = "SELECT * FROM accounts ";
        List<Account> accounts = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String permission = rs.getString("permission");
                boolean status = rs.getBoolean("status");
                accounts.add(new Account(id, username, password, permission, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public List<Account> findAllActive() {
        String SELECT_ALL_ACCOUNT = "SELECT * FROM accounts WHERE status = 1";
        List<Account> accounts = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String permission = rs.getString("permission");
                boolean status = rs.getBoolean("status");
                accounts.add(new Account(id, username, password, permission, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public List<Account> findAllInactive() {
        String SELECT_ALL_ACCOUNT = "SELECT * FROM accounts WHERE status = 0";
        List<Account> accounts = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String permission = rs.getString("permission");
                boolean status = rs.getBoolean("status");
                accounts.add(new Account(id, username, password, permission, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }


    @Override
    public boolean save(Account account) throws SQLException {
        String INSERT_ACCOUNT_SQL = "INSERT INTO accounts VALUES (?,?,?,?,?)";
        boolean isInsert = false;
        System.out.println(INSERT_ACCOUNT_SQL);
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT_SQL);
            preparedStatement.setInt(1, account.getIdUser());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getPermission());
            preparedStatement.setBoolean(5, account.isStatus());

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
    public Account findById(int id) {
        String SELECT_ACCOUNT_BY_ID = "SELECT * FROM accounts WHERE id = ?";
        Account account = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String permission = rs.getString("permission");
                boolean status = rs.getBoolean("status");
                account = new Account(id, username, password, permission, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public boolean update(Account account) throws SQLException {
        String UPDATE_ACCOUNT_SQL = "UPDATE accounts SET password = ?, permission = ? , status = ? WHERE id = ?";
        boolean rowUpdated = false;
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_SQL);
            preparedStatement.setString(1, account.getPassword());
            preparedStatement.setString(2, account.getPermission());
            preparedStatement.setBoolean(3, account.isStatus());
            preparedStatement.setInt(4, account.getIdUser());


            rowUpdated = preparedStatement.executeUpdate() > 0;
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        return rowUpdated;
    }

    @Override
    public void restore(int id) throws SQLException {
        String UPDATE_UNLOCK_ACCOUNT = "UPDATE accounts SET status = 1 WHERE id = ?" ;
        Connection connection = null ;
        try{
            connection = getConnection() ;
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_UNLOCK_ACCOUNT) ;
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate() ;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String UPDATE_LOCK_ACCOUNT = "UPDATE accounts SET status = 0 WHERE id = ?" ;
        Connection connection = null ;
        try{
            connection = getConnection() ;
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LOCK_ACCOUNT) ;
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate() ;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> search(String properties, String keySearch) {
        List<Account> listSearch = new ArrayList<>();
        switch (properties) {
            case "Username":
                String SEARCH_BY_USERNAME = "SELECT * FROM accounts WHERE username LIKE ? AND status = 1";
                listSearch = listSearch(SEARCH_BY_USERNAME, keySearch);
                break;
            case "Permission":
                String SEARCH_BY_PERMISSION = "SELECT * FROM accounts WHERE permission LIKE ? AND status = 1";
                listSearch = listSearch(SEARCH_BY_PERMISSION, keySearch);
                break;
            default:
                break;
        }
        return listSearch;

    }


    @Override
    public List<Account> searchInactive(String username) {
        return null;
    }

    private List<Account> listSearch(String sql, String keySearch) {
        List<Account> accountsList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            keySearch = "%" + keySearch + "%";

            preparedStatement.setString(1, keySearch);

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String permission = rs.getString("permission");
                boolean status = rs.getBoolean("status");
                accountsList.add(new Account(id, username, password, permission, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountsList;
    }

    @Override
    public boolean removeDataAccount(int id) throws SQLException {
        String DELETE_ACCOUNT_SQL = "DELETE FROM accounts WHERE id = ?";
        // String UPDATE_STATUS_ACCOUNT_SQL_INACTIVE = "UPDATE staffs SET status_account = ? WHERE id = ?";
        Connection connection = null;
        boolean isRemove = false;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatementAccount = connection.prepareStatement(DELETE_ACCOUNT_SQL);
            preparedStatementAccount.setInt(1, id);
//            System.out.println(preparedStatementAccount);
            isRemove = preparedStatementAccount.executeUpdate() > 0;

//            PreparedStatement statementStaff = connection.prepareStatement(UPDATE_STATUS_ACCOUNT_SQL_INACTIVE);
//            statementStaff.setInt(1, 0);
//            statementStaff.setInt(2, id);
//            statementStaff.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        return isRemove;
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
