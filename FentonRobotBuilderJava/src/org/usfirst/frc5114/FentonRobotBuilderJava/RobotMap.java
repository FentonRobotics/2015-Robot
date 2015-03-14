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
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.util.Vector;

import org.usfirst.frc5114.Helper.ElevatorHelper;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainLeftDriveController;
    public static SpeedController driveTrainRightDriveController;
    public static RobotDrive driveTrainRobotDrive21;
    public static SpeedController driveTrainSpeedController1;
    public static SpeedController driveTrainSpeedControllerUnhooked;
    public static RobotDrive driveTrainRobotDrive2Perpendicular;
    public static SpeedController frontElevatorFrontElevatorController;
    public static SpeedController backElevatorRearElevatorController;
    public static SpeedController binArmBinArmController;
    public static AnalogInput autonSwitchAnalogInput0;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftDriveController = new VictorSP(0);
        LiveWindow.addActuator("DriveTrain", "Left Drive Controller", (VictorSP) driveTrainLeftDriveController);
        
        driveTrainRightDriveController = new VictorSP(1);
        LiveWindow.addActuator("DriveTrain", "Right Drive Controller", (VictorSP) driveTrainRightDriveController);
        
        driveTrainRobotDrive21 = new RobotDrive(driveTrainLeftDriveController, driveTrainRightDriveController);
        
        driveTrainRobotDrive21.setSafetyEnabled(true);
        driveTrainRobotDrive21.setExpiration(0.1);
        driveTrainRobotDrive21.setSensitivity(0.5);
        driveTrainRobotDrive21.setMaxOutput(1.0);
        driveTrainRobotDrive21.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        driveTrainRobotDrive21.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);        

        driveTrainSpeedController1 = new VictorSP(2);
        LiveWindow.addActuator("DriveTrain", "Speed Controller 1", (VictorSP) driveTrainSpeedController1);
        
        driveTrainSpeedControllerUnhooked = new VictorSP(19);
        LiveWindow.addActuator("DriveTrain", "Speed Controller Unhooked", (VictorSP) driveTrainSpeedControllerUnhooked);
        
        driveTrainRobotDrive2Perpendicular = new RobotDrive(driveTrainSpeedController1, driveTrainSpeedControllerUnhooked);
        
        driveTrainRobotDrive2Perpendicular.setSafetyEnabled(true);
        driveTrainRobotDrive2Perpendicular.setExpiration(0.1);
        driveTrainRobotDrive2Perpendicular.setSensitivity(0.5);
        driveTrainRobotDrive2Perpendicular.setMaxOutput(1.0);
        

        frontElevatorFrontElevatorController = new VictorSP(3);
        LiveWindow.addActuator("Front Elevator", "FrontElevatorController", (VictorSP) frontElevatorFrontElevatorController);
        
        backElevatorRearElevatorController = new VictorSP(4);
        LiveWindow.addActuator("Back Elevator", "RearElevatorController", (VictorSP) backElevatorRearElevatorController);
        
        binArmBinArmController = new VictorSP(5);
        LiveWindow.addActuator("BinArm", "BinArmController", (VictorSP) binArmBinArmController);
        
        autonSwitchAnalogInput0 = new AnalogInput(0);
        LiveWindow.addSensor("AutonSwitch", "Analog Input 0", autonSwitchAnalogInput0);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
