package org.firstrobotics1923.event;

import org.firstrobotics1923.event.Event;
import org.firstrobotics1923.Components;

/**
 *
 * @author Christopher
 */
public class PistonDeactivatorEvent extends Event {

    public PistonDeactivatorEvent() {

        super(true);

    }

    public void event() {

        Components.samplePneumaticSystem.deactivate();

    }
}
