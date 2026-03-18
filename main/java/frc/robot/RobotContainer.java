// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
private final XboxController controller = new XboxController(0);
private final IntakeSubsystem intake = new IntakeSubsystem();
private final ShooterSubsystem shooter = new ShooterSubsystem();


  
  public RobotContainer() {
    configureBindings();
        new JoystickButton(controller, XboxController.Button.kA.value)
        .whileTrue(new IntakeCommand(intake));
        new JoystickButton(controller, XboxController.Button.kY.value)
        .whileTrue(new ShootCommand(shooter));

    }  
      private void configureBindings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'configureBindings'");
      }
}
