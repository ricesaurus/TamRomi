// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Forward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_db;
  //Hardcoding the distance into the Forward_14_Inches class
  private double distance;

  /**
   * 
   *
   * @param subsystem The subsystem used by this command.
   */
  public Forward(RomiDrivetrain db, double inches) {
    m_db = db;
    if (inches > 0){
      distance = inches;
    }
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
    //StraightLineWithPID from Robot Container, same as moving straight but PID adjusted
    m_db.straightLineWithPID();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_db.resetEncoders();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //Method getting average from left and right encoders, when it's greater than distance input it ends
    return m_db.getAverageDistanceInch() > distance;
  }
}
