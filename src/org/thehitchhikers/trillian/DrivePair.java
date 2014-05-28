/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.thehitchhikers.trillian;

/**
 *
 * @author randy
 */
public class DrivePair {
    
    double leftPower;
    double rightPower;
    
    DrivePair()
    {
        leftPower = 0;
        rightPower = 0;
    }
    
    DrivePair(double left, double right)
    {
        leftPower = left;
        rightPower = right;
    }
}
