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
    			// Auton #1, case 0
    			// Do Nothing
    			// OPEN AUTON
    			
    			// new AutonCommand(AutonCommand.RobotCommandType.DriveNorth, 0.5, 1.0, AutonCommand.CommandSyncType.Sequential, this);
    			
    			// Do normal Bin capture from right
    			  // Drive North at 60% for 0.5s
    			  // (Get room for arm)
    			  new AutonCommand("DN,0.6,0.5,S", this);
    			  
    			  // Lift bin arm at 100% for 1.5s
    			  new AutonCommand("BL,1.0,1.5,S", this);
    			  
    			  // Drive South at 60% for 1.35s
    			  // (Drive into position)
    			  new AutonCommand("DS,0.6,1.35,S", this);
    			  
    			  // Lift bin arm at 100% for 1.5s
    			  // (Lift bin)
    			  new AutonCommand("BL,1.0,1.5,S", this);
    			  
    			  // Drive North at 60% for 2.4s
    			  // (Take bin off step)
    			  new AutonCommand("DN,0.6,2.4,S", this);
    			
    			// Finish Clearing the totes (**UNTESTED VALUE**)
    			new AutonCommand("DN,0.6,1.2,S", this);
    			
    			// Drop Bin (**UNTESTED VALUE**)
    			new AutonCommand("BD,1.0,1.5,S", this);
    			
    			// Shit, How the Hell am I supposed to do this???
    			
    	    	break;
    		}
    		case 1:
    		{
    			// Auton #2, case:66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666630000000000000002222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222220000010111111111101101100110110110000000000000000000000000000000000000000114010100101001000110110111100101111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000se 1
    			// Take bin from center (our right)
    			System.out.println("case 4");
    			
    			// Drive North at 60% for 0.5s
    			// (Get room for arm)
    			new AutonCommand("DN,0.6,0.5,S", this);
    			
    			// Lift bin arm at 100% for 1.5s
    			new AutonCommand("BL,1.0,1.43,S", this);
    			
    			// Drive South at 60% for 1.35s
    			// (Drive into position)
    			new AutonCommand("DS,0.6,1.2,S", this);
    			
    			// Lift bin arm at 100% for 1.5s
    			// (Lift bin)
    			new AutonCommand("BL,1.0,1.5,S", this);
    			
    			// Drive North at 60% for 2.4s
    			// (Take bin off step)
    			new AutonCommand("DN,0.6,1.0,S", this);
    			
    			// Drop bin & Dive Away
    			// **New Stuff**
    			new AutonCommand("BD,1.0,2.4,P", this);
    			new AutonCommand("DN,0.6,1.5,P", this);
    			
    			System.out.println("Case 1");
    			
    			break;
    		}
    		case 2:
    		{
    			// Auton #3, case 2
    			// Move bin and tote into auton zone
    			// **NOT TESTED YET** (with these values) : Current Do Nothing Auton
    			// OPEN AUTON
    			
    			/*
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
    			*/
    			
    			System.out.println("Case 2");
    			
    			break;
    		}
    		case 3:
    		{
    			// Auton #4, case 3
    			// Steal bin when starting on scoring platform
    			// GOOD, used at state's
    			
    			// Lift bin arm at 100% for 1.5s
    			new AutonCommand("BL,1.0,1.43,S", this);
    			
    			// Drive South at 60% for 1.35s
    			// (Drive into position)
    			new AutonCommand("DS,0.6,1.5,S", this);
    			
    			// Lift bin arm at 100% for 1.5s
    			// (Lift bin)
    			new AutonCommand("BL,1.0,1.5,S", this);
    			
    			// Drive North at 60% for 2.4s
    			// (Take bin off step)
    			new AutonCommand("DN,0.6,2.4,S", this);
    			break;
    		}
    		case 4:
    		{
    			// Auton #5, case 4
    			// Lift Bin and get close to driver station
    			
    			// Lift rear at 75% for 3.8s
    			// (Lift bin)
    			new AutonCommand("RL,0.75,3.8,S", this);
    			
    			// Stop Rear Lift
    			new AutonCommand("RS,0.0,0.125,S", this);
    			
    			// Drive South 60% 1.001s
    			// (Drive towards driver station)
    			new AutonCommand("DS,0.6,1.001,S", this);
    			
    			// Stop drive train for 0.125s
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
