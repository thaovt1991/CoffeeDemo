package demo_coffee.service;

import demo_coffee.model.Account;
import demo_coffee.model.Staff;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService {

    List<Account> findAll() ;

    List<Account> findAllActive() ;

    List<Account> findAllInactive() ;

    boolean save(Account account) throws SQLException;

    Account findById(int id)  ;

    boolean update(Account account) throws SQLException;

    void restore(int id) throws SQLException;

    void delete(int id) ; //delete mem ;

    List<Account> search(String properties, String keySearch);

    List<Account> searchInactive(String username);

    boolean removeDataAccount(int id) throws SQLException ;


}

