package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Compressor;

public class Trillian extends SimpleRobot {
    
    DriverStick driverStick;
    ShooterStick shooterStick;
    DriveTrain driveTrain;
    Shooter shooter;
    Compressor compressor;
    boolean compressing;
    public Dashboard dashboard;
    
    public void autonomous(){}
    
    private double interp(double ll, double lr, double ul,
            double ur, double x, double y)
    {
        double midleft = ll + (ul - ll)*y;
        double midright = lr + (ur - lr)*y;
        return midleft + (midright - midleft) * x;
    }    
    
    public void operatorControl(){
        do{
            double forward = driverStick.getForward();
            double turn = driverStick.getTurn();
            double twist = driverStick.getTwist();

            //System.out.println("F = "+forward+", turn = "+turn+", twist = "+
                    //twist+", test = "+test);
            double left = forward;
            double right = forward;
            
            
            if (turn < 0)
            {
                if (forward > 0)
                {
                    right = interp(1,0,1,1,turn+1,forward);
                    left = interp(-1,0,0,1, turn + 1, forward);
                }
                else
                {
                    right = interp(-1, -1, 1, 0, turn + 1, forward + 1);
                    left = interp(0, -1, -1, 0, turn + 1, forward + 1);
                }
            }
            else
            {
                if (forward > 0)
                {
                    right = interp(0, -1, 1, 0, turn,forward);
                    left = interp(0, 1, 1, 1, turn, forward);
                }
                else
                {
                    right = interp(-1, 0, 0, -1,turn,forward+1);
                    left = interp(-1, -1, 0, 1, turn, forward+1);
                }
            }
            
            // driveTrain.Drive(left,right);
            
             if (compressing && compressor.getPressureSwitchValue())
             {
                compressor.stop();
                compressing = false;
             }
             else if (!compressor.getPressureSwitchValue() && !compressing)
             {
                compressing = true;
                //compressor.start();
            }
            
            if (shooterStick.getTrigger())
            {
                shooter.ResetFrisbee();
            }
            else
            {
                shooter.PushFrisbee();
            }
            
            //System.out.println("wheel speed:" + driverStick.getWheelSpeed());
            shooter.SpinWheel(shooterStick.getWheelSpeed());
            
        }while(true);
    }
    public void robotInit() {
        //System.out.println("Robot Started");
        //autonomous();
        //operatorControl();
        dashboard = new Dashboard();
        driverStick = new DriverStick(this);
        shooterStick = new ShooterStick(this);
        driveTrain = new DriveTrain(this);
        shooter = new Shooter(this);
        compressor = new Compressor(1,4);
        compressor.enabled();
        compressing = false;
        shooter.PushFrisbee();
    }
}