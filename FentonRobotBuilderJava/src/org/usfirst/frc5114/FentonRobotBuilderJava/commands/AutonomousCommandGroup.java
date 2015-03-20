package org.usfirst.frc5114.FentonRobotBuilderJava.commands;

import org.usfirst.frc5114.AutonCommand.AutonCommand;
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
    			new AutonCommand(AutonCommand.RobotCommandType.DriveNorth, 0.5, 1.0, AutonCommand.CommandSyncType.Sequential, this);
    			new AutonCommand("DN,0.5,1.0,S", this);
    			new AutonCommand("D0,0.0,.0125,S", this);
    			new AutonCommand("DS,0.5,1.0,S", this);
    			
    			
    			
    			// Test
    			
    			// Drive South for 2s
    	    	DriveSouth ds = new DriveSouth();
    	    	ds.setTime(1.0);
    	    	addSequential(ds);
    	    	System.out.println("auton step 1");
    	    	
    	    	// Stopdt for 0.25s
    	    	TimedDriveStop ts = new TimedDriveStop();
    	    	ts.setTime(0.25);
    	    	addSequential(ts);
    	    	System.out.println("auton step 2");
    	    	
    	    	// Drive North for 2s
    	    	DriveNorth dn = new DriveNorth();
    	    	dn.setTime(1.0);
    	    	addSequential(dn);
    	    	System.out.println("auton step 3");
    	    	
    	    	// Stopdt for 0.25s
    			addSequential(ts);
    			
    	    	break;
    		}
    		case 1:
    		{
    			// No Auton Points
    			
    			//lift bin
    			//2.419s at 0.75
    			AutonLiftRear rl = new AutonLiftRear();
    			rl.setTime(2.419);
    			addSequential(rl);
    			
    			// Stop Rear Lift
    			TimedRearLiftStop rs = new TimedRearLiftStop();
    			rs.setTime(0.25);
    			addSequential(rs);
    			
    			// Stopdt for 0.25s
    	    	TimedDriveStop ts = new TimedDriveStop();
    	    	ts.setTime(0.25);
    	    	addSequential(ts);
    	    	System.out.println("auton step 2");
    			
    			//DiveEast for 2.951s
    			DriveEast de = new DriveEast();
    			de.setTime(2.951);
    			addSequential(de);
    			
    			// Stopdt for 0.25s
    	    	addSequential(ts);
    			
    			//DriveSouth 1.001s
    			DriveSouth ds = new DriveSouth();
    			ds.setTime(1.001);
    			addSequential(ds);
    			
    			// Stopdt for 0.25s
    			addSequential(ts);
    			
    			System.out.println("Case 1");
    			
    			break;
    		}
    		case 2:
    		{
    			// Move bin and tote into auton zone
    			
    			// Pick Up Bin(rear lift)
    			AutonLiftRear lr = new AutonLiftRear();
    			lr.setTime(1.25);
    			addSequential(lr);
    			
    			// Stop Rear Lift
    			TimedRearLiftStop rs = new TimedRearLiftStop();
    			rs.setTime(0.25);
    			addSequential(rs);
    			
    			// Stopdt for 0.25s
    	    	TimedDriveStop ts = new TimedDriveStop();
    	    	ts.setTime(0.25);
    	    	addSequential(ts);
    			
    			// Move Left
    			DriveWest dw = new DriveWest();
    			dw.setTime(2.175);
    			addSequential(dw);
    			
    			// Stopdt for 0.25s
    			addSequential(ts);
    			
    			// Push Tote
    			DriveSouth ds = new DriveSouth();
    			ds.setTime(4.0);
    			addSequential(ds);
    			
    			// Stopdt for 0.25s
    			addSequential(ts);
    			
    			System.out.println("Case 2");
    			
    			break;
    		}
    		case 3:
    		{
    			// Auton #4
    			
    			// South 7s
    			DriveSouth ds = new DriveSouth();
    			ds.setTime(7.0);
    			addSequential(ds);
    			
    			// Stopdt for 0.25s
    	    	TimedDriveStop ts = new TimedDriveStop();
    	    	ts.setTime(0.25);
    	    	addSequential(ts);
    	    	
    			break;
    		}
    		case 4:
    		{
    			// Auton #5
    			
    			// Lift rear for 1s
    			new AutonCommand("RL,0.75,1.0,S", this);
    			
    			// Stop Rear Lift
    			new AutonCommand("RS,0.0,0.125,S", this);
    			
    			// Drive south 60% 3.35s
    			new AutonCommand("DS,0.6,2.73,S", this);
    			
    			// Stopdt for 0.25s
    			new AutonCommand("RL,0.0,0.125,S", this);

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
