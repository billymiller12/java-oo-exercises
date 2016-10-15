package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class ThreeTone implements Filter {
public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          int newVal;
	          if	(r+g+b/3<85)	{
	        	  newVal=0;
	          }		else
	        	  if	(r+g+b/3<170)
	          {
	        	  newVal=128;
	          }	else	
	          {
	        	  newVal=255;
	          }
	         
	          
	          
	          
	          processed.set(i, j, new Color(newVal, newVal, newVal));
	    	  
	      }
	    }
		
		return processed;
	}
}
