package javaapplication5;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

//import com.sun.media.sound.Toolkit;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws AWTException, UnsupportedFlavorException, IOException, InterruptedException {
		// TODO Auto-generated method stub
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
                
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		Rectangle screenRectangle = new Rectangle(0,180,screenSize.width,50);
		Robot robot;
		robot = new Robot();
		//robot.createScreenCapture(screenRectangle);
		while(true) {
		BufferedImage image = robot.createScreenCapture(screenRectangle);
                Integer r = 0;
                Integer g = 0;
                Integer b = 0;
                Integer count = 0;
                for(Integer i = 0; i < screenSize.width; i = i + 10){
                    count++;
                    Color rgb = new Color(image.getRGB(i, 25));
                    r = r + rgb.getRed();
                    g = g + rgb.getGreen();
                    b = b + rgb.getBlue();
                }
                
                r = r / count;
                g = g / count;
                b = b / count;
                
                count = 0;
		//System.out.println(rgb);
                
                Integer v = 1;
                        //sp.getOutputStream().write(v.byteValue());
                        //sp.getOutputStream().write(v);
                        sp.getOutputStream().write(v.byteValue());
                        sp.getOutputStream().flush();
                        Thread.sleep(1);
                        sp.getOutputStream().write(r.byteValue());
                        sp.getOutputStream().flush();
                        Thread.sleep(1);
                        sp.getOutputStream().write(g.byteValue());
                        sp.getOutputStream().flush();
                        Thread.sleep(1);
                        sp.getOutputStream().write(b.byteValue());
			sp.getOutputStream().flush();
			Thread.sleep(2);
		//System.out.println("HI");
		}
		
		//Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

		//Image image = (Image) t.getTransferData(null);
		
		//BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
		/*
		File file = new File("C:\\Users\\docan\\Desktop\\moin.png");
		ImageIO.write(image, "png", file);
		System.out.println("A screenshot is captured to: " + file.getPath());
		Graphics2D g2d = image.createGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		*/
	}

}
