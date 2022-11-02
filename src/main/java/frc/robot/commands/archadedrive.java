
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class archadedrive extends Command {
    public archadedrive() {
      // Use requires() here to declare subsystem dependencies
      requires(Robot.drivetrain);
    }
  
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
      return;
    }
  
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
      Robot.drivetrain.drive(1);
    }
  
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
      return false;
    }
  
    // Called once after isFinished returns true
    @Override
    protected void end() {
    }
  
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
  }