package org.firstrobotics1923.system;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * System to control a Piston (sample, most likely to be changed)
 * 
 * @author Pavan Hegde
 * @version 1.0
 * @since Jan. 13, 2014
 */
public class PneumaticSystem implements System{
    private Solenoid controllerOne, controllerTwo;
    
    public PneumaticSystem(Solenoid controllerOne, Solenoid controllerTwo) {
        this.controllerOne = controllerOne;
        this.controllerTwo = controllerTwo;
    }
    
    public void activate() {               //Extends Piston
        controllerOne.set(false);
        controllerTwo.set(true);
    }
    
    public void deactivate() {             //Retracts Piston
        controllerOne.set(true);
        controllerTwo.set(false);
    }
    
    public void set(boolean on) {          //Sets system to on or not (activated vs. deactivated)
        if (on) {
            this.activate();
        }else {
            this.deactivate();
        }
    }
    
    public void stop() {
        this.set(false);
    }
}
