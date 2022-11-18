
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.archadedrive;
public class Drivetrain extends Subsystem {
    // Put methods for controlling this subsystem here. Call these from Commands.
    WPI_TalonFX l1, l2, r1, r2; 
    MotorControllerGroup l, r;
    public Drivetrain() {
      l1 = new WPI_TalonFX(Constants.MOTOR_L1_ID);
      l2 = new WPI_TalonFX(Constants.MOTOR_L2_ID);
      r1 = new WPI_TalonFX(Constants.MOTOR_R1_ID);
      r2 = new WPI_TalonFX(Constants.MOTOR_R1_ID); 
      
      r1.setInverted(true);
      r2.setInverted(true);

      l2.follow(l1);
      r2.follow(r1);

      l = new MotorControllerGroup(l1, l2);
      r = new MotorControllerGroup(r1, r2);
      ddrive = new DifferentialDrive(l, r);
    }
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
  