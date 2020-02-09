/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.NeutralMode;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  SpeedControllerGroup m_left = new SpeedControllerGroup(new WPI_VictorSPX(0),new WPI_VictorSPX(1));
  SpeedControllerGroup m_right = new SpeedControllerGroup(new WPI_VictorSPX(4),new WPI_VictorSPX(5));
  DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
  Joystick m_joystick = new Joystick(0);
  XboxController controller = new XboxController(1);
  WPI_VictorSPX intake = new WPI_VictorSPX(6);
  WPI_VictorSPX feed = new WPI_VictorSPX(3);
  WPI_VictorSPX flywheel = new WPI_VictorSPX(2);
  
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    m_drive.curvatureDrive(-m_joystick.getY(),0.5*m_joystick.getZ(), m_joystick.getRawButton(1));
    if(m_joystick.getRawButton(2)){
      intake.set(ControlMode.PercentOutput,-1);}
    else{
      intake.set(ControlMode.PercentOutput,0);
    }
    if(m_joystick.getRawButton(3)){
      feed.set(ControlMode.PercentOutput,1);
      intake.set(ControlMode.PercentOutput,-1);}
    else if(m_joystick.getRawButton(4)){
      feed.set(ControlMode.PercentOutput,-0.5);
    }
    else{feed.set(ControlMode.PercentOutput,0);
    } 
      flywheel.set(ControlMode.PercentOutput,-0.5*(m_joystick.getRawAxis(3)+1));
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
