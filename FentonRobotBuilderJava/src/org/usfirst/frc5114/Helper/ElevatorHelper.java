package org.usfirst.frc5114.Helper;

import edu.wpi.first.wpilibj.*;

/**
 * Use the ElevatorHelper class by adding one instance of it to each Elevator Subsystem and make it do most of the work for you so you don't have to duplicate the effort for the 
 * front and rear elevators.
 * @author Tom McAnnally FRC Team 5114 Fenton Tigers
 * @version 1.0, March 2015
 * 
*/
public class ElevatorHelper
{
	private double maxElevatorSpeed = 0.75;
	private double rampTimeInSeconds = 0.125;
	
//	 public void setMaxSpeed (double maxSpeed)
//	{
//		maxElevatorSpeed = maxSpeed;
//	}
	/**
	 * How many steps do we want in our cushy stop ramp.
	 * The default value of 5 means that we will stop the motor in 5 equal steps
	 */
	private int cushyStopSteps = 5;
	
	/**
	 * How fast in relation to our motion ramp do we want the elevator to stop.
	 * The default value of 2.0 means that the elevator will stop 2 times faster than it starts
	 */
	private double stopRampFactor = 2.0;
	
	private SpeedController speedController = null;
	private Timer timer = new Timer();
	private boolean loggingEnabled = false;
	
	public enum Direction { UP, DOWN };
	
	/**
	 * Constructor, pass in the SpeedController that this LiftHelper will operate for you
	 * and stick with the default maximum elevator speed and ramp time
	 * 
	 * @param sc SpeedController
	 * @param MaxElevatorSpeed Maximum speed we want the elevator to travel.  The value can be in the range from 0.0 to 1.0.
	 * @param RampTimeInSeconds Amount of time we want to ramp up the motor speed. 
	 * @param CushyStopSteps How many steps it takes to stop the motor using the cushyStop method
	 * @param StopRampFactor How fast in relation to the motion ramp do we want to stop the elevator motor.  The default of 2.0 means it will stop twice as fast as it starts.
	 */
	public ElevatorHelper(SpeedController sc, double MaxElevatorSpeed, double RampTimeInSeconds, int CushyStopSteps, double StopRampFactor)
	{
		construct(sc, MaxElevatorSpeed, RampTimeInSeconds, CushyStopSteps, StopRampFactor);
	}

	/**
	 * Constructor, pass in the SpeedController that this LiftHelper will operate for you and stick with the default values
	 * 
	 * @param sc SpeedController
	 */
	public ElevatorHelper(SpeedController sc)
	{
		construct(sc, maxElevatorSpeed, rampTimeInSeconds, cushyStopSteps, stopRampFactor);
		speedController = sc;
	}
	
	/**
	 * Helper function for the ElevatorHelper constructors
	 * 
	 * @param sc SpeedController
	 * @param MaxElevatorSpeed Maximum speed we want the elevator to travel.  The value can be in the range from 0.0 to 1.0.
	 * @param RampTimeInSeconds Amount of time we want to ramp up the motor speed. 
	 */
	private void construct(SpeedController sc, double MaxElevatorSpeed, double RampTimeInSeconds, int CushyStopSteps, double StopRampFactor)
	{
		cushyStopSteps = CushyStopSteps;
		
		stopRampFactor = StopRampFactor;
		
		// cap speed at 1.0, the controller maximum
		maxElevatorSpeed = Math.max(0.0, Math.min(MaxElevatorSpeed, 1.0));
		
		// cap ramp time between .0001 and 1.0 seconds, don't allow 0 because it 
		// would cause our calculations to divide by zero
		rampTimeInSeconds = Math.max(0.0001, Math.min(RampTimeInSeconds, 1.0));
		
		speedController = sc;
		
		timer.reset();
	}
	
	/**
	 * Lift the elevator 
	 */
	public void lift()
	{
		move(Direction.UP);
	}
	
	/**
	 * Move the elevator in a particular direction.
	 * 
	 * @param direction Direction you want the elevator to travel.
	 */
	private void move(Direction direction)
	{
		// up is positive, down is negative
		double directionMultiplier = (direction == Direction.UP) ? 1.0 : -1.0;
		
		// figure out how much time has elapsed for our time based ramp
		double currentTime = timer.get();

		// calculate ramped speed based upon time
		double speed = directionMultiplier * Math.min(currentTime / rampTimeInSeconds, 1.0) * maxElevatorSpeed;
		
		if (loggingEnabled)
			System.out.println("Timer: " + String.format("%.3f", currentTime) + " Setting motor output to: " + String.format("%.3f", speed));		
				
		speedController.set(speed);
	}
	
	/**
	 * Stop the motor using a ramp instead of an abrupt stop.
	 */
	public void cushyStop()
	{
		// get the current speed, we will ramp down from here
		double speed = speedController.get();
		double delay = rampTimeInSeconds / stopRampFactor / cushyStopSteps;
		Direction direction = speed > 0 ? Direction.UP : Direction.DOWN;
		double speedDecrement = Math.abs(speed / cushyStopSteps);

		if (loggingEnabled)
		{
			System.out.println("Slowing from inital speed: " + String.format("%.3f", speed));
			System.out.println("Total delay before stop: " + String.format("%.3f", delay * cushyStopSteps));
		}

		// if the motor is already stopped, there is nothing to do
		if (speed != 0.0)
		{
			// whatever we are going to do, do it in cushyStopSteps steps over the rampTimeInSeconds / 2
			for (int i = 0; i < cushyStopSteps; i++)
			{
				if (direction == Direction.UP)
					speed -= speedDecrement;
				else
					speed += speedDecrement;
				
				if (loggingEnabled)
					System.out.println("Delay: " + String.format("%.3f", delay) + " Setting motor output to: " + String.format("%.3f", speed));
				
				speedController.set(speed);
				
				// wait for delay seconds before continuing
				Timer.delay(delay);
			}

			if (loggingEnabled)
				System.out.println("Setting motor output to: " + String.format("%.3f", 0.0));		
			
			// make sure we are all the way at 0.0 since there will be some rounding error in the speedDecrement calculation
			speedController.set(0.0);
		}
	}

	/**
	 * Drop the elevator
	 */
	public void drop()
	{
		move(Direction.DOWN);
	}

	/**
	 * Should be called when the event is being initialized.
	 */
	public void initialize()
	{
		System.out.println("Timer reset");
		// reset the timer so the ramp will work again
		timer.reset();
		timer.start();
	}

	/**
	 * Turn on debug logging, leave it off most of the time since logging might be expensive
	 */
	public void enableLogging()
	{
		loggingEnabled = true;
	}
	
	/**
	 * Turn off logging
	 */
	public void disableLogging()
	{
		loggingEnabled = false;
	}
	
}

