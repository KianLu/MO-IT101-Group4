/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.employee.motorphv4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Kenneth Lu
 */
public class MotorPHv4 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
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
        System.out.println("=============================");
        System.out.println("Please select from the menu..");
        System.out.println("=============================");
        System.out.println("1. Employee Information");
        System.out.println("2. View Gross Earnings");
        System.out.println("3. View Net Earnings");
     
        // Creating an object for the scanner //
        Scanner opt = new Scanner(System.in);
        System.out.println("=============================");
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
                employeeInformation();
                break;
            case "2":
                viewGrossEarnings();
                break;
            case "3":
                viewNetEarnings();
                break;
          // If inputted wrong information //
            default:
                System.out.println("You entered an incorrect option.");
                Thread.sleep(1500);
                System.out.println("Exiting now......Goodbye");
                break;
    }
}    
// This is the class you will go to when you inputted "1" as your choice //
// The employeeInformation class is the one responsible of printing the Employee's Information by using the Employee's ID // 
private static void employeeInformation() throws IOException {
        //Maximum of 3 attempts to input the Employee's ID //
        int MAX_ATTEMPTS = 3;
        int attempts = 0;
        boolean cont = true;
        while (cont) {
        Scanner scan = new Scanner(System.in);
        String str;
        System.out.print("Enter Employee ID: ");
        String lookup = scan.nextLine();
        attempts++;
        // When you reach the maximum amount of attempts this text will be printed //
        if (attempts==MAX_ATTEMPTS) { System.out.println("You have reached the max attempt!"); break; }
        
        // The BufferedReader and the FileReader is where the Scanner checks the Employee ID imputted if it matches the data from the txt file //
        // Change the file address to where you downloaded and put the txt file // 1/3 //
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kenneth Lu\\Documents\\NetBeansProjects\\MotorPHv4\\MotorPH Employee Datav4.txt"));
        
        // If employee ID has been found in the txt file it will print out the needed information of the employee //
        boolean found = false;
        while ((str = br.readLine()) != null) {
            if (str.contains(lookup)) { 
                String[] values = str.split(",");
                String empNum = values[0];
                String empName = values[2] + " " + values[1];
                String birthDate = values[3];
                String empPosition = values[11];
                String empStatus = values[10];
                String empAdrs = values[4];
                System.out.println("*=================*EMPLOYEE INFO*=================*");
                System.out.println("Employee Number: " + empNum);
                System.out.print("Employee Name: " + empName); System.out.println("     " + "DOB: " +  birthDate); 
                System.out.print("Position: " + empPosition); System.out.println("     " + "Status: " + empStatus);
                System.out.println("Address: " + empAdrs);
                System.out.println("*=================*=============*=================*");
                System.out.println("Thank you for using the MotorPH Payroll System!");
                found = true;
                break;
            }
        }
        // This text prints out when you inputted the wrong Employee ID //
        if(!found) {
                System.out.println("Invalid Employee ID...");
            }
        cont = !found; }
}
// This is the class you will go to when you inputted "2" as your choice //
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
        eGros.sethRate(hrs);
        
        // Change the file address to where you downloaded and put the txt file // 2/3 //
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kenneth Lu\\Documents\\NetBeansProjects\\MotorPHv4\\MotorPH Employee Datav4.txt"));
        
        // If employee ID has been found in the csv file and have inputed the hourly rate of the employee// 
        //it will print out the employee's number and name and the code will calculate the hourly rate, gross earnings// 
        // and the employee's benefits using the employee data on the txt file//
        boolean found = false;
        while ((str = br.readLine()) != null) {
            if (str.contains(lookup)) { 
                String[] values = str.split(",");
                String empNum = values[0];
                String empName = values[2] + " " + values[1];
                String hrRate = values[18];
                String riceSub = values[14];
                String clothAllowance = values[15];
                String phoneAllowance = values[16];
                System.out.println("*=================*EMPLOYEE GROSS EARNINGS*=================*");
                System.out.println("Employee Number: " + empNum);
                System.out.println("Employee Name: " + empName);
                System.out.println("Hourly Rate: " +  hrRate);
                System.out.print("Gross Earnings: "); 
                try{
                double hours = Double.parseDouble(hrRate);
                double grossRiceSub = Double.parseDouble(riceSub);
                double grossClothAllowance = Double.parseDouble(clothAllowance);
                double grossPhoneAllowance = Double.parseDouble(phoneAllowance);
                System.out.println(df.format(eGros.gethRate()*(hours)+(grossRiceSub)+(grossClothAllowance)+(grossPhoneAllowance)));
                }
                catch (NumberFormatException ex) {
                }
                System.out.println("*=================*EMPLOYEE BENEFITS*=================*");
                System.out.println("Rice Subsidy: " + riceSub);
                System.out.println("Clothing Allowance: " + clothAllowance);
                System.out.println("Phone Allowance: " + phoneAllowance);
                System.out.println("==================*=================*==================");
                System.out.println("Thank you for using the MotorPH Payroll System!");
                found = true;
                break;
            }
        }
        if(!found) {
                System.out.println("Invalid Employee ID...");
            }
        cont = !found; }
    }

