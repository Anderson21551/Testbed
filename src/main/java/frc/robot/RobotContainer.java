// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.Driveteleop;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */

public class RobotContainer {
  public DriveTrain drive; 
public Driveteleop driveteleop;
VictorSP leftRear,leftFront,rightRear,rightFront;
public OI oi;
public RobotContainer(){

  
  leftFront = new VictorSP(Robotmap.LEFT_FRONT_ID);
  leftRear = new VictorSP(Robotmap.LEFT_REAR_ID);
  rightFront = new VictorSP(Robotmap.RIGHT_FRONT_ID);
  rightRear = new VictorSP(Robotmap.RIGHT_REAR_ID);

  rightFront.setInverted(true);
  rightRear.setInverted(true);



  drive = new DriveTrain(leftFront,leftRear,rightFront,rightRear);
  //commands 
  
 driveteleop = new Driveteleop(drive, oi::getXboxLeftTrigger, oi::getXboxRightTrigger, oi::getXboxLeftX);

 //oi
  oi = new OI();

}


public DriveTrain getDrive() {
  return drive;
}
public void setDrive(DriveTrain drive) {
  this.drive = drive;
}
public Driveteleop getDriveteleop() {
  return driveteleop;
}
public void setDriveteleop(Driveteleop driveteleop) {
  this.driveteleop = driveteleop;
}
public VictorSP getLeftRear() {
  return leftRear;
}
public void setLeftRear(VictorSP leftRear) {
  this.leftRear = leftRear;
}
public VictorSP getLeftFront() {
  return leftFront;
}
public void setLeftFront(VictorSP leftFront) {
  this.leftFront = leftFront;
}
public VictorSP getRightRear() {
  return rightRear;
}
public void setRightRear(VictorSP rightRear) {
  this.rightRear = rightRear;
}
public VictorSP getRigthFront() {
  return rightFront;
}
public void setRigthFront(VictorSP rigthFront) {
  this.rightFront = rigthFront;
}




public Command GetAutonymousCommand(){
  return null;
}


}
  // The robot's subsystems and commands are defined here...
 