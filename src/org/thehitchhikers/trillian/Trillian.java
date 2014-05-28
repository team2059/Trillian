package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.SimpleRobot;

public class Trillian extends SimpleRobot {
    
    DriverStick driverStick;
    ShooterStick shooterStick;
    DriveTrain driveTrain;
    Shooter shooter;
    AirCompressor airCompressor;

    public Dashboard dashboard;
    
    public void autonomous(){}
    
    public void operatorControl(){
        do
        {            
            driverStick.process();
            shooterStick.process();
            airCompressor.EnsurePressure();
            
        }while(true);
    }
    public void robotInit() {
        dashboard = new Dashboard();
        driverStick = new DriverStick(this);
        shooterStick = new ShooterStick(this);
        driveTrain = new DriveTrain(this);
        shooter = new Shooter(this);
        System.out.println("About to make an air compressor");
        airCompressor = new AirCompressor();
        System.out.println("Made the air compressor");
    }
}