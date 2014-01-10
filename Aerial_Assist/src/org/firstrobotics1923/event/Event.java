package org.firstrobotics1923.event;

/**
 * An abstract robot event (runnable)
 * @author Pavan Hegde
 * @version 1.0
 * @since Jan. 9th, 2014
 */
public abstract class Event implements Runnable{
    private boolean run = false;                //Run or don't run
    private boolean ran = false;                //Has it run once yet?
    
    private final boolean runOnce;              //Run once? Or more
    
    /**
     * Creates an event that will only run once
     */
    protected Event() {
        this(false);
    }
    
    /**
     * Creates an event that may run once or more than once
     * @param oneIteration Whether or not to run the event multiple times
     */
    protected Event(boolean oneIteration){
        this.runOnce = oneIteration;
    }
    
    /**
     * Starts the Event
     */
    public void start() {
        this.run = true;
        new Thread().start();
    }
    
    public void run() {
        while(this.run) {
            if (this.runOnce && !this.ran) {
                this.event();
                this.ran = true;
            }else if (!this.runOnce) {
                this.event();
            }
        }
    }
    
    /**
     * Stops the event
     */
    public void stop() {
        this.run = false;
    }
    
    /**
     * Returns the current state of event (running vs. not)
     * @return whether the event is running or not
     */
    public boolean isRunning() {               
        return this.run;
    }
    
    /**
     * The Events Contents
     */
    protected abstract void event();
    
}
