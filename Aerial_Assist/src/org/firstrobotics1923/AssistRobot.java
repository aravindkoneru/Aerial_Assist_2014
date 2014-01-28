package org.firstrobotics1923;

import edu.wpi.first.wpilibj.IterativeRobot;
import org.firstrobotics1923.util.XboxController;
import org.firstrobotics1923.event.ShooterSpeedDownEvent;
import org.firstrobotics1923.event.ShooterSpeedUpEvent;
import org.firstrobotics1923.event.ShooterStartEvent;
import org.firstrobotics1923.event.ShooterStopEvent;

/**
 * The Core Code for FRC Team 1923's "Aerial Assist" Robot 
 * 
 * @author Pavan Hegde
 * @version 1.0
 * @since Jan. 26, 2014
 */
public class AssistRobot extends IterativeRobot{
    
    private XboxController xbc = Components.operatorControl;
    
    private boolean []justPressed = new boolean[14];       //Array to store Xbox button input
    private boolean []triggers = new boolean[2];           //Array to store Xbox Trigger input
    
    /**
     * Ensures that all systems are disabled
     */
    public void disabledInit() {
        Components.shooterSystem.stop();
        Components.shooterAngleSystem.stop();
        Components.robotDrive.stop();
        Components.intakeSystem.stop();
        EventBus.instance.clear();
    }
    
    public void disabledPeriodic() {
        //... ... ...
    }
    
    /**
     * Called once at the start of Auton
     */
    public void autonomousInit() {
        
    }
    
    /**
     * Called periodically in auton
     */
    public void autonomousPeriodic(){
        
    }
    
    /**
     * Initializes required things before teleop
     */
    public void teleopInit() {
       //Not'in' yet
    }
    
    /**
     * Al of the periodically called teleop-functions (eg. input)
     */
    public void teleopPeriodic() {
        { //Driving Scope
            Components.robotDrive.drive(Components.leftStick.getCoalescedY(), Components.rightStick.getCoalescedY());
        } //End Driving Scope
        
        {  //Shooter Scope
           if (xbc.getButton(XboxController.Button.Start) & !justPressed[XboxController.Button.Start.value]) {    //Start button turns on shooter
               EventBus.instance.push(new ShooterStartEvent());
               justPressed[XboxController.Button.Start.value] = true;
           } else {
               justPressed[XboxController.Button.Start.value] = false;
           }
           
           if (xbc.getButton(XboxController.Button.Back) & !justPressed[XboxController.Button.Back.value]) {     //Back Button stops the shooter
               EventBus.instance.push(new ShooterStopEvent());
               justPressed[XboxController.Button.Back.value] = false;
           } else {
               justPressed[XboxController.Button.Back.value] = false;
           }
           
           if (xbc.getButton(XboxController.Button.LB) & !justPressed[XboxController.Button.LB.value]) {         //Left Bumper Slows down the shooter
               EventBus.instance.push(new ShooterSpeedDownEvent());
               justPressed[XboxController.Button.LB.value] = true;
           } else {
               justPressed[XboxController.Button.LB.value] = false;
           }
           
           if (xbc.getButton(XboxController.Button.RB) & !justPressed[XboxController.Button.RB.value]) {         //Right Bumper speeds up the shooter
               EventBus.instance.push(new ShooterSpeedUpEvent());
               justPressed[XboxController.Button.RB.value] = true;
           } else {
               justPressed[XboxController.Button.RB.value] = false;
           }
        } //End Shooter Scope
        
        { //Event Bus Scope
            EventBus.instance.next();
            EventBus.instance.clean();
        }
    }
}
