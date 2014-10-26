package org.firstrobotics1923.event;

import org.firstrobotics1923.Components;

/**
 * Event that speeds up the shooter motors
 * 
 * @author Pavan Hegde
 * @version 1.0
 * @since Jan 26, 2014
 */
public class ShooterSpeedUpEvent extends Event {
    
    /**
     * Runs only once
     */
    public ShooterSpeedUpEvent() {
        super(true);
    }
    
    /**
     * Increases the Speed of the shooter wheels
     */
    public void event() {
        Components.shooterSystem.increaseSpeed();
    }
}
