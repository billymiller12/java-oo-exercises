package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class YellowFilter implements Filter {
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
	          
	          int newRed = (r + g + b) / 3;
	          int newGreen = (r + g + b) / 3;
	          int newBlue;
	          if	(newRed<=120) 
	          {
	        	  newBlue=0;
	          }      else 
	          if	(newRed<=260)
	          {
	        	  newBlue=120;
	          }		else
	          {
	        	  newBlue=240;
	          }
	          processed.set(i, j, new Color(newRed, newGreen, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}
}
