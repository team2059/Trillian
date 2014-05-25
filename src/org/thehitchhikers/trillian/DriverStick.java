/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.thehitchhikers.trillian;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author JKeeganPierce
 */
public class DriverStick {
    
    Joystick MyStick;
    
    public DriverStick(){
        MyStick = new Joystick(1);
        
    }
    
    public double getForward(){
        return -1*MyStick.getY();
        
    }
    public double getTurn(){
        return MyStick.getX();
        
    }
    public double getTwist(){
        return MyStick.getZ();
        
    }
    public double getTest(){
        return MyStick.getTwist();
        
    }
}
