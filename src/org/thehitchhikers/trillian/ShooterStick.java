package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.Joystick;

public class ShooterStick{
  
  Joystick MyStick;
  Trillian trillian;
  
  public ShooterStick(Trillian thebot){
    trillian = thebot;
    MyStick = new Joystick(2);
  }
  
  void process(){
    if (getTrigger()){
      trillian.shooter.ResetFrisbee();
    }
    else{
      trillian.shooter.PushFrisbee();
    }

    //System.out.println("wheel speed:" + driverStick.getWheelSpeed());
    trillian.shooter.SpinWheel(getWheelSpeed());
  }
  
  public boolean getTrigger(){
    return MyStick.getTrigger();
  }
  
  public double getWheelSpeed(){
    return (MyStick.getRawAxis(4) - 1)/2;
  }
}
