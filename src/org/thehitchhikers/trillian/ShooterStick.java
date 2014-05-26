package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.Joystick;

public class ShooterStick{
    
  Joystick MyStick;
  Trillian trillian;
    
  public ShooterStick(Trillian thebot){
    trillian = thebot;
    MyStick = new Joystick(1);
  }
    
  public boolean getTrigger(){
    return MyStick.getTrigger();
  }
    
  public double getWheelSpeed() {
    return (MyStick.getRawAxis(4) - 1)/2;
  }
}
