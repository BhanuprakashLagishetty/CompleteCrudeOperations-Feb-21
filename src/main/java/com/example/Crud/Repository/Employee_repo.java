package com.example.Crud.Repository;

import com.example.Crud.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee_repo extends JpaRepository<Employee,String> {
}
