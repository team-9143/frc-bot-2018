package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
//import frc.robot.commands.intake;
public class Joystickcontrol extends Subsystem {
    // Put methods for controlling this subsystem here. Call these from Commands.
    @Override
    public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      //setDefaultCommand(new intake()); 
    }
    public void wheel(double speed) {
      RobotMap.m_wheel.set(speed);
    }
    public void flywheel(double speed){
       RobotMap.m_flywheel.set(speed);
    }
  }
  