/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.motorphv4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kenneth Lu
 */
public class EmployeeListClass extends EmployeeModel{
    
       

    public  EmployeeListClass(){
        
 
        employeeList= new ArrayList<>();
        Employee employee1 = new Employee();
        
        employee1.setEmpNumber("1Garcia");
        employee1.setEmpLastName("Garcia");
        employee1.setEmpFirstName("Manuel III");
        employee1.setBirthDate("10/11/1983");
        employee1.setEmpAddress("Valero Carpark Building Valero Street 1227 Makati City");
        employee1.setEmpPhoneNumber("966-860-270");
        employee1.setEmpPosition("Chief Executive Officer");
        employee1.setEmpStatus("Regular");
        employee1.setHourlyRate(Double.parseDouble("535.71"));
        employee1.setRiceSubsidy(Double.parseDouble("1500"));
        employee1.setClothingAllowance(Double.parseDouble("1000"));
        employee1.setPhoneAllowance(Double.parseDouble("2000"));
        employee1.setSSSDeduction(Double.parseDouble("500"));
        employee1.setPhilHealthDedution(Double.parseDouble("100"));
        employee1.setWithHoldingTax(Double.parseDouble("1500"));
        employee1.setPagibigDeductions(Double.parseDouble("150"));
        employeeList.add(employee1);
        
        Employee employee2 = new Employee();
        
        employee2.setEmpNumber("2Lim");
        employee2.setEmpLastName("Lim");
        employee2.setEmpFirstName("Antonio");
        employee2.setBirthDate("06/19/1988");
        employee2.setEmpAddress("San Antonio De Padua 2 Block 1 Lot 8 and 2 Dasmarinas Cavite");
        employee2.setEmpPhoneNumber("171-867-411");
        employee2.setEmpPosition("Chief Operating Officer");
        employee2.setEmpStatus("Regular");
        employee2.setHourlyRate(Double.parseDouble("357.14"));
        employee2.setRiceSubsidy(Double.parseDouble("1500"));
        employee2.setClothingAllowance(Double.parseDouble("1000"));
        employee2.setPhoneAllowance(Double.parseDouble("2000"));
        employee2.setSSSDeduction(Double.parseDouble("500"));
        employee2.setPhilHealthDedution(Double.parseDouble("100"));
        employee2.setWithHoldingTax(Double.parseDouble("1500"));
        employee2.setPagibigDeductions(Double.parseDouble("150"));
        employeeList.add(employee2);
    
  
    }

        @Override
    public List<Employee> getEmployeeModelList() {
        return employeeList;
    }
    
    
}
