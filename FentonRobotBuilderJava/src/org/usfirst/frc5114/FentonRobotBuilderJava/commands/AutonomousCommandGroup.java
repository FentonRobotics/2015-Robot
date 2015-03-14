package org.usfirst.frc5114.FentonRobotBuilderJava.commands;

import org.usfirst.frc5114.FentonRobotBuilderJava.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommandGroup extends CommandGroup {
    
    public  AutonomousCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	switch (Robot.autonSwitch.mode())
    	{
    		case 1:
    		{
    	    	DriveSouth ds = new DriveSouth();
    	    	ds.setDriveTime(2.0);
    	    	addSequential(ds);
    	    	System.out.println("auton step 1");
    	    	
    	    	DriveNorth dn = new DriveNorth();
    	    	dn.setDriveTime(2.0);
    	    	addSequential(dn);
    	    	System.out.println("auton step 2");
    	    	break;
    		}
    		case 0:
    		{
    			//lift bin
    			//2.419s at 0.75
    			
    			//DiveEast
    			DriveEast de = new DriveEast();
    			de.setDriveTime(2.951);
    			addSequential(de);
    			
    			//DriveSouth
    			DriveSouth ds = new DriveSouth();
    			ds.setDriveTime(1.001);
    			addSequential(ds);
    		
    			break;
    		}
    		default:
    		{
    			System.out.println("Invalid Mode");
    			break;
    		}
    	}
    }
}
