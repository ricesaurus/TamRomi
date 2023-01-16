// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Turn90_BButton extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_db;
//Hardcoding 90 degree turn angle
  private double angle = 90;
  

  /**
   * 
   *
   * @param subsystem The subsystem used by this command.
   */
  public Turn90_BButton(RomiDrivetrain db) {
    m_db = db;
    
    addRequirements(db);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_db.resetEncoders();
    m_db.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //turnRightWithPID from RomiDrivetrain file, PID adjusted 90 degrees
    if (RobotContainer.m_xboxController.getBButton()){
      m_db.turnRightWithPID();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //resetting gyro instead of encoders
    m_db.resetGyro();
    m_db.resetEncoders();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return (m_db.getGyroAngle() >= angle);
  }
}
