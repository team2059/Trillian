/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.thehitchhikers.trillian;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author randy
 */
public class ShooterStick {
    
    Joystick MyStick;
    Trillian trillian;
    
    public ShooterStick(Trillian thebot){
        trillian = thebot;
        MyStick = new Joystick(1);
    }
    
    public boolean getTrigger()
    {
        return MyStick.getTrigger();
    }
    
    public double getWheelSpeed()
    {
        
        return (MyStick.getRawAxis(4) - 1)/2;
    }

}
