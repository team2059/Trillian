package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.Talon;

public class DriveTrain{
  
  Trillian trillian;
  Talon Left1;
  Talon Left2;
  Talon Right1;
  Talon Right2;
  double LastLeftPower;
  double LastRightPower;
  double MaxStep;
  double responseThreshold;
  
  DriveTrain(Trillian thebot){
    trillian = thebot;
    Left1 = new Talon(1);
    Left2 = new Talon (3);
    Right1 = new Talon(2);
    Right2 = new Talon(4);
    MaxStep = 0.005;
    responseThreshold = 0.05;
  }
  
  void Drive(DrivePair pair){
     
    double left = pair.leftPower;
    double right = pair.rightPower;
    double diff = 0; 
     
    if (Math.abs(left) < responseThreshold)left = 0;
    else{
      if(left < LastLeftPower){
        diff = LastLeftPower - left;
        if(diff > MaxStep){
          left = LastLeftPower - MaxStep;    
        }
      }

      if(left > LastLeftPower){
        diff = LastLeftPower + left;
        if(diff < MaxStep){
          left = LastLeftPower + MaxStep;
        }
      }
    }

    if(Math.abs(right) < responseThreshold)right = 0;
    else{
      if(right < LastRightPower){
        diff = LastRightPower - right;
        if(diff > MaxStep){
          right = LastRightPower - MaxStep;
        }
      }

      if(right > LastRightPower){
        diff = LastRightPower + right;
        if(diff < MaxStep){
          right = LastRightPower + MaxStep;
        }
      }
    }
    
    LastLeftPower = left;
    LastRightPower = right;
    Left1.set(left);
    Right1.set(0-right);
    Right2.set(0-right);
    Left2.set(left);
  }
}