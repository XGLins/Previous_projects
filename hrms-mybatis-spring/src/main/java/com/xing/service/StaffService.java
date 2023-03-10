package com.xing.service;

import com.xing.domain.Staff;
import com.xing.mapper.StaffMapper;

import java.util.List;
import java.util.Map;


public class StaffService implements StaffMapper {
    @Override
    public int addStaff(Staff staff) {
        return 0;
    }

    @Override
    public int deleteStaff(int id) {
        return 0;
    }

    @Override
    public int updateEmployeeById(Staff staff) {
        return 0;
    }

    @Override
    public List<Staff> findAllStaff() {
        return null;
    }

    @Override
    public Staff findStaffById(int employeeId) {
        return null;
    }

    @Override
    public List<Staff> getStaffByLimit(Map<String, Object> map) {
        return null;
    }

    @Override
    public int addMap(Map<String, Object> map) {
        return 0;
    }

    @Override
    public List<Staff> findStaffLikeName(String name) {
        return null;
    }

    @Override
    public Staff findStaffByName(String employeeName) {
        return null;
    }
}
