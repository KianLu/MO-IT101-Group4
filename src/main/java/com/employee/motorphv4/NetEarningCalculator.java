/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.motorphv4;

import java.text.DecimalFormat;

/**
 *
 * @author Kenneth Lu 
 */
// A class to calculate the employee's Net Earnings and Deductions

public class NetEarningCalculator {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    
    private double sssDeductions;
    private double philHealthDedutions;
    private double withHoldingTax;
    private double pagibigDeductions;
    private double clothingAllowance;
    private double phoneAllowance;
    private double hourlyRate;
    private double riceSubsidy;
    
    
    public double getSSSDeduction(){
        
        return sssDeductions;
    }
    
    public void setSSSDeduction(double sssDeductions) {
        this.sssDeductions = sssDeductions;
    }
    
      public double getPhilHealthDedution(){
        
        return philHealthDedutions;
    }
    
    public void setPhilHealthDedution(double philHealthDedutions) {
        this.philHealthDedutions = philHealthDedutions;
    }
    
     public double getWithHoldingTax(){
        
        return withHoldingTax;
    }
    
    public void setWithHoldingTax(double withHoldingTax) {
        this.withHoldingTax = withHoldingTax;
    }
    
    public double getPagibigDeductions(){
        
        return pagibigDeductions;
    }
    
    public void setPagibigDeductions(double pagibigDeductions) {
        
        this.pagibigDeductions = pagibigDeductions;
    }
    
    public double getClothingAllowance(){
        
        return clothingAllowance;
    }
    
    public void setClothingAllowance(double clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }
    
    
    public double getPhoneAllowance(){
        
        return phoneAllowance;
    }
    
    public void setPhoneAllowance(double phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }
    
    public double getHourlyRate(){
        
        return hourlyRate;
    }
    
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    public double getRiceSubsidy(){
        
        return riceSubsidy;
    }
    
    public void setRiceSubsidy(double riceSubsidy) {
        this.riceSubsidy = riceSubsidy;
    }
    

    
    public static String CalculateNetEarnings(NetEarningCalculator nec) {
        String netEarnings = decimalFormat.format(nec.getHourlyRate()*(nec.hourlyRate)+(nec.riceSubsidy)+(nec.clothingAllowance)+(nec.phoneAllowance)-(nec.sssDeductions)-(nec.philHealthDedutions)-(nec.withHoldingTax)-(nec.philHealthDedutions));
          
        return netEarnings;
        
   
    }


}

