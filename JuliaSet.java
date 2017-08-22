/*
R.M.S.D.Jayasindara
E13160
PROJECT - CO225
*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;

/*
* JuliaSet.java class map the Canvas points to the complex plane 
*/
public class JuliaSet extends Draw{
    
	String setName;
    double cReal = -0.4;
    double cComplex = 0.6;
	int maximum = 1000;
	int width;
    int height;
	
	//Constructor with 0 arguments
	public JuliaSet(int width,int height){
		this.width = width;
		this.height = height;
		
		try{
			this.complexPlane();
		}catch(Exception e){
			System.out.println(e);				
		}
	}
	
	
	//Constructor with 2 arguments
	public JuliaSet(int width,int height,double cReal, double cComplex){
		this.width = width;
		this.height = height;
		this.cReal = cReal;
		this.cComplex = cComplex;
		
		try{
			this.complexPlane();
		}catch(Exception e){
			System.out.println(e);	
		}
	}
	
		
	//Constructor with 3 arguments
	public JuliaSet(int width,int height,String setName, double cReal, double cComplex, int maximum){
		this.width = width;
		this.height = height;
		this.setName = setName;
		this.cReal = cReal;
		this.cComplex = cComplex;
		this.maximum = maximum;
		try{
			this.complexPlane();
		}catch(Exception e){
				System.out.println(e);
		}
	}
		
		
	void complexPlane(){
			
        BufferedImage image = new BufferedImage(this.width,this.height,BufferedImage.TYPE_INT_RGB);
	
       
        for (int i=0;i<width;i++){
            for (int j=0;j<height;j++){
				double real = (i-400)/400.0;  
				double complex = (400.0-j)/400.0; 
					
				double x = real; 
				double y = complex;
				int iteration = 0;
				while(x*x + y*y <4 && iteration < maximum){
					double xNew = x*x-y*y+cReal;  //real part of the Z
                    double yNew = 2*x*y +cComplex;  //imaginary part of the Z
                    x = xNew;
                    y = yNew;
                    iteration++;
					
				}
				
				
				//Set color by checking iteration number
					if (iteration<10) {
							setColor(image,i,j,Color.cyan.getRGB()); //Inherited method from Draw class
						}else if(iteration<25){
							setColor(image,i,j,Color.yellow.getRGB()); //Inherited method from Draw class
						}else if(iteration<100){
							setColor(image,i,j,Color.orange.getRGB());
						}else if(iteration<500){
							setColor(image,i,j,Color.black.getRGB());
						}else if(iteration<600){
							setColor(image,i,j,Color.LIGHT_GRAY.getRGB());
						}else{
							setColor(image,i,j,Color.MAGENTA.getRGB());
						}
				
				
			}
		}
		//Inherited method from Draw class
		drawJFrame(image,800,800,"Julia Set");
	}
}