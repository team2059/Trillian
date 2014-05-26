package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.Joystick;

public class DriverStick{
    
  Joystick MyStick;
  Trillian trillian;
    
  public DriverStick(Trillian thebot){
    trillian = thebot;
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
}