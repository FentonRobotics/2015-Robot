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
    			// new AutonCommand(AutonCommand.RobotCommandType.DriveNorth, 0.5, 1.0, AutonCommand.CommandSyncType.Sequential, this);
    			
    			// Test
    			
    	    	// Drive South for 1s at 60%
    	    	// new AutonCommand("DS,0.6,1.0,S", this);
    	    	
    			// Stop drive train for 0.125s
    			// new AutonCommand("D0,0.0,0.125,S", this);
    	    	
    	    	// Drive North for 1s at 60%
    	    	// new AutonCommand("DN,0.6,1.0,S", this);
    	    	
    			// Stop drive train for 0.125s
    			// new AutonCommand("D0,0.0,0.125,S", this);
    			
    			// Test Bin lift, stop, and drop
    			new AutonCommand("BL,1.0,1.0,S", this);
    			
    			new AutonCommand("BD,1.0,1.0,S", this);
    			
    			// Test front lift, stop, and drop
    			new AutonCommand("FL,0.75,1.0,S", this);
    			    			
    			new AutonCommand("FD,0.75,1.0,S", this);
    			
    			System.out.println("case 0");
    			
    			// Test rear lift, stop, and drop
    			new AutonCommand("RL,0.75,1.0,S", this);
    			
    			new AutonCommand("RD,0.75,1.0,S", this);
    			
    	    	break;
    		}
    		case 1:
    		{
    			// No Auton Points
    			System.out.println("case 4");
    			
    			//lift bin for 2.0s at 0.75
    			new AutonCommand("RL,0.75,2.0,S", this);
    			
    			// Stop Rear Lift for 0.125s
    			new AutonCommand("RS,0.0,0.125,S", this);
    			
    			// DiveEast for 2.951s at 75%
    			new AutonCommand("DE,0.75,2.951,S", this);
    			
    			// Stop drive train for 0.125s
    			new AutonCommand("D0,0.0,0.125,S", this);
    			
    			// DriveSouth for 1.001s at 60%
    			new AutonCommand("DS,0.6,1.001,S", this);
    			
    			// Stop drive train for 0.125s
    			new AutonCommand("D0,0.0,0.125,S", this);
    			
    			System.out.println("Case 1");
    			
    			break;
    		}
    		case 2:
    		{
    			// Move bin and tote into auton zone
    			
    			// Pick Up Bin(rear lift) for 1.25s at 75%
    			new AutonCommand("RL,0.75,1.25,S", this);
    			
    			// Stop Rear Lift for 0.125s
    			new AutonCommand("RS,0.0,0.125,S", this);
    			
    			// Stop drive train for 0.125s
    			new AutonCommand("D0,0.0,0.125,S", this);
    			
    			// Move west for 2.175s at 75%
    			new AutonCommand("DW,0.75,2.175,S", this);
    			
    			// Stop drive train for 0.125s
    			new AutonCommand("D0,0.0,0.125,S", this);
    			
    			// Push Tote for 4s at 60%
    			new AutonCommand("DS,0.6,4.0,S", this);
    			
    			// Stop drive train for 0.125s
    			new AutonCommand("D0,0.0,0.125,S", this);
    			
    			System.out.println("Case 2");
    			
    			break;
    		}
    		case 3:
    		{
    			// Auton #4
    			
    			// South 7s at 60%
    			new AutonCommand("DS,0.6,7.0,S", this);
    			
    			// Stop drive train for 0.125s
    	    	new AutonCommand("D0,0.0,0.125,S", this);
    	    	
    			break;
    		}
    		case 4:
    		{
    			// Auton #5, case 4
    			
    			// Lift rear for 1s
    			new AutonCommand("RL,0.75,4.0,S", this);
    			
    			// Stop Rear Lift
    			new AutonCommand("RS,0.0,0.125,S", this);
    			
    			/* // Drive south 60% 3.35s
    			new AutonCommand("DS,0.6,1.001,S", this);
    			
    			// Stop drive train for 0.125s
    			new AutonCommand("RL,0.0,0.125,S", this); */

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
