
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.archadedrive;
public class Drivetrain extends Subsystem {
    // Put methods for controlling this subsystem here. Call these from Commands.
    @Override
    public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      // setDefaultCommand(new MySpecialCommand());
      setDefaultCommand(new archadedrive()); 
    }
    public void drive(double speed) {
      RobotMap.m_robotDrive.arcadeDrive(-speed*OI.m_stick.getY(), speed*OI.m_stick.getX());
    }
  }
  