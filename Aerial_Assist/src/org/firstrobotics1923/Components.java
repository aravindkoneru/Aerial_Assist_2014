package org.firstrobotics1923;

import edu.wpi.first.wpilibj.Solenoid;
import org.firstrobotics1923.system.PneumaticSystem;

/**
 * All Robotic components used in the code compiled in one place
 * 
 * @author Pavan Hegde
 * @version 1.0
 * @since Jan. 13, 2014
 */
public class Components {
    /*Sample Component Init....... Solenoid*/
    public static final Solenoid testPneumaticOne = new Solenoid(1);
    public static final Solenoid testPneumaticTwo = new Solenoid(2);
    /*Sample System init.......... Pneumatic System*/
    public static final PneumaticSystem samplePneumaticSystem = new PneumaticSystem(testPneumaticOne, testPneumaticTwo);
   
}
