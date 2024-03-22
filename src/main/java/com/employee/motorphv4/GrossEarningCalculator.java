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
// A class to calculate the employee's Gross Earnings and Benefits

public class GrossEarningCalculator {
    
     private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    
    private double hourlyRate;
    private double riceSubsidy;
    private double clothingAllowance;
    private double phoneAllowance;
    
    
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
     
     public static String CalculateGrossEarnings(GrossEarningCalculator gec) {
        String grossEarnings = decimalFormat.format(gec.getHourlyRate()*(gec.hourlyRate)+(gec.riceSubsidy)+(gec.clothingAllowance)+(gec.phoneAllowance));
          
        return grossEarnings;
     }
    
}
