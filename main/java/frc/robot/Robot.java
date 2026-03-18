// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.PersistMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private final RobotContainer m_robotContainer;

  double SPEED_MULTIPLIER = 1.0;
  double STEERING_MULTIPLIER = 1.0;


  // Set up sparkmax objects
  private final SparkMax frontLeftMotor =
      new SparkMax(Constants.Drive.FRONT_LEFT, MotorType.kBrushed);
  private final SparkMax backLeftMotor =
      new SparkMax(Constants.Drive.BACK_LEFT, MotorType.kBrushed);
  private final SparkMax frontRightMotor =
      new SparkMax(Constants.Drive.FRONT_RIGHT, MotorType.kBrushed);
  private final SparkMax backRightMotor =
      new SparkMax(Constants.Drive.BACK_RIGHT, MotorType.kBrushed);

  // Set up the drive system    
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
  private final XboxController controller = new XboxController(0);

  public Robot() {
    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotInit() {
    // Configure SparkMax Controllers
     SparkMaxConfig frontLeft_config = new SparkMaxConfig();
    frontLeft_config.inverted(true);

    SparkMaxConfig frontRight_config = new SparkMaxConfig();
    frontRight_config.inverted(true);

    SparkMaxConfig backLeft_config = new SparkMaxConfig();
    backLeft_config.follow(Constants.Drive.FRONT_LEFT);

    SparkMaxConfig backRight_config = new SparkMaxConfig();
    backRight_config.follow(Constants.Drive.FRONT_RIGHT);

    // Apply configuration to sparkmax controllers
    backLeftMotor.configure(backLeft_config, com.revrobotics.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    frontLeftMotor.configure(frontLeft_config, com.revrobotics.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
    frontRightMotor.configure(frontRight_config, com.revrobotics.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    backRightMotor.configure(backRight_config, com.revrobotics.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  // This function is activated during operator control
  @Override
  public void teleopPeriodic() {
    m_robotDrive.arcadeDrive(controller.getLeftY(), controller.getRightX() );
  }



  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
 