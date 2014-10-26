package org.firstrobotics1923.system;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * A System to control the angle of the shooter
 * @author Kartik Vaidya, Prasanth Yedlapalli, Michelle Giang, Saikiran Nakka, Dhananjay Wadhwa, Nithin Suresh
 * @version 1.0
 * @since Jan 24, 2014
 */
public class ShooterAngleSystem extends PneumaticSystem{
 
    private final Solenoid angleControllerOne, angleControllerTwo;
    
    /**
     * Creates the ShooterAngleSystem and sets the two Solenoids
     * @param angleControllerOne
     *                          One of two solenoids that controls system
     * @param angleControllerTwo
     *                          One of two solenoids that controls system
     */
    public ShooterAngleSystem(Solenoid angleControllerOne, Solenoid angleControllerTwo){
        this.angleControllerOne = angleControllerOne;
        this.angleControllerTwo = angleControllerTwo;
    }
   
    /**
     * Raises shooter
     */
    public void activate() {
        this.angleControllerOne.set(false);
        this.angleControllerTwo.set(true);
    }

    /**
     * Lowers the shooter
     */
    public void deactivate() {
        this.angleControllerOne.set(true);
        this.angleControllerTwo.set(false);
    }
}
