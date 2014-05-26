package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
    SmartDashboard dashboard;
    
    Dashboard(){}
    
    void ShowWheelSpeed(double speed){
      SmartDashboard.putDouble("WheelSpeed", speed);
    }
    
    void ShowAngleVoltage(double voltage){
      SmartDashboard.putDouble("AngleVoltage", voltage);
    }
    
    void ShowAngleMotor(double voltage){
      SmartDashboard.putDouble("AngleMotor", voltage);
    }
}
