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
import org.usfirst.frc5114.Helper.ElevatorHelper;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class BackElevator extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController rearElevatorController = RobotMap.backElevatorRearElevatorController;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public ElevatorHelper eh = new ElevatorHelper(RobotMap.backElevatorRearElevatorController,
			Robot.MaxElevatorSpeed, Robot.RampTimeInSeconds, Robot.CushyStopSteps, Robot.StopRampFactor);

	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drop()
    {
    	RobotMap.backElevatorRearElevatorController.set(-0.75);
    }
    
    public void lift()
    {
    	RobotMap.backElevatorRearElevatorController.set(0.75);
    }
    
    public void stop()
    {
    	RobotMap.backElevatorRearElevatorController.set(0);
    }    
}

