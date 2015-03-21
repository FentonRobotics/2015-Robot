/**
 * @author tomm
 *
 */


package org.usfirst.frc5114.AutonCommand;

import org.usfirst.frc5114.FentonRobotBuilderJava.commands.AutonLiftRear;
import org.usfirst.frc5114.FentonRobotBuilderJava.commands.AutonomousCommandGroup;
import org.usfirst.frc5114.FentonRobotBuilderJava.commands.DriveEast;
import org.usfirst.frc5114.FentonRobotBuilderJava.commands.DriveNorth;
import org.usfirst.frc5114.FentonRobotBuilderJava.commands.DriveSouth;
import org.usfirst.frc5114.FentonRobotBuilderJava.commands.DriveWest;
import org.usfirst.frc5114.FentonRobotBuilderJava.commands.TimedDriveStop;

import edu.wpi.first.wpilibj.command.Command;

public class AutonCommand
{
	public enum RobotCommandType { DriveNorth, DriveEast, DriveSouth, DriveWest, StopDriving,
		LiftFrontElevator, DropFrontElevator, StopFrontElevator,
		LiftRearElevator, DropRearElevator, StopRearElevator,
		LiftBinArm, DropBinArm, StopBinArm }
	
	public enum CommandSyncType { Sequential, Parallel };
	
	/**
	 * @param commandType Robot command to run
	 * @param speed Speed to run the motor during the command
	 * @param time How long to run the command
	 * @param syncType Run the command sequentially or in parallel with existing commands
	 * @param autonCommandGroup Command group to add the command to when it has been created
	 */
	public AutonCommand(RobotCommandType commandType, double speed, double time, CommandSyncType syncType, AutonomousCommandGroup autonCommandGroup)
	{
		Command genericCommand = null;
		switch (commandType)
		{
			case DriveNorth:
			{
				DriveNorth command = new DriveNorth();
				command.setSpeed(speed);
				command.setTime(time);
				genericCommand = command;
				break;
			}
			case DriveEast:
			{
				DriveEast command = new DriveEast();
				command.setSpeed(speed);
				command.setTime(time);
				genericCommand = command;
				break;
			}
			case DriveSouth:
			{
				DriveSouth command = new DriveSouth();
				command.setSpeed(speed);
				command.setTime(time);
				genericCommand = command;
				break;
			}
			case DriveWest:
			{
				DriveWest command = new DriveWest();
				command.setSpeed(speed);
				command.setTime(time);
				genericCommand = command;
				break;
			}
			case StopDriving:
			{
				TimedDriveStop command = new TimedDriveStop();				
				command.setTime(time);  // change method name for consistency
				genericCommand = command;
				break;
			}
			case DropBinArm:
				System.out.println("Command " + commandType + " not implemented yet."); break;
			case DropFrontElevator:
				System.out.println("Command " + commandType + " not implemented yet."); break;
			case DropRearElevator:
				System.out.println("Command " + commandType + " not implemented yet."); break;
			case LiftBinArm:
				System.out.println("Command " + commandType + " not implemented yet."); break;
			case LiftFrontElevator:
				System.out.println("Command " + commandType + " not implemented yet."); break;
			case LiftRearElevator:
			{
				AutonLiftRear command = new AutonLiftRear();
//				command.setSpeed(speed);
				command.setTime(time);
				genericCommand = command;
				break;
			}
			case StopBinArm:
				System.out.println("Command " + commandType + " not implemented yet."); break;
			case StopFrontElevator:
				System.out.println("Command " + commandType + " not implemented yet."); break;
			case StopRearElevator:
				System.out.println("Command " + commandType + " not implemented yet."); break;
			default:
				break;
		}

		// only add the command if we were able to figure out what it is and it is implemented
		if (genericCommand != null)
		{
			switch (syncType)
			{
				case Sequential: autonCommandGroup.addSequential(genericCommand); break;
				case Parallel: autonCommandGroup.addParallel(genericCommand); break;
			}
		}
	}
	
	/**
	 * @param autonCommandString Robot command string - possible commands are 
	 * DN - Drive North
	 * DE - Drive East
	 * DS - Drive South
	 * DW - Drive West
	 * D0 - Stop Driving
	 * FL - Lift Front Elevator
	 * FD - Drop Front Elevator
	 * FS - Stop Front Elevator
	 * RL - Lift Rear Elevator
	 * RD - Drop Rear Elevator
	 * RS - Stop Rear Elevator
	 * BL - Lift Bin Arm
	 * BD - Drop Bin Arm
	 * BS - Stop Bin Arm
	 */
	public AutonCommand(String autonCommandString, AutonomousCommandGroup autonCommandGroup)
	{
		System.out.println("Auton Command String: " + autonCommandString);
		try
		{
			RobotCommandType commandType = null;
			double speed;
			double time;
			CommandSyncType syncType = null;
			
			String[] commandList = autonCommandString.split(",");
			
			// figure out which possible command we are running
			switch (commandList[0].charAt(0))
			{
				// Drive
				case 'D':
				{
					switch (commandList[0].charAt(1))
					{
						case 'N': commandType = RobotCommandType.DriveNorth; break;
						case 'E': commandType = RobotCommandType.DriveEast; break;
						case 'S': commandType = RobotCommandType.DriveSouth; break;
						case 'W': commandType = RobotCommandType.DriveWest; break;
						case '0': commandType = RobotCommandType.StopDriving; break;
						default: System.out.println("Invalid robot drive command string."); break; 
					}
					break;
				}
				// Front elevator
				case 'F':
				{
					switch (commandList[0].charAt(1))
					{
						case 'L': commandType = RobotCommandType.LiftFrontElevator; break;
						case 'D': commandType = RobotCommandType.DropFrontElevator; break;
						case 'S': commandType = RobotCommandType.StopFrontElevator; break;
						default: System.out.println("Invalid robot front elevator command string."); break; 
					}
					break;
				}
				// Rear elevator
				case 'R':
				{
					System.out.println("Rear Elevator");
					switch (commandList[0].charAt(1))
					{
						case 'L': commandType = RobotCommandType.LiftRearElevator; System.out.println("Lift"); break;
						case 'D': commandType = RobotCommandType.DropRearElevator; System.out.println("Drop"); break;
						case 'S': commandType = RobotCommandType.StopRearElevator; System.out.println("Stop"); break;
						default: System.out.println("Invalid robot rear elevator command string."); break; 
					}
					break;
				}
				// Bin arm
				case 'B':
				{
					switch (commandList[0].charAt(1))
					{
						case 'L': commandType = RobotCommandType.LiftBinArm; break;
						case 'D': commandType = RobotCommandType.DropBinArm; break;
						case 'S': commandType = RobotCommandType.StopBinArm; break;
						default: System.out.println("Invalid robot bin arm command string."); break;
					}
					break;
				}
				default:
				{
					System.out.println("Invalid robot command string.");
				}
			}
			
			speed = Double.parseDouble(commandList[1]);
			System.out.println("Speed: " + speed);
			
			time = Double.parseDouble(commandList[2]);
			System.out.println("Time: " + time);
			
			switch (commandList[3].charAt(0))
			{
				case 'S': syncType = CommandSyncType.Sequential; System.out.println("Sequential"); break;
				case 'P': syncType = CommandSyncType.Parallel; System.out.println("Parallel"); break;
				default: System.out.println("Invalid robot command string - syncType.");
			}
			
			// call the other constructor
			new AutonCommand(commandType, speed, time, syncType, autonCommandGroup);
			
		}
		catch (Exception ex)
		{
			System.out.println("Exception occured processing robot command string, skipping command " + autonCommandString);
		}
	
	}
}
