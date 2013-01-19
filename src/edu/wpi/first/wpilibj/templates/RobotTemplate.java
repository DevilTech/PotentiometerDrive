package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Victor;

public class RobotTemplate extends SimpleRobot{
    Victor vicky;
    final double halfmaxvolt =  3.3/2;
    final double deadspace = .05;
    Victor vlad;
    RobotDrive davd;
    Joystick stick;
    double aaron;
    DriverStation diego;
    public void robotInit(){
        vicky = new Victor(2);
        vlad = new Victor(3);
        davd = new RobotDrive(vicky, vlad);
        stick = new Joystick(1);
        diego = DriverStation.getInstance();
    }
    
    public void autonomous(){
        
    }

    public void operatorControl(){
        while(isEnabled()){
            if((stick.getY() != 0) && (potValueAdapter() != 0)){
                davd.arcadeDrive(stick.getY(), potValueAdapter());
            }
            else{
                davd.arcadeDrive(0, 0);
            }
        }
    }
    
    public double potValueAdapter(){
        aaron = diego.getAnalogIn(1);
        if(diego.getAnalogIn(1) >  halfmaxvolt + deadspace ||diego.getAnalogIn(1) < halfmaxvolt - deadspace){
             aaron =  aaron - halfmaxvolt;
             return aaron / halfmaxvolt;
        }
        else{
            return 0;
        }
        
    }
    
    public void test(){
            System.out.println("TEST MODE????");
            System.out.println("bewp");
    }
}
