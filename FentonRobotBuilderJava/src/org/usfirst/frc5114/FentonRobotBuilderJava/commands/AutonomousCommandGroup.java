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
    	Robot.autonSwitch.mode();
    	switch (Robot.autonSwitch.mode())
    	{
    		case 0:
    		{
    			// Drive South for 2s
    	    	DriveSouth ds = new DriveSouth();
    	    	ds.setDriveTime(1.0);
    	    	addSequential(ds);
    	    	System.out.println("auton step 1");
    	    	
    	    	// Stop for 0.25s
    	    	TimedDriveStop ts = new TimedDriveStop();
    	    	ts.setStopTime(0.25);
    	    	addSequential(ts);
    	    	System.out.println("auton step 2");
    	    	
    	    	// Drive North for 2s
    	    	DriveNorth dn = new DriveNorth();
    	    	dn.setDriveTime(1.0);
    	    	addSequential(dn);
    	    	System.out.println("auton step 3");
    			
    	    	break;
    		}
    		case 1:
    		{
    			//lift bin
    			//2.419s at 0.75
    			AutonLiftRear rl = new AutonLiftRear();
    			rl.setLiftTime(2.419);
    			addSequential(rl);
    			
    			//DiveEast for 2.951s
    			DriveEast de = new DriveEast();
    			de.setDriveTime(2.951);
    			addSequential(de);
    			
    			//DriveSouth 1.001s
    			DriveSouth ds = new DriveSouth();
    			ds.setDriveTime(1.001);
    			addSequential(ds);
    			
    			System.out.println("Case 1");
    		
    			break;
    		}
    		case 2:
    		{
    			// Other Auton Code * change all times
    			
    			// Pick Up Bin(rear lift)
    			AutonLiftRear lr = new AutonLiftRear();
    			lr.setLiftTime(1.0);
    			addSequential(lr);
    			
    			// Move Left
    			DriveWest dw = new DriveWest();
    			dw.setDriveTime(1.0);
    			addSequential(dw);
    			
    			// Push Tote
    			DriveNorth dn = new DriveNorth();
    			dn.setDriveTime(1.0);
    			addSequential(dn);
    			
    			System.out.println("Case 2");
    			
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
