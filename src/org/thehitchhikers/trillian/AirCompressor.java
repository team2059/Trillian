/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.thehitchhikers.trillian;

import edu.wpi.first.wpilibj.Compressor;

/**
 *
 * @author randy
 */
public class AirCompressor {
    
    Compressor compressor;
    boolean compressing;

    AirCompressor()
    {
        System.out.println("Made Air compressor");
        compressor = new Compressor(1,4);
        System.out.println("Compressor");
        compressor.enabled();
        compressing = false;
    }
    
    void EnsurePressure()
    {
        if (compressing && compressor.getPressureSwitchValue())
        {
            compressor.stop();
            compressing = false;
        }
        else if (!compressor.getPressureSwitchValue() && !compressing)
        {
            compressing = true;
            compressor.start();
        }
    }
}
