// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// __________    _____ _____________________________ __________ 
// \______   \  /  _  \\______   \__    ___/\_____  \\______   \
//  |       _/ /  /_\  \|     ___/ |    |    /   |   \|       _/
//  |    |   \/    |    \    |     |    |   /    |    \    |   \
//  |____|_  /\____|__  /____|     |____|   \_______  /____|_  /
//         \/         \/                            \/       \/ 

package frc.robot;

import java.sql.Driver;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.Drive;

public class RobotContainer {

  private final Drive drive = new Drive();

  // Movement Controls

  private final Joystick driver = new Joystick(0);

  // Left Trigger - Turn Right
  private final int leftTrigger = XboxController.Axis.kLeftTrigger.value;
  // Right Trigger - Turn Left
  private final int rightTrigger = XboxController.Axis.kRightTrigger.value;
  // Left Axis X - Move forward/backwards
  private final int forwardAxisY = XboxController.Axis.kLeftY.value;
  // B - Shooter
  private final JoystickButton shootButton = new JoystickButton(driver, XboxController.Button.kB.value);
  // A - Align
  private final JoystickButton alignButton = new JoystickButton(driver, XboxController.Button.kA.value);

  public RobotContainer() {
    configureBindings();
    drive.setDefaultCommand(
        new TeleopDrive(drive,
        () -> driver.getRawAxis(leftTrigger) - driver.getRawAxis(rightTrigger),
        () -> - driver.getRawAxis(forwardAxisY)));
        // () -> driver.getRawAxis(strafeAxisX)));
  }

  private void configureBindings() {
    // shootButton.whileTrue();
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
