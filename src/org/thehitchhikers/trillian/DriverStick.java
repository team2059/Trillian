package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.Joystick;

public class DriverStick {
  
  Joystick MyStick;
  Trillian trillian;
  static double triggerSpeed = 0.33;
  static double fullForward = 1;
  static double fullBackward = -1;
  static double zero = 0;
  DrivePair ul = new DrivePair(zero, fullForward);
  DrivePair midTop = new DrivePair(fullForward, fullForward);
  DrivePair ur = new DrivePair(fullForward, zero);
  DrivePair midLeft = new DrivePair(fullBackward, fullForward);
  DrivePair center = new DrivePair (zero, zero);
  DrivePair midRight = new DrivePair (fullForward, fullBackward);
  DrivePair ll = new DrivePair(zero, fullBackward);
  DrivePair midBottom = new DrivePair(fullBackward, fullBackward);
  DrivePair lr = new DrivePair(fullBackward, zero);
  
  DrivePair interpLeft = new DrivePair();
  DrivePair interpRight = new DrivePair();
  
  public DriverStick(Trillian thebot){
    trillian = thebot;
    MyStick = new Joystick(1);
    
  }

  private DrivePair interp(DrivePair ll, DrivePair lr, DrivePair ul,DrivePair ur, double x, double y){
    interpLeft.leftPower = ll.leftPower + (ul.leftPower - ll.leftPower)*y;
    interpLeft.rightPower = ll.rightPower + (ul.rightPower - ll.rightPower)*y;
    interpRight.leftPower = lr.leftPower + (ur.leftPower - lr.leftPower)*y;
    interpRight.rightPower = lr.rightPower + (ur.rightPower - lr.rightPower)*y;
    return new DrivePair(interpLeft.leftPower + (interpRight.leftPower - interpLeft.leftPower) * x,
      interpLeft.rightPower + (interpRight.rightPower - interpLeft.rightPower) * x);
  }
  
  void twistPair(DrivePair pair, double twist){
    double left = pair.leftPower + 1;
    double right = pair.rightPower + 1;
    if (twist < 0){
      left = left * (twist + 1);
      right = right + (2-right) * (0 - twist);
    }
    else{
      left = left + (2-left) * twist;
      right = right * (1-twist);
    }
    
    left = left - 1;
    right = right - 1;
    
    pair.leftPower = left;
    pair.rightPower = right;
  }
  
  DrivePair getDrivePair(){
    double forward = getForward();
    double turn = getTurn();
    double twist = getTwist();
    
    DrivePair pair = new DrivePair(forward, forward);
    
    if(turn < 0){
      if(forward > 0){
        pair = interp(midLeft,center,ul,midTop,turn+1,forward);
      }
      else{
        pair = interp(ll, midBottom,midLeft,center, turn + 1, forward + 1);
      }
    }
    else{
      if(forward > 0){
        pair = interp(center, midRight, midTop, ur, turn,forward);
      }
      else{
        pair = interp(midBottom, lr, center, midRight,turn,forward+1);
      }
    }
    twistPair(pair,twist);
    if(getTrigger()){
      pair.leftPower = pair.leftPower * triggerSpeed;
      pair.rightPower = pair.rightPower * triggerSpeed;
    }
    
    return pair;
  }
  
  void process(){
    trillian.driveTrain.Drive(getDrivePair());
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
  
  public boolean getTrigger()  {
    return MyStick.getTrigger();
  }
}
