/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.motorphv4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kenneth Lu
 */
public class EmployeeListFile extends EmployeeModel {
    
    public EmployeeListFile() throws FileNotFoundException, IOException{
        
        String filePath = "C:\\Users\\Kenneth Lu\\Documents\\NetBeansProjects\\MotorPHv4\\MotorPH Employee Datav4.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        employeeList = getEmployees(br);


    }
    
    @Override
    public List<Employee> getEmployeeModelList() {
        return employeeList;
    }
    
    public static  List<Employee> getEmployees(BufferedReader br) throws IOException
    {
//       BufferedReader br = getEmployeeListFile();
       String str;
       List<Employee> employeeList = new ArrayList<>();
       
        str = br.readLine();
        while ((str = br.readLine()) != null) {
   
            var values = str.split(",");
            
        var employee = new Employee();
        employee.setEmpNumber(values[0]);
        employee.setEmpPhoneNumber(values[5]);
        employee.setEmpLastName(values[1]);
        employee.setEmpFirstName(values[2]);
          employee.setBirthDate(values[3]);
          employee.setEmpPosition(values[11]);
          employee.setEmpStatus(values[10]);
          employee.setEmpAddress(values[4]);
          employee.setHourlyRate (Double.parseDouble(values[18]));
          employee.setRiceSubsidy(Double.parseDouble(values[14]));
          employee.setClothingAllowance(Double.parseDouble(values[16]));
          employee.setPhoneAllowance(Double.parseDouble(values[15]));
          employee.setSSSDeduction(Double.parseDouble(values[25]));
          employee.setPhilHealthDedution(Double.parseDouble(values[26]));
          employee.setWithHoldingTax(Double.parseDouble(values[27]));
          employee.setPagibigDeductions(Double.parseDouble(values[28]));
          employeeList.add(employee);
         
             
        }
        
      // employeeList = employeeList.stream().filter(emp -> emp.getClothingAllowance() == 1000 && emp.getPhoneAllowance() == 1000).toList();
        
     
        
        return employeeList;
    }
}
