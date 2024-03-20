/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.employee.motorphv4;


import static com.employee.motorphv4.BufferReader.getEmployeeDetails;
import static com.employee.motorphv4.BufferReader.getEmployees;
import static com.employee.motorphv4.Utilities.formatDate;
import static com.employee.motorphv4.Utilities.spacingInfo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Kenneth Lu
 */
public class MotorPHv4 {
   private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    //updated motorPH code //
    public static void main(String[] args) throws IOException, InterruptedException {
    // This is the code for the welcome to the MotorPH Payroll Portal //
    // Printing the text from object class Greetings.java and prints out the menu selection//
    //Thread.sleep is a java code that delays the output of the text to create a loading effect/illusion//
        Greetings gr = new Greet2() {};
        gr.welcome();
        Thread.sleep(1500);
        gr.greets();
        Thread.sleep(1500);
        System.out.println("==================================");
        System.out.println("Please select from the menu..");
        System.out.println("==================================");
        System.out.println("1. View Employees");
        System.out.println("2. View Employee Details");
        System.out.println("3. View Employee's Gross Earnings");
        System.out.println("4. View Employee's Net Earnings");
     
        // Creating an object for the scanner //
        Scanner opt = new Scanner(System.in);
        System.out.println("==================================");
        Thread.sleep(1500);
        // takes input from keyboard on the terminal //
        System.out.print("Enter your selection..: ");
        String select = opt.nextLine();
        // Prints the option that you inputted //
        System.out.println("You selected option #" + select);
        selectOpt(select);
        // closes the scanner //
        opt.close();
        
    }
    private static void selectOpt(String select) throws IOException, InterruptedException {
        // Used conditional branch "switch" statement //
        // Base on the input you entered or the number you entered in the terminal you will be transported to the its perspective class //
        switch (select) {
            case "1":
                employees();
                break;
            case "2":
                employeeDetails();
                break;
            case "3":
                viewGrossEarnings();
                break;
            case "4":
                viewNetEarnings();
                break;
          // If inputted wrong information //
            default:
                System.out.println("You entered an incorrect option.");
                Thread.sleep(1500);
                System.out.println("Exiting now......Goodbye");
                break;
    }
}   // This is the method you will go to when you inputted "1" as your choice //
    // The allEmployeeInfo method when selected it will print all 34 employee's ID, First and Last Name, and Birthday of the employees // 
    
