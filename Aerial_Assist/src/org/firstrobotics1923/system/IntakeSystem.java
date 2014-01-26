package org.firstrobotics1923.system;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *System to control the Intake System
 * 
 * @author Aryak Pande , Pavan Hedge, Kartik Vaidya, Prasanth Yedlapalli, Saikiran Nakka, DJ Wadhwa, Nithin Suresh
 * @version 1.1
 * @since Jan 24, 2014
 */
public class IntakeSystem extends PneumaticSystem{
    /**
     * prepare the variables
     */
    private final Solenoid pistonControllerOne,pistonControllerTwo; 
    private final SpeedController intakeMotorController;
    
    /**
     * Creates an IntakeSystem with parameters pistonControllerOne, pistonControllerTwo, and motorController
     * 
     * @param pistonControllerOne
     *                          One of Two Solenoid objects that controls the shooter intake system  
     * @param pistonControllerTwo
     *                          One of Two Solenoid objects that controls the shooter intake system 
     * @param motorController 
     *                          The motors that turns to spin the ball before releasing it.
     */
    public IntakeSystem(Solenoid pistonControllerOne, Solenoid pistonControllerTwo, SpeedController motorController){        
        this.pistonControllerOne = pistonControllerOne;
        this.pistonControllerTwo = pistonControllerTwo;
        this.intakeMotorController = motorController;
    }
    
    /**
     * Activates intake pistons
     */
    public void activate(){       
        pistonControllerOne.set(false);
        pistonControllerTwo.set(true);
    }
    
    /**
     * Activates the Intake Motor
     */
    public void activateMotor() {
        this.intakeMotorController.set(0.5);    //TODO (update) 
    }
    
    /**
     * deactivates the piston
     */
    public void deactivate(){
        pistonControllerOne.set(true);
        pistonControllerTwo.set(false); 
    }
    
    /**
     * deactivates the motor
     */
    public void deactivateMotor() { 
        this.intakeMotorController.set(0.0);
    }
    
    /**
     * This deactivates the Piston and Stops the Motors
     */
    public void stop(){
        pistonControllerOne.set(false);
        pistonControllerTwo.set(false);
        intakeMotorController.set(0.0);
    }
    
}
