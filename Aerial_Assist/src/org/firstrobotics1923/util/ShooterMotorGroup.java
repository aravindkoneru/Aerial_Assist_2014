/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.firstrobotics1923.util;

import edu.wpi.first.wpilibj.SpeedController;
import java.util.Vector;

/**
 * A more specialized version of Motor Group that only works with the Shooter Motors
 * 
 * Virtually the same thing as motor group, but it has one motor turning in the opposite direction as the other
 * 
 * @author Pavan Hegde
 * @version 1.0
 * @since Feb 6, 2014
 */
public class ShooterMotorGroup implements SpeedController {
    private Vector motors;
    
    public ShooterMotorGroup(SpeedController rightSide, SpeedController leftSide) {
        if (rightSide != null) {
            motors.addElement(rightSide);
        }
        if (leftSide != null) {
            motors.addElement(leftSide);
        }
    }

     public void disable() {
        for (int i = 0; i < motors.size(); i++) {((SpeedController) motors.elementAt(i)).disable(); }
    }
    
    /**
     * Sets the speed of each motor in the MotorGroup
     * @param speed  the desired speed
     */
    public void set(double speed) {
        if (motors.elementAt(0) != null && motors.elementAt(1) != null) {
            ((SpeedController) motors.elementAt(0)).set(speed);
            ((SpeedController) motors.elementAt(1)).set(-speed);
        }
    }
    
    /**
     *  Sets the speed of each motor in the MotorGroup
     * @param speed the desired speed
     * @param syncGroup 
     */
    public void set(double speed, byte syncGroup) {
        if (motors.elementAt(0) != null && motors.elementAt(1) != null) {
            ((SpeedController) motors.elementAt(0)).set(speed, syncGroup);
            ((SpeedController) motors.elementAt(1)).set(-speed, syncGroup);
        }
    }
    
    /**
     * @return a double representing the SpeedController
     */
    public double get() {
      return ((SpeedController) motors.elementAt(0)).get();
    }
    
    /**
     * @param output ... ... No clue
     */
    public void pidWrite(double output) {
        for (int i = 0; i < this.motors.size(); i++) {
            ((SpeedController) (this.motors.elementAt(i))).pidWrite(output);
        }
    }
}
