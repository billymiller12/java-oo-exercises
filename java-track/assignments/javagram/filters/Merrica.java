package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class Merrica implements Filter {
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

				int newRed,newGreen,newBlue;
			if	(r+g+b/3<90)	{
				newRed=255;
				newGreen=0;
				newBlue=0;
			}	else
				if	(r+g+b/3>230)	{
					newRed=255;
					newGreen=255;
					newBlue=255;
				}	else	{
					newRed=0;
					newGreen=0;
					newBlue=255;
				}


				processed.set(i, j, new Color(newRed, newGreen, newBlue));

			}
		}

		return processed;
	}
}
