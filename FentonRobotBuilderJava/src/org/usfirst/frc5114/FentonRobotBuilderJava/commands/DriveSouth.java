// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5114.FentonRobotBuilderJava.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc5114.FentonRobotBuilderJava.Robot;
import org.usfirst.frc5114.FentonRobotBuilderJava.subsystems.DriveTrain.Direction;

/**
 *
 */
public class  DriveSouth extends Command {
	Timer t = new Timer();
	double dt = 0.0;
	public void setTime (double driveTime)
	{
		dt = driveTime;
	}
	double spd = 0.0;
	public void setSpeed (double driveSpeed)
	{
		spd = driveSpeed;
	}

    public DriveSouth() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	t.reset();
    	t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveInDirection(Direction.SOUTH, spd);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (t.get() > dt)
    	{
    		t.stop();
        	return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.stop();
    }

}
