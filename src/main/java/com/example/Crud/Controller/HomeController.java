package com.example.Crud.Controller;

import com.example.Crud.Model.Address;
import com.example.Crud.Service.EmployeeServiceIMP;
import com.example.Crud.Model.Employee;
import com.example.Crud.Service.EmployeeServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private EmployeeServiceIMP service;


    @RequestMapping("/")
    public String home(ModelMap model)
    {
        System.out.println("HOME PAGE IS CALLED");
        System.out.println("HOME PAGE IS CALLED");

//        return "employeereport";
        return "index";
    }
    @RequestMapping("/employeereport")
    public String employeereport()
    {
        return "employeereport";
    }
    @RequestMapping("/GenerateEmployee")
    public String GenerateEmployee(String ename, String edesignation, String esalary,String street,String village,String district, Model model)
    {

        Employee employee=new Employee();
        employee.setEname(ename);
        employee.setEdesignation(edesignation);
        employee.setEsalary(esalary);
        Address address=new Address();



        address.setStreet(street);
        address.setVillage(village);
        address.setDistrict(district);
        employee.setAddress(address);
        System.out.println(employee.getAddress().getStreet());
        System.out.println("IAMD BAHNU"+employee);
        if(service.checking(employee))
        {
            service.addEmployee(employee);
//        service.viewAllEmployee();
            List<Employee> a=service.DisplayEmployess();

            model.addAttribute("allEmployee",a);
            return "viewEmployees";
        }
        else{
            String res="Please enter all fields";
            model.addAttribute("res",res);
            return "updateResult";
        }



    }
    @RequestMapping("/viewEmployees")
    public String viewEmployees(Model model)
    {
        List<Employee> a=service.DisplayEmployess();
        model.addAttribute("allEmployee",a);
        return "viewEmployees";
    }

    //Searching employee
    @RequestMapping("/SearchUpdateEmployee")
    public String SearchUpdateEmployee()
    {
        return "SearchUpdateEmployee";
    }
    //Remove employee
    @RequestMapping("/removeemployee1")
    public String removeemployee1()
    {
        return "removeemployee";
    }

    @RequestMapping("/removeemployee")
    public String removeemployee( String eid,Model model)
    {

        String res=service.RemoveEmployee(eid);
        model.addAttribute("result",res);

         return "redirect:/viewEmployees?reload=true";
    }


    //update employee
    @RequestMapping("/updateEmployee")
    public String updateEmployee(String eid,Model model)
    {
        System.out.println("update method is called");
        if(service.SearchEmployee(eid)!=null)
        {
            model.addAttribute("singleEmployee",service.SingleEmployee(eid));
            return "updateEmployee";
        }
        else{
            String res="Employee not found";
            model.addAttribute("res",res);
            return "updateResult";
        }

    }
    @RequestMapping("/SuccesfullUpdate")
    public String SuccesfullUpdate(Employee employee,Model model)
    {

        String res=service.UpdateEmployee(employee);
        model.addAttribute("res",res);
        return "redirect:/viewEmployees?reload=true";

    }

    //searching employee
    @RequestMapping("/Singleemployee")
    public String Singleemployee()
    {
        System.out.println("Bhanuprakash");
        return "SearchEmployee";
    }
    @RequestMapping("/SearchEmployee")
    public String SearchEmployee( String eid,Model model)
    {
        System.out.println("METHOD CALLED");
        System.out.println(eid);
        Employee e2=service.SingleEmployee(eid);
        System.out.println(e2.getEname());
        model.addAttribute("employee",e2);
        return "singleEmployee";
    }



//

}