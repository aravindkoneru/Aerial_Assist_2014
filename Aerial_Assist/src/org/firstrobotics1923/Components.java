package org.firstrobotics1923;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import org.firstrobotics1923.util.XboxController;
import org.firstrobotics1923.system.DriveSystem;
import org.firstrobotics1923.system.IntakeSystem;
import org.firstrobotics1923.system.ShooterAngleSystem;
import org.firstrobotics1923.system.ShooterSystem;
import org.firstrobotics1923.util.MotorGroup;
import org.firstrobotics1923.util.StickShift;

/**
 * All Robotic components used in the code compiled in one place
 * 
 * @author Pavan Hegde, Aryak Pande
 * @version 1.4
 * @since Jan. 13, 2014
 */
public class Components {
    /* Joysticks and Xbox controller */
    public static final StickShift leftStick = new StickShift(1);         // Left Joystick in port 1
    public static final StickShift rightStick = new StickShift(2);        //Right Joystick in port 2
    public static final XboxController operatorControl = new XboxController(3); //Xbox Controller in 3
    
    /* Pneumatic Component Init */
    public static final Solenoid intakeAngleControllerOne = new Solenoid(1); //TODO (Update)
    public static final Solenoid intakeAngleControllerTwo = new Solenoid(2);
    
    public static final Solenoid shooterAngleControllerOne = new Solenoid(1);//TODO (Update)
    public static final Solenoid shooterAngleControllerTwo = new Solenoid(2);
    
    /* Speed controllers */
    public static final Victor frontLeftDrive = new Victor(1);                         //TODO (Update)
    public static final Victor frontRightDrive = new Victor(2);                         //TODO (Update)
    public static final Victor rearLeftDrive = new Victor(3);                          //TODO (Update)
    public static final Victor rearRightDrive = new Victor(4);  
    
    public static final Victor shooterFrontLeft = new Victor(5);
    public static final Victor shooterBackLeft = new Victor(6);
    public static final Victor shooterFrontRight = new Victor(7);
    public static final Victor shooterBackRight = new Victor(8);
    
    public static final Victor intakeMotorController = new Victor(10);                         //TODO (Update)
    
    /* Motor Group Init */
    public static final MotorGroup driveLeftSide = new MotorGroup(frontLeftDrive, rearLeftDrive);
    public static final MotorGroup driveRightSide = new MotorGroup(frontRightDrive, rearRightDrive);
    
    public static final MotorGroup shooterFrontWheels = new MotorGroup(shooterFrontLeft, shooterFrontRight);
    public static final MotorGroup shooterBackWheels = new MotorGroup(shooterBackLeft, shooterBackRight);
    
    /* System Init */
    public static final IntakeSystem intakeSystem = new IntakeSystem(intakeAngleControllerOne,intakeAngleControllerTwo,intakeMotorController); 
    public static final DriveSystem robotDrive = new DriveSystem(driveLeftSide, driveRightSide);
    public static final ShooterAngleSystem shooterAngleSystem = new ShooterAngleSystem(shooterAngleControllerOne, shooterAngleControllerTwo);
    public static final ShooterSystem shooterSystem = new ShooterSystem(shooterBackWheels, shooterFrontWheels);
}
