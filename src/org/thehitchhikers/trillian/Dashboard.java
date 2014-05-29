package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {

  SmartDashboard dashboard;
  
  Dashboard(){}
  
  void ShowWheelSpeed(double speed){
    SmartDashboard.putNumber("WheelSpeed", speed);
  }
  
  void ShowAngleVoltage(double voltage){
    SmartDashboard.putNumber("AngleVoltage", voltage);
  }
  
  void ShowAngleMotor(double voltage){
    SmartDashboard.putNumber("AngleMotor", voltage);
  }
}
