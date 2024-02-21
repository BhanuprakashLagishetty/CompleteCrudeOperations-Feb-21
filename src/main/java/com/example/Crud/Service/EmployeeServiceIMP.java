package com.example.Crud.Service;

import com.example.Crud.Model.Employee;
import com.example.Crud.Repository.Employee_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIMP implements EmployeeService{
    @Autowired
    Employee_repo emp;
    @Override
    public void addEmployee(Employee employee) {
        emp.save(employee);

    }

    @Override
    public String RemoveEmployee(String eid) {
        if(emp.findById(eid)!=null)
        {
            emp.deleteById(eid);
            return "Deleted succesfully";

        }
          return "UNABLE TO FIND EMPLOYEE";



    }




    @Override
    public String UpdateEmployee(Employee e) {
        String empid=Integer.toString(e.getEid());
        Employee employee= emp.findById(empid).orElse(null);
        employee.setEid(e.getEid());
        employee.setEname(e.getEname());
        employee.setEdesignation(e.getEdesignation());
        employee.setEsalary(e.getEsalary());
        emp.save(employee);
        return "Successfully Updated";


    }
    public boolean checking(Employee employee)
    {
        String name = employee.getEname().replaceAll("\\s", "");
        String desgination = employee.getEdesignation().replaceAll("\\s", "");
        String salary = employee.getEsalary().replaceAll("\\s", "");
        if(name!=null && desgination!=null && salary!=null)
        {
            System.out.println("METHOD IS CALLED");
            return true;
        }
        return false;


    }

    @Override
    public Employee SearchEmployee(String eid) {
       return emp.findById(eid).orElse(null);

    }
    public Employee SingleEmployee(String eid)
    {
        return emp.findById(eid).orElse(null);
    }

    @Override
    public List<Employee> DisplayEmployess() {
        return emp.findAll();
    }

}
