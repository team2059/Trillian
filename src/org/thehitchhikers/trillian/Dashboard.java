/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author randy
 */
public class Dashboard {

    SmartDashboard dashboard;
    
    Dashboard()
    {
    }
    
    void ShowWheelSpeed(double speed)
    {
        SmartDashboard.putNumber("WheelSpeed", speed);
    }
    
    void ShowAngleVoltage(double voltage)
    {
        SmartDashboard.putNumber("AngleVoltage", voltage);
    }
    
    void ShowAngleMotor(double voltage)
    {
        SmartDashboard.putNumber("AngleMotor", voltage);
    }
    
}
