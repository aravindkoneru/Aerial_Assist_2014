package org.firstrobotics1923.system;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import org.firstrobotics1923.util.DefaultConfig;

/**
 * The intake system on the robot
 * 
 * @author Aryak Pande , Pavan Hedge, Kartik Vaidya, Prasanth Yedlapalli, Saikiran Nakka, DJ Wadhwa, Nithin Suresh
 * @version 1.5
 * @since Jan 26, 2014
 */
public class IntakeSystem extends PneumaticSystem {
 
    private final Solenoid pistonControllerOne,pistonControllerTwo; 
    private final Relay intakeMotorController;
    
    /**
     * Creates an IntakeSystem with parameters pistonControllerOne, pistonControllerTwo, and motorController
     * 
     * @param pistonControllerOne
     *                          One of Two Solenoid objects that controls the shooter intake angle  
     * @param pistonControllerTwo
     *                          One of Two Solenoid objects that controls the shooter intake angle 
     * @param intakeSpike 
     *                          The Spike which controls the motors on the intake system
     */
    public IntakeSystem(Solenoid pistonControllerOne, Solenoid pistonControllerTwo, Relay intakeSpike){        
        this.pistonControllerOne = pistonControllerOne;
        this.pistonControllerTwo = pistonControllerTwo;
        this.intakeMotorController = intakeSpike;
    }
    
    /**
     * Extends the pistons angling the intake system
     */
    public void activate(){       
        pistonControllerOne.set(false);
        pistonControllerTwo.set(true);
    }
    
    /**
     * Starts the motors on the Intake system
     */
    public void activateMotor() {
        this.intakeMotorController.set(Relay.Value.kOn);     
    }
    
    /**
     * Retracts the piston and thus the Intake system
     */
    public void deactivate(){
        pistonControllerOne.set(true);
        pistonControllerTwo.set(false); 
    }
    
    /**
     * Turns off the motor
     */
    public void deactivateMotor() { 
        this.intakeMotorController.set(Relay.Value.kOff);
    }
    
    /**
     * Retracts the piston and turns off the motor
     */
    public void stop(){
        pistonControllerOne.set(true);
        pistonControllerTwo.set(false);
        intakeMotorController.set(Relay.Value.kOff);
    }
}
