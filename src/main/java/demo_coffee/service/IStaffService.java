package demo_coffee.service;

import demo_coffee.model.Staff;

import java.sql.SQLException;
import java.util.List;


public interface IStaffService {

    List<Staff> findAll() ;

    List<Staff> findAllInactive() ;

    boolean save(Staff staff) throws SQLException;

    Staff findById(int id)  ;

    boolean update(Staff staff) throws SQLException;

    void restore(int id) throws SQLException;

    void delete(int id) ; //delete mem ;

    List<Staff> search(String name);
}
