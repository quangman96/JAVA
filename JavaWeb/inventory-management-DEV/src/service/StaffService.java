package service;

import model.Staff;


import java.util.List;

public interface StaffService {

    List<Staff> findAll();

    void save(Staff staff);

    void update(int idStaff, Staff staff);

    void remove(int idStaff, Staff staff);

    Staff findById(int idStaff);
}