    private static void employees() throws IOException {

       // String str;
      
        List<Employee> employeeList = getEmployees();
        
        boolean headerFlg = true;
        for(Employee employee : employeeList)
        {
             String empNumber =  spacingInfo(employee.getEmpNumber(),20);
             String empName = spacingInfo("[" + employee.getEmpLastName() + "]",20) + spacingInfo("[" + employee.getEmpFirstName() + "]",20);
             String birthDate;
            
            if (headerFlg)
            {
                 birthDate = spacingInfo(employee.getBirthDate(),20);
                 headerFlg = false;
            }
            else
            {
                 birthDate = spacingInfo(formatDate(employee.getBirthDate(), "MMM dd, yyyy"),20);
            }
      
          
                System.out.println(empNumber + empName + birthDate);
        
        }
    }
    
// This is the method you will go to when you inputted "2" as your choice //
// The employeeInformation class is the one responsible of printing the Employee's Information by using the Employee's ID // 
    
private static void employeeDetails() throws IOException {
        //Maximum of 3 attempts to input the Employee's ID //
        int MAX_ATTEMPTS = 3;
        int attempts = 0;
        boolean cont = true;
       
        while (cont) {
        Scanner scan = new Scanner(System.in);
       // String str;
        System.out.print("Enter Employee ID: ");
        String lookup = scan.nextLine();
        attempts++;
        
        // When you reach the maximum amount of attempts this text will be printed //
        if (attempts==MAX_ATTEMPTS) { System.out.println("You have reached the max attempt!"); break; }
        
        Employee employee = getEmployeeDetails(lookup);
        boolean found = false;
        if (employee!=null)
        {
                String empNumber = employee.getEmpNumber();
                String empName = employee.getEmpLastName()+ " " + employee.getEmpFirstName();
                String birthDate = formatDate(employee.getBirthDate(), "MMM dd, yyyy");
                String empPhoneNumber = employee.getEmpPhoneNumber();
             
                String empPosition = employee.getEmpPosition();
                String empStatus = employee.getEmpStatus();
                String empAddress = employee.getEmpAddress();
                 
           System.out.println("*=================*EMPLOYEE INFO*=================*");
                System.out.print("Employee Number: " + empNumber); System.out.println("     " + "Phone Number: " + empPhoneNumber);
                System.out.print("Employee Name: " + empName); System.out.println("     " + "DOB: " +  birthDate); 
                System.out.print("Position: " + empPosition); System.out.println("     " + "Status: " + empStatus);
                System.out.println("Address: " + empAddress);
                System.out.println("*=================*=============*=================*");
                System.out.println("Thank you for using the MotorPH Payroll System!");
                
                break;
        }
        else
        {
                   System.out.println("Invalid Employee ID...");   
        }
         cont = !found; 
        }
}
// This is the method you will go to when you inputted "3" as your choice //
// The viewGrossEarning class is the one responsible of printing the Employee's Gross Earning based on their hourly rate // 
private static void viewGrossEarnings() throws IOException {
        int MAX_ATTEMPTS = 3;
        int attempts = 0;
        boolean cont = true;
        while (cont) {
        // Creating a SalaryData Object //
        SalaryData eGros = new SalaryData();
        Scanner scan = new Scanner(System.in);
        String str;
        System.out.print("Enter Employee ID: ");
        String lookup = scan.nextLine();
        attempts++;
        
        if (attempts==MAX_ATTEMPTS) { System.out.println("You have reached the max attempt!"); break; }
        // When you entered the Employee ID successfully you will need to input the Hours Worked of the Employee // 
        
        System.out.print("Enter Hours Worked: ");
        int hrs = scan.nextInt();
        eGros.setHourlyRate(hrs);
        
        // If employee ID has been found in the csv file and have inputed the hourly rate of the employee// 
        //it will print out the employee's number and name and the code will calculate the hourly rate, gross earnings// 
        // and the employee's benefits using the employee data on the txt file//
        
       Employee employee = getEmployeeDetails(lookup);
                boolean found = false;
                if (employee!=null)
                {
                    String empNumber = employee.getEmpNumber();
                    String empName = employee.getEmpLastName()+ " " + employee.getEmpFirstName();
                    Double hourlyRate = employee.getHourlyRate();
                    Double riceSubsidy = employee.getRiceSubsidy();
                    Double clothAllowance = employee.getClothingAllowance();
                    Double phoneAllowance = employee.getPhoneAllowance();
                 
                    GrossEarningCalculator gec = new GrossEarningCalculator();
                    gec.setHourlyRate(hourlyRate);
                    gec.setRiceSubsidy(riceSubsidy);
                    gec.setClothingAllowance(clothAllowance);
                    gec.setPhoneAllowance(phoneAllowance);

                    String grossEarnings = GrossEarningCalculator.CalculateGrossEarnings(gec);
                        
                    System.out.println(grossEarnings);
                    System.out.println("*==============*EMPLOYEE GROSS EARNINGS*==============*");
                    System.out.println("Employee Number: " + empNumber);
                    System.out.println("Employee Name: " + empName);
                    System.out.println("Hourly Rate: " +  hourlyRate);
                    System.out.println("Gross Earnings: " + grossEarnings); 
                    System.out.println("*=================*EMPLOYEE BENEFITS*=================*");
                    System.out.println("Rice Subsidy: " + riceSubsidy);
                    System.out.println("Clothing Allowance: " + clothAllowance);
                    System.out.println("Phone Allowance: " + phoneAllowance);
                    System.out.println("==================*=================*==================");
                    System.out.println("Thank you for using the MotorPH Payroll System!");
                    break;
                }
                else
                {
                    System.out.println("Invalid Employee ID...");   
                }

                cont = !found; 
        
            }
}
// This is the method you will go to when you inputted "4" as your choice //
// The viewNetEarning class is the one responsible of printing the Employee's Net Earnings based on their hourly rate // 
private static void viewNetEarnings() throws IOException {
        int MAX_ATTEMPTS = 3;
        int attempts = 0;
        boolean cont = true;
        while (cont) {
        SalaryData eGros = new SalaryData();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        String lookup = scan.nextLine();
        attempts++;
        
        if (attempts==MAX_ATTEMPTS) { System.out.println("You have reached the max attempt!"); break; }
        System.out.print("Enter Hours Worked: ");
        int hrs = scan.nextInt();
        eGros.setHourlyRate(hrs);
        
       
        Employee employee = getEmployeeDetails(lookup);
            boolean found = false;
            if (employee!=null)
            {
                String empNumber = employee.getEmpNumber();
                String empName = employee.getEmpLastName()+ " " + employee.getEmpFirstName();
                Double hourlyRate = employee.getHourlyRate();
                Double riceSubsidy = employee.getRiceSubsidy();
                Double clothAllowance = employee.getClothingAllowance();
                Double phoneAllowance = employee.getPhoneAllowance();
                Double sss = employee.getSSSDeduction();
                Double philHealth = employee.getPhilHealthDedution();
                Double pagibig = employee.getPagibigDeductions();
                Double withHoldingTax = employee.getWithHoldingTax();

                GrossEarningCalculator gec = new GrossEarningCalculator();
                gec.setHourlyRate(hourlyRate);
                gec.setRiceSubsidy(riceSubsidy);
                gec.setClothingAllowance(clothAllowance);
                gec.setPhoneAllowance(phoneAllowance);

                String grossEarnings = GrossEarningCalculator.CalculateGrossEarnings(gec);

                NetEarningCalculator nec = new NetEarningCalculator();
                nec.setSSSDeduction(sss);
                nec.setPagibigDeductions(pagibig);
                nec.setHourlyRate(hourlyRate);
                nec.setRiceSubsidy(riceSubsidy);
                nec.setClothingAllowance(clothAllowance);
                nec.setPhoneAllowance(phoneAllowance);
                nec.setPhilHealthDedution(philHealth);
                nec.setWithHoldingTax(withHoldingTax);
                    
                String netEarnings = NetEarningCalculator.CalculateNetEarnings(nec);
                
                System.out.println(netEarnings);
                System.out.println("*================*EMPLOYEE NET EARNINGS*================*");
                System.out.println("Employee Number: " + empNumber);
                System.out.println("Employee Name: " + empName);
                System.out.println("Hourly Rate: " +  hourlyRate);
                System.out.println("Gross Earnings: " + grossEarnings); 
                System.out.println("Net Earnings (After Deductions): " + netEarnings);
                System.out.println("*===============*EMPLOYEE DEDUCTIONS*================*");
                System.out.println("SSS: " + sss);
                System.out.println("PhilHealth: " + philHealth);
                System.out.println("Pag-Ibig: " + pagibig);
                System.out.println("Witholding Tax: " + withHoldingTax);
                System.out.println("=================*===================*================-");
                System.out.println("Thank you for using the MotorPH Payroll System!");
                break;
            }
            else
            {
                System.out.println("Invalid Employee ID...");   
            }

            cont = !found; 

        }

    }
}
    

