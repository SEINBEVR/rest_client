package com.kirillvasilev.spring.rest;

import com.kirillvasilev.spring.rest.configuration.MyConfig;
import com.kirillvasilev.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class App 
{
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);
        List<Employee> allEmployees = communication.getAllEmployees();

        System.out.println(allEmployees);

        Employee empById = communication.getEmployee(2);
        System.out.println(empById);

        Employee employee = new Employee("Ivan", "Terehin", "HR", 1300);
        communication.saveEmployee(employee);
        employee.setId(5);
        communication.saveEmployee(employee);
        communication.deleteEmployee(5);
    }
}
