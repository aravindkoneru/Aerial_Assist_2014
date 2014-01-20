package org.firstrobotics1923;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import org.firstrobotics1923.system.DriveSystem;
import org.firstrobotics1923.system.PneumaticSystem;
import org.firstrobotics1923.util.MotorGroup;
import org.firstrobotics1923.util.StickShift;

/**
 * All Robotic components used in the code compiled in one place
 * 
 * @author Pavan Hegde
 * @version 1.3
 * @since Jan. 13, 2014
 */
public class Components {
    /* Joysticks */
    public static final StickShift leftStick = new StickShift(1);         // Left Joystick in port 1
    public static final StickShift rightStick = new StickShift(2);        //Right Joystick in port 2
    
    /* Pneumatic Component Init */
    public static final Solenoid testPneumaticOne = new Solenoid(1); //TODO (Update)
    public static final Solenoid testPneumaticTwo = new Solenoid(2);
    
    /* Speed controllers */
    public static final Victor frontLeftDrive = new Victor(1);                         //TODO (Update)
    public static final Victor rearLeftDrive = new Victor(2);                          //TODO (Update)
    public static final Victor frontRightDrive = new Victor(3);                         //TODO (Update)
    public static final Victor rearRightDrive = new Victor(4);                        //TODO (Update)
     
    /* Motor Group Init */
    public static final MotorGroup driveLeftSide = new MotorGroup(frontLeftDrive, rearLeftDrive);
    public static final MotorGroup driveRightSide = new MotorGroup(frontRightDrive, rearRightDrive);
    
    /* System Init */
    public static final PneumaticSystem samplePneumaticSystem = new PneumaticSystem(testPneumaticOne, testPneumaticTwo); //TODO (Update)
    
    public static final DriveSystem robotDrive = new DriveSystem(frontLeftDrive, rearLeftDrive, frontRightDrive, rearRightDrive);
    
    
}
