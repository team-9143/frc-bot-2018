/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Joystickcontrol;
import frc.robot.subsystems.colorscensor;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI m_oi;
  public static Joystickcontrol joystickcontrol = new Joystickcontrol();
  private final Timer m_timer = new Timer();
 public static Drivetrain drivetrain = new Drivetrain();
 public static colorscensor colorScensor = new colorscensor();
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
      
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    ps3();//ps1, ps2, or ps3
  }
  public void ps1(){//directly in front, front of robot towards us
    if(m_timer.get() < 5.0){//place the robot closest to the targets
      //launch
    } else if (m_timer.get() < 8.2){
      RobotMap.m_robotDrive.arcadeDrive(-0.6, 0.0);
    } else {
      RobotMap.m_robotDrive.stopMotor();
    }
  }
  public void ps2(){//next closest(straight, left 90, shoot, back), 90 deg
    if (m_timer.get() < 6.0) {//place the robot furthest from the targets
      RobotMap.m_robotDrive.arcadeDrive(0.5, 0.0);
    } else if (m_timer.get() < 6.9) {
      RobotMap.m_robotDrive.arcadeDrive(0.0, -0.6);
    } else if (m_timer.get() < 11.0) {
      //launch
    } else if (m_timer.get() < 13.2) {
      RobotMap.m_robotDrive.arcadeDrive(-0.6, 0.0);
    } else {
      RobotMap.m_robotDrive.stopMotor();
    }
  }
  public void ps3(){//(straight more, left 90, shoot, back), 90 deg
    if (m_timer.get() < 5.7) {//place the robot closest to the targets
      RobotMap.m_robotDrive.arcadeDrive(0.6, 0.0);
    } else if (m_timer.get() < 6.6) {
      RobotMap.m_robotDrive.arcadeDrive(0.0, -0.6);
    } else if (m_timer.get() < 11) {
      //launch
    } else if (m_timer.get() < 13.6) {
      RobotMap.m_robotDrive.arcadeDrive(-0.6, 0.0);
    }
  }
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    RobotMap.m_robotDrive.arcadeDrive(-OI.m_stick.getY(), OI.m_stick.getX());
    if (OI.m_button2.get()) {
      RobotMap.m_wheel.set(-1.0);
    } else {
      RobotMap.m_wheel.set(0.0);
    }  
  }
}
