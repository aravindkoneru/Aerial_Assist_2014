package org.firstrobotics1923.routines;

import org.firstrobotics1923.EventBus;

/**
 * A generic abstract routine
 * 
 * @author Pavan Hegde
 * @version 1.0
 * @since Feb 6, 2014
 */
public abstract class AutonomousRoutine {
    
    /**
     * Runs the Routine
     */
    public void run() {
        try{
            routine();
        } catch(InterruptedException e) {
            e.printStackTrace();
            EventBus.instance.clear();
            return;
        }
    }
    
    /**
     * The Custom Routine code
     * @throws InterruptedException when the routine takes too long, this will be thrown
     */
    protected abstract void routine() throws InterruptedException;
    
    /**
     * Kills the routine at the end of Auton
     */
    public void kill() {
        EventBus.instance.clear();
    }
}
