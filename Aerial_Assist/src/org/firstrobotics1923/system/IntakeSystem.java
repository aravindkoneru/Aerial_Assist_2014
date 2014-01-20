/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.firstrobotics1923.system;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *System to control the Intake System
 * 
 * @author Aryak Pande , Pavan Hedge
 * @version 0.2
 */
public class IntakeSystem extends PneumaticSystem{
    
    private Solenoid pistonControllerOne,pistonControllerTwo;
    private SpeedController intakeMotor;
    
    public IntakeSystem(Solenoid pistonControllerOne, Solenoid pistonControllerTwo, SpeedController intakeMotor){        
        this.pistonControllerOne = pistonControllerOne;
        this.pistonControllerTwo = pistonControllerTwo;
        this.intakeMotor = intakeMotor;
    }
    
    public void activate(){       
        pistonControllerOne.set(false);
        pistonControllerTwo.set(true);
    }
    
    public void activateMotor() {
        this.intakeMotor.set(0.5);  //TODO update value
    }
    
    public void deactivate(){
        pistonControllerOne.set(true);
        pistonControllerTwo.set(false);
    }
    
    public void deactivateMotor() {
        this.intakeMotor.set(0.0);
    }
 
    public void stop(){
        //TODO    
    }
    
}
