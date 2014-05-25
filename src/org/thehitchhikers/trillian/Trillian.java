package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.SimpleRobot;

public class Trillian extends SimpleRobot {
    
    DriverStick driverStick;
    DriveTrain driveTrain;
    
    public void autonomous(){}
    
    public void operatorControl(){
        do{
            double forward = driverStick.getForward();
            double turn = driverStick.getTurn();
            double twist = driverStick.getTwist();
            double test = driverStick.getTest();
            //System.out.println("F = "+forward+", turn = "+turn+", twist = "+
                    //twist+", test = "+test);
            double left = forward;
            double right = forward;
            
            
            if (turn < 0){
                left = forward * (turn+1);                
            }
            if (turn >= 0){
                right = forward * (1-turn);
            }
            
            driveTrain.Drive(left,right);
           
            
        }while(true);
    }
    public void robotInit() {
        //System.out.println("Robot Started");
        //autonomous();
        //operatorControl();
        driverStick = new DriverStick();
        driveTrain = new DriveTrain();      
    }
}