/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.motorphv4;

/**
 *
 * @author Kenneth Lu
 */
// Java class object for welcome and please wait function on the main MOtorPH code //

abstract class Greetings {
    // Greetings gr = new Greet2() {};
       // gr.welcome(); //
    public void welcome() {
        System.out.println("Welcome to the MotorPH Payroll Portal");
    }
    public abstract void greets();
}
        // gr.greets(); //
class Greet2 extends Greetings {
        public void greets() {
            System.out.println("Please wait...");
        }
}
