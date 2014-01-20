package org.firstrobotics1923.event;

import org.firstrobotics1923.event.Event;
import org.firstrobotics1923.Components;

/**
 * An event that retracts a piston
 * 
 * @author Chris Cushman, Aryak Pande, Kiran Chandra
 * @version 1.0
 * @since Jan. 14, 2014 
 **/
public class PistonDeactivatorEvent extends Event {

    public PistonDeactivatorEvent() {
        super(true); //Runs one time only
    }

    public void event() {
        //retracts piston
    }
}
