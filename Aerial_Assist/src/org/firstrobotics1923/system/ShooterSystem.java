package org.firstrobotics1923.system;

import org.firstrobotics1923.util.DefaultConfig;
import org.firstrobotics1923.util.ShooterMotorGroup;

/**
 * The Shooter System
 * 
 * @author Kartik Vaidya, Pavan Hegde 
 * @version 1.4
 * @since Jan 26, 2014 
 *
 */
public class ShooterSystem implements System {

    private final ShooterMotorGroup frontWheels, backWheels;
    private double speed = DefaultConfig.SHOOTER_SPEED;
    private DoubleLookupTableEntry[] shooterSpeedLookup = null;
    private final int shooterSpeedLookupSize = 5;
    
    private class DoubleLookupTableEntry{
        private DoubleLookupTableEntry(){

        };
        
        public double key;
        public double value;
    };
    
    
    
    /**
     * Creates a ShooterSystem with A set of front and back wheels
     * @param backWheels
     *              The motor group made of the Victors controlling the back wheels
     * @param frontWheels 
     *              The motor group made of the Victors controlling the front wheels
     */
    public ShooterSystem(ShooterMotorGroup backWheels, ShooterMotorGroup frontWheels) {
       this.backWheels = backWheels;
       this.frontWheels = frontWheels;
       initShooterSpeedLookup();
    }
    
    private void initShooterSpeedLookup(){
        
        shooterSpeedLookup = new DoubleLookupTableEntry[shooterSpeedLookupSize];

        shooterSpeedLookup[0] = new DoubleLookupTableEntry();
        shooterSpeedLookup[0].key = 90;
        shooterSpeedLookup[0].value = 27;
        
        shooterSpeedLookup[1] = new DoubleLookupTableEntry();
        shooterSpeedLookup[1].key = 95;
        shooterSpeedLookup[1].value = 32;
        
        shooterSpeedLookup[2] = new DoubleLookupTableEntry();
        shooterSpeedLookup[2].key = 100;
        shooterSpeedLookup[2].value = 35;
        
        shooterSpeedLookup[3] = new DoubleLookupTableEntry();
        shooterSpeedLookup[3].key = 110;
        shooterSpeedLookup[3].value = 31;
        
        shooterSpeedLookup[4] = new DoubleLookupTableEntry();
        shooterSpeedLookup[4].key = 120;
        shooterSpeedLookup[4].value = 23;
    }
    
    private double getIdealSpeedFromDistance(double distance){
        for(int i = 0; i < shooterSpeedLookupSize; i++){
            if (shooterSpeedLookup[i].key == distance){
                //perfect match
                return shooterSpeedLookup[i].value;
            }
            else if(shooterSpeedLookup[i].key < distance){
                //upper bounds not found
                continue;
            }
            else if (shooterSpeedLookup[i].key > distance && i > 0) {
                //has value above and below, get weighted average
                double lowRatio = (distance - shooterSpeedLookup[i - 1].key) /
                        (shooterSpeedLookup[i].key - shooterSpeedLookup[i - 1].key);
                double highRatio = (shooterSpeedLookup[i].key - distance) /
                        (shooterSpeedLookup[i].key - shooterSpeedLookup[i - 1].key);

                return highRatio * shooterSpeedLookup[i-1].value + lowRatio * shooterSpeedLookup[i].value;
            }
            else if(shooterSpeedLookup[i].key > distance && i == 0){
                //distance is lower than min in lookup table
                return shooterSpeedLookup[0].value;
            }
        }
        //distance is higher than max in lookup table
       return shooterSpeedLookup[shooterSpeedLookupSize - 1].value;        
        
    };
    
    /**
    * Starts Motors at set speed 
    */
    public void activate() {
        frontWheels.set(speed);
        backWheels.set(speed);
    }
    
    /**
     * Increases the speed of the motors by a constant
     */
    public void increaseSpeed(){
        if(speed + DefaultConfig.SPEED_INCREMENT > 1.0){
            speed = 1.0;
        }else {
            speed += DefaultConfig.SPEED_INCREMENT;  
        }
    }
    
    /**
     * Decreases the speed of the motors by a constant
     */
    public void decreaseSpeed(){
        if(speed - DefaultConfig.SPEED_INCREMENT < 0.0){
            speed = 0.0;
        }else {
            speed -= DefaultConfig.SPEED_INCREMENT;
        }
    }
    
    /**
    * Stops the Motors on the shooter
    */
    public void stop() {
        frontWheels.disable();
        backWheels.disable();
    }
}
