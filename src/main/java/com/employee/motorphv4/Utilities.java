/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.motorphv4;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Kenneth Lu
 */
public class Utilities {
    
    // This Method spaces out the txt file data in allEmployeeInfo() // 
     public static String spacingInfo (String inputString, int length)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(' ');
        }

        return inputString + sb.substring(inputString.length())  ;

    }
    
    public static String formatDate (String value, String format)
    {
      // Code to change the appearance of the BirthDate //
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy", Locale.ENGLISH);
                LocalDate localDate = LocalDate.parse(value, formatter);
                
                ZoneId defaultZoneId = ZoneId.systemDefault();
                Date mydate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
                
                String pattern = format;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
                String birthday = simpleDateFormat.format(mydate);
     
     return birthday;
    }
    
}
