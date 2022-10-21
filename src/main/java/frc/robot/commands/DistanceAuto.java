// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DistanceAuto extends CommandBase {
  private double pos;
  private DriveTrain drive = new DriveTrain();
  /** Creates a new DistanceAuto. */
  public DistanceAuto(double pos) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.pos = pos;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(drive.getPos()<pos){
      drive.tankDrive(0.3, 0.3);
    }
    else{
      drive.tankDrive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  if(drive.getPos() >= pos){
    return true;
   }
   return false;
  }
}
