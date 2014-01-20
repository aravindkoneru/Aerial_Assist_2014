package org.firstrobotics1923.system;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import org.firstrobotics1923.util.MotorGroup;

/**
 * The Drive System
 * 
 * @author Pavan Hegde
 * @version 1.0
 * @since Jan 20, 2014
 */
public class DriveSystem extends RobotDrive{

    public DriveSystem(SpeedController frontLeft, SpeedController rearLeft, SpeedController frontRight, SpeedController rearRight) {
        super(frontLeft, rearLeft, frontRight, rearRight);
    }
    
    public DriveSystem(MotorGroup leftSide, MotorGroup rightSide) {
        super(leftSide, rightSide);
    }
    
    public void drive(double leftMag, double rightMag) {
        this.tankDrive(leftMag, rightMag);
    }
    
    public void setSafety(boolean enabled) {
        this.setSafetyEnabled(enabled);
    }
    
    public void stop() {
        this.stop();
        this.stopMotor();
    }
}

