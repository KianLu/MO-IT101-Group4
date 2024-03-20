/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.motorphv4;

import static com.employee.motorphv4.Utilities.formatDate;
import static com.employee.motorphv4.Utilities.spacingInfo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kenneth Lu
 */
public class BufferReader {
    private static BufferedReader getBufferReader( ) throws IOException
    {
        String filePath = "C:\\Users\\Kenneth Lu\\Documents\\NetBeansProjects\\MotorPHv4\\MotorPH Employee Datav4.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
   
        return br;
    }
    
    public static  List<Employee> getEmployees() throws IOException
    {
       BufferedReader br = getBufferReader();
       String str;
       List<Employee> employeeList = new ArrayList<Employee>();
       
        
        while ((str = br.readLine()) != null) {
   
            var values = str.split(",");
            
            var employee = new Employee();
            employee.setEmpNumber(values[0]);
            employee.setEmpLastName(values[1]);
            employee.setEmpFirstName(values[2]);
            employee.setBirthDate(values[3]);        
            employeeList.add(employee);
         
             
        }
        
        return employeeList;
    }
    
    public static Employee getEmployeeDetails(String empNum) throws IOException
    {
       BufferedReader br = getBufferReader();
       String str;
       
        while ((str = br.readLine()) != null) {
            var values = str.split(",");
            if (values[0].equals(empNum))
            {
                
              Employee employee = new Employee();
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
              return employee;
            }
                
        
        }
       
      
        
        
        return null;
        
    }
}
