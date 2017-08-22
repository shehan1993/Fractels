/*
R.M.S.D.Jayasindara
E13160
PROJECT - CO225
*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Draw{
	
	//setColor method set the color to the mapping point
	void setColor(BufferedImage image, int i, int j,int color){
		image.setRGB(i,j,color);
	}
	
	//drawJFrame method to create JFrame to hold the Specific fractal image
	void drawJFrame(BufferedImage image, int width, int height,String name){
		try{
			ImageIO.write(image,"png",new File(("Fractal.png")));
			JFrame jf = new JFrame(name);
			jf.setSize(width, height);
			jf.add(new JLabel(new ImageIcon("Fractal.png")));
			jf.setVisible(true);
		
		}catch(Exception e){
			System.out.println(e);
		}	
	}
	
	
}