package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author JKeeganPierce
 */
public class DriveTrain {
    
    Talon Left1;
    Talon Left2;
    Talon Right1;
    Talon Right2;
    double LastLeftPower;
    double LastRightPower;
    double MaxStep;
    
    DriveTrain(){
        Left1 = new Talon(1);
        Left2 = new Talon (3);
        Right1 = new Talon(2);
        Right2 = new Talon(4);
        MaxStep = 0.005;
    }
    
    void Drive(double left,double right){
       
        
       double diff; 
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
        
       
        
        LastLeftPower = left;
        LastRightPower = right;
        Left1.set(left);
        Right1.set(0-right);
        Right2.set(0-right);
        Left2.set(left);
    }
    
}
