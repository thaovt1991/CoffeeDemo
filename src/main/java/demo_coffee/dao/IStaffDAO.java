package demo_coffee.dao;

import demo_coffee.model.Staff;

import java.util.List;


public interface IStaffDAO {

    List<Staff> findAll() ;

    void save(Staff staff) ;

    Staff findById()  ;

    boolean update(Staff staff) ;

    boolean delete(Staff staff) ;
}
