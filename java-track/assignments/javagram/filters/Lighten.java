package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class Lighten implements Filter {	public Picture process(Picture original) {

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
			if	(r<225)	{
				newRed=r+30;
			} else
			{
				newRed=r;
			}
			if	(g<225)	{
				newGreen=g+30;
			}	else	{
				newGreen=g;
			}
			if	(b<225)	{
				newBlue=b+30;
			}	else	{
				newBlue=b;
			}
			


			processed.set(i, j, new Color(newRed, newGreen, newBlue));

		}
	}

	return processed;
}
}
