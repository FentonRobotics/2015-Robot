// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5114.FentonRobotBuilderJava;

import org.usfirst.frc5114.FentonRobotBuilderJava.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick rightJoystick;
    public Joystick leftJoystick;
    public JoystickButton manipulatorButton7;
    public JoystickButton manipulatorButton1;
    public JoystickButton manipulatorButton8;
    public JoystickButton manipulatorButton3;
    public JoystickButton manipulatorButton2;
    public JoystickButton manipulatorButton4;
    public JoystickButton manipulatorButton9;
    public JoystickButton manipulatorButton5;
    public JoystickButton manipulatorButton6;
    public JoystickButton manipulatorButton10;
    public Joystick controller;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        controller = new Joystick(2);
        
        manipulatorButton10 = new JoystickButton(controller, 10);
        manipulatorButton10.whileHeld(new TestCommandGroup());
        manipulatorButton6 = new JoystickButton(controller, 6);
        manipulatorButton6.whenPressed(new DropBinArm());
        manipulatorButton5 = new JoystickButton(controller, 5);
        manipulatorButton5.whenPressed(new LiftBinArm());
        manipulatorButton9 = new JoystickButton(controller, 9);
        manipulatorButton9.whileHeld(new DriveSouth());
        manipulatorButton4 = new JoystickButton(controller, 4);
        manipulatorButton4.whenPressed(new DropRearElevator());
        manipulatorButton2 = new JoystickButton(controller, 2);
        manipulatorButton2.whenPressed(new LiftRearElevator());
        manipulatorButton3 = new JoystickButton(controller, 3);
        manipulatorButton3.whenPressed(new DropFrontElevator());
        manipulatorButton8 = new JoystickButton(controller, 8);
        manipulatorButton8.whenPressed(new StopEverythingGroup());
        manipulatorButton1 = new JoystickButton(controller, 1);
        manipulatorButton1.whenPressed(new LiftFrontElevator());
        manipulatorButton7 = new JoystickButton(controller, 7);
        manipulatorButton7.whileHeld(new DriveNorth());
        leftJoystick = new Joystick(1);
        
        rightJoystick = new Joystick(0);
        

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Drive With Joysticks", new DriveWithJoysticks());

        SmartDashboard.putData("Drive North", new DriveNorth());

        SmartDashboard.putData("Drive East", new DriveEast());

        SmartDashboard.putData("Drive South", new DriveSouth());

        SmartDashboard.putData("Drive West", new DriveWest());

        SmartDashboard.putData("StopDriveTrain", new StopDriveTrain());

        SmartDashboard.putData("LiftRearElevator", new LiftRearElevator());

        SmartDashboard.putData("StopLiftingRearElevator", new StopLiftingRearElevator());

        SmartDashboard.putData("DropRearElevator", new DropRearElevator());

        SmartDashboard.putData("LiftFrontElevator", new LiftFrontElevator());

        SmartDashboard.putData("DropFrontElevator", new DropFrontElevator());

        SmartDashboard.putData("StopFrontElevator", new StopFrontElevator());

        SmartDashboard.putData("Autonomous CommandGroup", new AutonomousCommandGroup());

        SmartDashboard.putData("LiftBinArm", new LiftBinArm());

        SmartDashboard.putData("DropBinArm", new DropBinArm());

        SmartDashboard.putData("StopEverythingGroup", new StopEverythingGroup());

        SmartDashboard.putData("StopBinArm", new StopBinArm());

        SmartDashboard.putData("TestCommandGroup", new TestCommandGroup());

        SmartDashboard.putData("AutonLiftRear", new AutonLiftRear());

        SmartDashboard.putData("TimedDriveStop", new TimedDriveStop());

        SmartDashboard.putData("AutonLiftFront", new AutonLiftFront());

        SmartDashboard.putData("TimedRearLiftStop", new TimedRearLiftStop());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getRightJoystick() {
        return rightJoystick;
    }

    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getController() {
        return controller;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

