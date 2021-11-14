package demo_coffee.service;

import demo_coffee.model.Drinks;
import demo_coffee.model.Staff;

import java.sql.SQLException;
import java.util.List;

public interface IDrinksService {
    List<Drinks> findAll() ;

    List<Drinks> findAllActive() ;

    List<Drinks> findAllInactive() ;

    boolean save(Drinks drinks) throws SQLException;

    Drinks findById(int id)  ;

    boolean update(Drinks drinks) throws SQLException;

    void restore(int id) throws SQLException;

    void delete(int id) ; //delete mem ;

    void updateStatusAccount(int id);

    List<Drinks> search(String properties, String search);

    List<Drinks> searchStaffInactive(String properties, String search);

    boolean removeData(int id) throws SQLException;
}
