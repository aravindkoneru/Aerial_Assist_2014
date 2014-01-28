package org.firstrobotics1923.event;

import org.firstrobotics1923.Components;

/**
 * Event that slows down the shooter speed
 * 
 * @author Pavan Hegde
 * @version 1.0
 * @since Jan 26, 2014
 */
public class ShooterSpeedDownEvent extends Event {
    
    /**
     * Runs only once
     */
    public ShooterSpeedDownEvent() {
        super(true);
    }
    
    /**
     * Decreases the Speed of the shooter wheels
     */
    public void event() {
        Components.shooterSystem.decreaseSpeed();
    }
}
