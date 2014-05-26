/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.AnalogChannel;

/**
 *
 * @author randy
 */
public class Shooter {
    
    Solenoid outSol;
    Solenoid inSol;
    Talon shooterWheel;
    Talon angleWheel;
    Trillian trillian;
    AnalogChannel anglePot;
    boolean armed;
    
    Shooter(Trillian thebot)
    {
        trillian = thebot;
        outSol = new Solenoid(3);
        inSol = new Solenoid(4);
        shooterWheel = new Talon(5);
        angleWheel = new Talon(6);
        anglePot = new AnalogChannel(1);
        armed = false;
    }
    
    void PushFrisbee()
    {
        if (armed)
        {
            armed = false;
            double motorstep = 0.01;
            double voltage = 0;
            double potVol = anglePot.getVoltage();
            while( potVol < 3.1f  && (voltage < 1))
            {
                trillian.dashboard.ShowAngleVoltage(potVol);
                trillian.dashboard.ShowAngleMotor(voltage);
                angleWheel.set(voltage);
                potVol = anglePot.getVoltage();
                motorstep = (3.1f - potVol)/1000;
                voltage += motorstep;
            }
            inSol.set(false);
            outSol.set(true);
            trillian.dashboard.ShowAngleMotor(999);
            motorstep = 0.01;
            while(anglePot.getVoltage() > 0 && voltage > 0)
            {
                trillian.dashboard.ShowAngleVoltage(anglePot.getVoltage());
                trillian.dashboard.ShowAngleMotor(voltage);
                angleWheel.set(voltage);
                voltage -= motorstep;
            }
            trillian.dashboard.ShowAngleMotor(888);
        }
    }

    void ResetFrisbee()
    {
        outSol.set(false);
        inSol.set(true);
        armed = true;
    }
    
    void SpinWheel(double value)
    {
        trillian.dashboard.ShowWheelSpeed(value * -100);
        value = Math.max(-1,value);
        value = Math.min(1,value);
        shooterWheel.set(value);
    }
}
