package com.example.Crud.Service;

import com.example.Crud.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    void addEmployee(Employee employee);
    String RemoveEmployee(String eid);
    String UpdateEmployee(Employee e);
    Employee SearchEmployee(String eid);
    Employee SingleEmployee(String eid);
    List<Employee> DisplayEmployess();
    public boolean checking(Employee employee);


}
