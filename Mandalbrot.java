/*
R.M.S.D.Jayasindara
E13160
PROJECT - CO225
*/


import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;


public class Mandalbrot extends Draw {
    
	
    double r_Negitive = -1;
    double r_Positive = 1;
    double c_Negitive = -1;
    double c_Positive = 1;
    int maximum = 1000;
	
    int width;
    int height;
	
		//constructor for 0 arguments
		public Mandalbrot(int width, int height){
			this.width = width;
			this.height = height;
			
			try{
				this.complexPlane();
			}catch(Exception e){
				
			}
			
		}
		
		//Constructor for 4 arguments
		public Mandalbrot(int width, int height,double r_Negitive,double r_Positive,double c_Negitive, double c_Positive){
			this.width = width;
			this.height = height;
			this.r_Negitive = r_Negitive;
			this.r_Positive = r_Positive;
			this.c_Negitive = c_Negitive;
			this.c_Positive = c_Positive;
		
			
			try{
				this.complexPlane();
			}catch(Exception e){
				
			}
		}
		
		
		//Constructor for 5 arguments
		public Mandalbrot(int width, int height,double r_Negitive,double r_Positive,double c_Negitive, double c_Positive,int maximum){
			this.width = width;
			this.height = height;
			this.r_Negitive = r_Negitive;
			this.r_Positive = r_Positive;
			this.c_Negitive = c_Negitive;
			this.c_Positive = c_Positive;
			this.maximum = maximum;
			
			try{
				this.complexPlane();
			}catch(Exception e){
				
			}
		}
		
		void complexPlane(){

			BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        
			for (int i=0;i<height;i++){
				for (int j=0;j<width;j++){
                
					double real = (r_Positive-r_Negitive)*i/800 + r_Negitive; 
					double complex = (c_Negitive-c_Positive)*j/800 + c_Positive;
					
					double x=0, y=0;
					int iteration = 0;
								
					while (x*x + y*y <4 && iteration<maximum){
						double xNew = x*x-y*y+real; //real part of the Z
						double yNew = 2*x*y +complex; //imaginary part of the Z
						x = xNew;
						y = yNew;
						iteration++;
					
						
					}
					
					
					
					if (iteration<10) {
						setColor(image,i,j,Color.RED.getRGB()); //Inherited method from Draw class
					}else if(iteration<25) {
						setColor(image,i,j,Color.LIGHT_GRAY.getRGB()); //Inherited method from Draw class
					}else if(iteration<50){
						setColor(image,i,j,Color.orange.getRGB()); //Inherited method from Draw class
					}else if(iteration<100){
						setColor(image,i,j,Color.MAGENTA.getRGB()); //Inherited method from Draw class
					}else if(iteration<200){
						setColor(image,i,j,Color.cyan.getRGB());
					}else if(iteration<300){
						setColor(image,i,j,Color.LIGHT_GRAY.getRGB());
					}else if(iteration<400){
						setColor(image,i,j,Color.yellow.getRGB());
					}else if(iteration<500){
						setColor(image,i,j,Color.RED.getRGB());
					}else if(iteration<600){
						setColor(image,i,j,Color.PINK.getRGB());
					}else if(iteration<700){
						setColor(image,i,j,Color.RED.getRGB());
					}else if(iteration<800){
						setColor(image,i,j,Color.orange.getRGB());
					}else if(iteration<900){
						setColor(image,i,j,Color.black.getRGB());
					}else if(iteration<=950){
						setColor(image,i,j,Color.orange.getRGB());
					}else{
						setColor(image,i,j,Color.yellow.getRGB());
					}
					
				}
			}
			
			drawJFrame(image,800,800,"Mandalbrot Set"); //Inherited method from Draw class
		}
}
