// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
//MADE XBOXCONTROLLER OBJECT IN ROBOT CONTAINER, but didn't import Xbox class here because of "never used" message
//ALSO ROMI DRIVE TRAIN IN ROBOTCONTAINER

public class DriveWithController extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_db;

  /**
   * 
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveWithController(RomiDrivetrain db) {
    m_db = db;
    addRequirements(db);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_db.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //First parameter gets left joystick Y values (1 to -1 )
    //Second parameter gets right joystick X values (1 to -1)
    //Made static accessible XboxController in Robot Container with default port 0 (Kevin showed)
    m_db.arcadeDrive(RobotContainer.m_xboxController.getLeftY(), RobotContainer.m_xboxController.getRightX());

    }
  
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}



