package org.firstrobotics1923.system;

import org.firstrobotics1923.util.DefaultConfig;
import org.firstrobotics1923.util.MotorGroup;

/**
 * The Shooter System
 * 
 * @author Kartik Vaidya , Christopher Cushman, Prasanth Yedlapalli, Saikiran Nakka, Kartik Vaidya, DJ Wadhwa, Nithin Suresh
 * @version 1.4
 * @since Jan 26, 2014 
 *
 */
public class ShooterSystem implements System {

    private final MotorGroup frontWheels, backWheels;
    private double speed = DefaultConfig.SHOOTER_SPEED;
    
    public ShooterSystem(MotorGroup backWheels, MotorGroup frontWheels) {
       this.backWheels = backWheels;
       this.frontWheels = frontWheels;
    }
    
    /**
    * Activates Victor at set speed 
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
    * Stops the Victor
    */
    public void stop() {
        frontWheels.disable();
        backWheels.disable();
    }
}
