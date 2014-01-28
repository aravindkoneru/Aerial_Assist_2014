package org.firstrobotics1923.system;

import org.firstrobotics1923.util.DefaultConfig;
import org.firstrobotics1923.util.MotorGroup;

/**
 * The Shooter System
 * 
 * @author Kartik Vaidya, Pavan Hegde 
 * @version 1.4
 * @since Jan 26, 2014 
 *
 */
public class ShooterSystem implements System {

    private final MotorGroup frontWheels, backWheels;
    private double speed = DefaultConfig.SHOOTER_SPEED;
    
    /**
     * Creates a ShooterSystem with A set of front and back wheels
     * @param backWheels
     *              The motor group made of the Victors controlling the back wheels
     * @param frontWheels 
     *              The motor group made of the Victors controlling the front wheels
     */
    public ShooterSystem(MotorGroup backWheels, MotorGroup frontWheels) {
       this.backWheels = backWheels;
       this.frontWheels = frontWheels;
    }
    
    /**
    * Starts Motors at set speed 
    */
    public void activate() {
        frontWheels.set(speed);
        backWheels.set(speed);
    }
    
    /**
     * Increases the speed of the motors by a constant
     */
    public void increaseSpeed(){
        if(speed + DefaultConfig.SPEED_INCREMENT > 1.0){
            speed = 1.0;
        }else {
            speed += DefaultConfig.SPEED_INCREMENT;  
        }
    }
    
    /**
     * Decreases the speed of the motors by a constant
     */
    public void decreaseSpeed(){
        if(speed - DefaultConfig.SPEED_INCREMENT < 0.0){
            speed = 0.0;
        }else {
            speed -= DefaultConfig.SPEED_INCREMENT;
        }
    }
    
    /**
    * Stops the Motors on the shooter
    */
    public void stop() {
        frontWheels.disable();
        backWheels.disable();
    }
}