// This is the class you will go to when you inputted "3" as your choice //
// The viewNetEarning class is the one responsible of printing the Employee's Net Earnings based on their hourly rate // 
private static void viewNetEarnings() throws IOException {
        int MAX_ATTEMPTS = 3;
        int attempts = 0;
        boolean cont = true;
        while (cont) {
        SalaryData eGros = new SalaryData();
        Scanner scan = new Scanner(System.in);
        String str;
        System.out.print("Enter Employee ID: ");
        String lookup = scan.nextLine();
        attempts++;
        if (attempts==MAX_ATTEMPTS) { System.out.println("You have reached the max attempt!"); break; }
        System.out.print("Enter Hours Worked: ");
        int hrs = scan.nextInt();
        eGros.sethRate(hrs);
        
        
        // Change the file address to where you downloaded and put the txt file // 3/3 //
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kenneth Lu\\Documents\\NetBeansProjects\\MotorPHv4\\MotorPH Employee Datav4.txt"));
        
        // If employee ID has been found in the txt file and have inputed the hourly rate of the employee// 
        //it will print out the employee's number and name, and it will calculate the employee's gross earnings and it will calculate// 
        // the employee's salary deduction that is from the employee database txt file and it will print out the final net earnings of //
        // the employee after the deductions. it will also print out where the deductions come from and how much //
        boolean found = false;
        while ((str = br.readLine()) != null) {
            if (str.contains(lookup)) { 
                String[] values = str.split(",");
                String empNum = values[0];
                String empName = values[2] + " " + values[1];
                String hrRate = values[18];
                String riceSub = values[14];
                String clothAllowance = values[15];
                String phoneAllowance = values[16];
                String sss = values[25];
                String phHlth = values[26];
                String whTax = values[27];
                String pagibig = values[28];
                System.out.println("*================*EMPLOYEE NET EARNINGS*================*");
                System.out.println("Employee Number: " + empNum);
                System.out.println("Employee Name: " + empName);
                System.out.println("Hourly Rate: " +  hrRate);
                System.out.print("Gross Earnings: "); 
                try{
                double hours = Double.parseDouble(hrRate);
                double netRiceSub = Double.parseDouble(riceSub);
                double netClothAllowance = Double.parseDouble(clothAllowance);
                double netPhoneAllowance = Double.parseDouble(phoneAllowance);
                System.out.println(df.format(eGros.gethRate()*(hours)+(netRiceSub)+(netClothAllowance)+(netPhoneAllowance)));
                }
                catch (NumberFormatException ex) {
                }
                
                // This is where we calculate the deduction for the net earning and print out the employee deductions using the txt file// 
                System.out.print("Net Earnings (After Deductions): ");
                try{
                double hours = Double.parseDouble(hrRate);
                double netRiceSub = Double.parseDouble(riceSub);
                double netClothAllowance = Double.parseDouble(clothAllowance);
                double netPhoneAllowance = Double.parseDouble(phoneAllowance);
                double xsss = Double.parseDouble(sss);
                double xphHlth = Double.parseDouble(phHlth);
                double xwhTax = Double.parseDouble(whTax);
                double xpagibig = Double.parseDouble(pagibig);
                System.out.println(df.format(eGros.gethRate()*(hours)+(netRiceSub)+(netClothAllowance)+(netPhoneAllowance)-(xsss)-(xphHlth)-(xwhTax)-(xpagibig)));
                }
                catch (NumberFormatException ex) {
                }
                System.out.println("*================*EMPLOYEE DEDUCTIONS*================*");
                System.out.println("SSS: " + sss);
                System.out.println("PhilHealth: " + phHlth);
                System.out.println("Pag-Ibig: " + pagibig);
                System.out.println("Witholding Tax: " + whTax);
                System.out.println("=================*===================*================-");
                System.out.println("Thank you for using the MotorPH Payroll System!");
                found = true;
                break;
            }
        }
        if(!found) {
                System.out.println("Invalid Employee ID...");
            }
        cont = !found; }
    }
    
        
    
}
