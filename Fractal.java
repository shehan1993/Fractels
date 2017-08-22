/*
R.M.S.D.Jayasindara
E13160
PROJECT - CO225
*/

public class Fractal{
	public static void main(String[] args) throws Exception {
		
		//width and height of the canvas
		int width = 800;
        int height = 800;
		
		//check the numendaler of arguments provide
		if((args[0].equals("Mandelbrot") && args.length==6) || (args[0].equals("Mandalbrot") && args.length==6) ){
			
			String setName = args[0];
			double rNegitive = Double.parseDouble(args[1]);
			double rPositive = Double.parseDouble(args[2]);
			double compleNeg = Double.parseDouble(args[3]);
			double complexNeg = Double.parseDouble(args[4]);
			int maximum = Integer.parseInt(args[5]);
			
			
			Mandalbrot mendal = new Mandalbrot(width,height,rNegitive,rPositive,compleNeg,complexNeg,maximum);
			
		}else if(args[0].equals("Julia") && args.length==4){
			
			String setName = args[0];
			double cReal = Double.parseDouble(args[1]);
			double cCmplx = Double.parseDouble(args[2]);
			int maximum = Integer.parseInt(args[3]);
			
			JuliaSet jullia = new JuliaSet(width,height,setName,cReal,cCmplx,maximum);
			
		}else if(args[0].equals("Mandelbrot") || args[0].equals("Mandalbrot") ){
			
			if(args.length==1){
				String setName = args[0];
				Mandalbrot mendal = new Mandalbrot(width,height);
			}else if(args.length==5){
				String setName = args[0];
				double rNegitive = Double.parseDouble(args[1]);
				double rPositive = Double.parseDouble(args[2]);
				double compleNeg = Double.parseDouble(args[3]);
				double complexNeg = Double.parseDouble(args[4]);
				
				Mandalbrot mendal = new Mandalbrot(width,height,rNegitive,rPositive,compleNeg,complexNeg);
				
			}
			
		}else if(args[0].equals("Julia")){
			
			if(args.length==1){
				String setName = args[0];
				JuliaSet jullia = new JuliaSet(width,height);
			}else if(args.length==3){
				String setName = args[0];
				double cReal = Double.parseDouble(args[1]);
				double cCmplx = Double.parseDouble(args[2]);
				JuliaSet jullia = new JuliaSet(width,height,cReal,cCmplx);
			}else{
				System.out.println("Wrong arguments");
			}
			
		}else{
			System.out.println("Wrong arguments");
		}
	}
	
}