/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.fazecast.jSerialComm.*;
import java.nio.ByteBuffer;
/**
 *
 * @author docan
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        SerialPort sp = SerialPort.getCommPort("COM4");
		sp.setComPortParameters(9600, 8, 1, 0);
		sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
		
		if(sp.openPort()) {
			System.out.print(true);
		}
		else {
			System.out.print(false);
			return;
		}
		
		
			
		
                String lol = "255,255,255";
                while(true){
                    for(Integer i = 0; i < 255; ++i) {
                        lol = i.toString() + ",0,0";
                        Integer v = 1;
                        //sp.getOutputStream().write(v.byteValue());
                        //sp.getOutputStream().write(v);
                        sp.getOutputStream().write(v.byteValue());
                        sp.getOutputStream().flush();
                        Thread.sleep(1);
                        sp.getOutputStream().write(i.byteValue());
                        sp.getOutputStream().flush();
                        Thread.sleep(1);
                        sp.getOutputStream().write(i.byteValue());
                        sp.getOutputStream().flush();
                        Thread.sleep(1);
                        sp.getOutputStream().write(i.byteValue());
			sp.getOutputStream().flush();
			System.out.print(i+1000);
                        System.out.print(" ");
			Thread.sleep(2);
                    }
                    
                    for(Integer i = 255; i > 0; i = i-1) {
                        lol = i.toString() + ",0,0";
                        Integer v = 1;
                        //sp.getOutputStream().write(v.byteValue());
                        //sp.getOutputStream().write(v);
                        sp.getOutputStream().write(v.byteValue());
                        sp.getOutputStream().flush();
                        Thread.sleep(1);
                        sp.getOutputStream().write(i.byteValue());
                        sp.getOutputStream().flush();
                        Thread.sleep(1);
                        sp.getOutputStream().write(i.byteValue());
                        sp.getOutputStream().flush();
                        Thread.sleep(1);
                        sp.getOutputStream().write(i.byteValue());
			sp.getOutputStream().flush();
			System.out.print(i+1000);
                        System.out.print(" ");
			Thread.sleep(2);
                    }}
                /*
                    for(Integer i = 0; i < 255; ++i) {
                        lol = i.toString() + ",0,0";
                        sp.writeBytes(lol.getBytes(), lol.length());
			sp.getOutputStream().flush();
			System.out.print(lol);
                        System.out.print(" ");
			Thread.sleep(900);
                    }
                    for(Integer i = 0; i < 255; ++i) {
                        lol =  "0," + i.toString() + ",0";
                        sp.writeBytes(lol.getBytes(), lol.length());
			sp.getOutputStream().flush();
			System.out.print(lol);
                        System.out.print(" ");
			Thread.sleep(1000);
                    }
                    
                    for(Integer i = 0; i < 255; ++i) {
                        lol = "0,0," + i.toString() ;
                        sp.writeBytes(lol.getBytes(), lol.length());
			sp.getOutputStream().flush();
			System.out.print(lol);
                        System.out.print(" ");
			Thread.sleep(20);
                    }
                    
                    for(Integer i = 0; i < 255; ++i) {
                        lol = i.toString() + "," + i.toString() + "," + i.toString() ;
                        sp.writeBytes(lol.getBytes(), lol.length());
			sp.getOutputStream().flush();
			System.out.print(lol);
                        System.out.print(" ");
			Thread.sleep(20);
                    }*/
                
                
                /*String lol = "255,255,255";
		sp.writeBytes(lol.getBytes(), lol.length());
			sp.getOutputStream().flush();
			System.out.print(lol);
			Thread.sleep(1000);
                        
                String lol1 = "255,255,255";
		sp.writeBytes(lol1.getBytes(), lol1.length());
			sp.getOutputStream().flush();
			System.out.print(lol1);
			Thread.sleep(1000);
                        
                
		sp.writeBytes(lol.getBytes(), lol.length());
			sp.getOutputStream().flush();
			System.out.print(lol);
			Thread.sleep(1000);
                        
                
		sp.writeBytes(lol1.getBytes(), lol1.length());
			sp.getOutputStream().flush();
			System.out.print(lol1);
			Thread.sleep(1000);
                        
                String lol2 = "255,255,255";
		sp.writeBytes(lol2.getBytes(), lol2.length());
			sp.getOutputStream().flush();
			System.out.print(lol2);
			Thread.sleep(1000);  
                        
                String lol3 = "vier";
		sp.writeBytes(lol3.getBytes(), lol3.length());
			sp.getOutputStream().flush();
			System.out.print(lol3);
			Thread.sleep(1000);
                        */
		/*if(sp.closePort()) {
			System.out.print(true);
		}
		else {
			System.out.print(false);
		}*/
    }
    
}
