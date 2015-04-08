// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5114.FentonRobotBuilderJava.subsystems;

import org.usfirst.frc5114.FentonRobotBuilderJava.Robot;
import org.usfirst.frc5114.FentonRobotBuilderJava.RobotMap;
import org.usfirst.frc5114.FentonRobotBuilderJava.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftDriveController = RobotMap.driveTrainLeftDriveController;
    SpeedController rightDriveController = RobotMap.driveTrainRightDriveController;
    RobotDrive robotDrive21 = RobotMap.driveTrainRobotDrive21;
    SpeedController speedController1 = RobotMap.driveTrainSpeedController1;
    SpeedController speedControllerUnhooked = RobotMap.driveTrainSpeedControllerUnhooked;
    RobotDrive robotDrive2Perpendicular = RobotMap.driveTrainRobotDrive2Perpendicular;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public enum Direction { NORTH, EAST, SOUTH, WEST };
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoysticks());
    }
    
	 // Put methods for controlling this subsystem
	 // here. Call these from Commands.
    
     boolean allowPerpMvmt = false;
     boolean enableCreaperMode = false;
     
     // This function makes perpendicular drive only possible
     // when pressing button 2 on right joystick
	 public void changeToAllowPerpDrive (boolean allowPerpMovement)
	 {
		 allowPerpMvmt = allowPerpMovement;
	 }

	 // This makes it possible to drive the robot more slowly than usual.
	 public void enableCreeperMode (boolean enableCreaper)
	 {
		 enableCreaperMode = enableCreaper;
	 }
	 
	 public void takeJoystickInputs(Joystick left, Joystick right)
	 {
		 double inputScaleValue = 0.75;
		 
		 // if we are in creaper mode
		 if (enableCreaperMode)
			 inputScaleValue = 0.25;
		 
		// our robot is like 2 tank drive robots
		// with the right drive disabled on the second tank
		// so we pass in 0.0 for the right side
		robotDrive21.tankDrive(left.getY() * inputScaleValue, right.getY() * inputScaleValue, false);
		
		if (allowPerpMvmt)
		{
			robotDrive2Perpendicular.tankDrive(right.getX(), 0.0, false); // square the inputs
			robotDrive21.tankDrive(0.0, 0.0, false);
		}
		else
		{
			robotDrive2Perpendicular.tankDrive(0.0, 0.0, false); // square the inputs
		}
	 }
	
	 // This is basically a pass through to the tank drive which is already built for us
	 // but we don't want the perpendicular drive to run so we set it to 0.0
	 public void tankdriveonly(double outputMagnitude, double curve)
	 {
	 	// make sure that perpendicular drive is off
	 	robotDrive2Perpendicular.tankDrive(0.0, 0.0);
	
	 	// drive main tank drive
	 	robotDrive21.drive(outputMagnitude, curve);
	 }
	
	 public void stop()
	 {
	 	robotDrive21.tankDrive(0.0, 0.0);
	 	robotDrive2Perpendicular.tankDrive(0.0, 0.0);
	 }
	 
	 //robotDrive21(N/S) = 238in / 5s = 47.6in/s at 60%
	 //robotDrivePerpendicular(E/W) = 185in / 5s = 37in/s at 75%
	
	 public void driveInDirection(Direction direction, double speed)
	 {
	 	if (direction == Direction.NORTH)
	 	{
	 		robotDrive21.tankDrive(-1 * speed, -1 * speed);
	 		robotDrive2Perpendicular.tankDrive(0.0, 0.0);
	 		
	 	}
	 	else if (direction == Direction.SOUTH)
	 	{
	 		robotDrive21.tankDrive(speed, speed);
	 		robotDrive2Perpendicular.tankDrive(0.0, 0.0);
	 	}
	 	else if (direction == Direction.EAST)
	 	{
	 		// somehow we should rotate the bot until it is facing NORTH before we do this
	 		// otherwise it won't be going east, it will just be going to the right
	 		robotDrive2Perpendicular.tankDrive(speed, 0.0);
	 		robotDrive21.tankDrive(0.0, 0.0);
	 	}
	 	else if (direction == Direction.WEST)
	 	{
	 		// somehow we should rotate the bot until it is facing NORTH before we do this
	 		// otherwise it won't be going west, it will just be going to the left
	 		robotDrive2Perpendicular.tankDrive(-1 * speed, 0.0);
	 		robotDrive21.tankDrive(0.0, 0.0);
	 	}
	
	 	// keep driving a small amount of time before we exit this function 
	 	Timer.delay(0.004);
	 }

	 private double directionHelper(Direction direction)
	 {
	 	switch (direction)
	 	{
	 		case NORTH: return 0;
	 		case EAST: return 90;
	 		case SOUTH: return 180;
	 		case WEST: return 270;
	 	}
	 	// default to NORTH to avoid compiler warning
	 	return 0;
	 }    
    
    
}

