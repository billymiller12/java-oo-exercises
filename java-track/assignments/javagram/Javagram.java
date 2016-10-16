package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		Picture picture = null;
		Scanner in = new Scanner(System.in);

		// prompt user for image to filter and validate input
		do {

			String imagePath = "path not set";

			// try to open the file
			try {

				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();

				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));

				picture = new Picture(imagePath);

			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}

		} while(picture == null);

		// TODO - prompt user for filter and validate input
		int filterValue=0;
		do	{
			try	{
				filterValue=displayFilterMenu(in);
			}	catch(IllegalArgumentException e)	{
				System.out.println("Value must correspond to a filter.");
			}
		}	while(filterValue==0);


		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 


		Filter filter = getFilter(filterValue);			

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();

		System.out.println("Image successfully filtered");
		int optionValue=0;
		do	{
			try	{
				optionValue=displayOptionMenu(in);
			}	catch(IllegalArgumentException e)	{
				System.out.println("Must enter a 1 or a 2.");
			}
		}	while(optionValue==0);

		if	(optionValue==1)	{
			int filterValue2=0;
			do	{
				try	{
					filterValue2=displayFilterMenu(in);
				}	catch(IllegalArgumentException e)	{
					System.out.println("Value must correspond to a filter.");
				}
			}	while(filterValue2==0);

			Filter filter2 = getFilter(filterValue2);			

			// filter and display image
			processed = filter2.process(processed);
			processed.show();

			System.out.println("Image successfully filtered");
		}

		// save image, if desired

		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();

		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original

		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	

		// close input scanner
		in.close();
	}



	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int a) {
		Filter f=null;
		// TODO - create some more filters, and add logic to return the appropriate one
		if	(a==1)	{
			f= new BlackAndWhite();
		}		
		if(a==2)	{
			f= new BlueFilter();
		}	
		if(a==3)	{
			f= new YellowFilter();
		}	
		if(a==4)	{
			f= new TwoTone();
		}	
		if(a==5)	{
			f= new ThreeTone();
		}	
		if(a==6)	{
			f= new Reverse();
		}	
		if(a==7)	{
			f= new Flip();
		}		
		if(a==8)	{
			f= new Negative();
		}	
		if(a==9)	{
			f= new Merrica();
		}	
		if(a==10)	{
			f= new Mirror();
		}	
		if(a==11)	{
			f= new Lighten();
		}
		if(a==12)	{
			f=new Darken();
		}
		return f;
	}

	private static int displayFilterMenu(Scanner intIn)	{
		int filterValue=0;
		System.out.println("Enter a value for the filter you want to apply:");
		System.out.println("1 for Black and White");
		System.out.println("2 for Blue");
		System.out.println("3 for Yellow");
		System.out.println("4 for Two Tone");
		System.out.println("5 for 3 tone");
		System.out.println("6 to Reverse");
		System.out.println("7 to Flip");
		System.out.println("8 for a Negative");
		System.out.println("9 for Merrica");
		System.out.println("10 for Mirror");
		System.out.println("11 to Lighten");
		System.out.println("12 to Darken");
		filterValue=intIn.nextInt();
		if	(filterValue<1||filterValue>12)	{
			throw new IllegalArgumentException();
		}
		return filterValue;

	}

	private static int displayOptionMenu(Scanner intIn)	{
		System.out.println("press 1 to apply another filter, press 2 for save options:");
		int optionValue= intIn.nextInt();
		if(optionValue!=1&&optionValue!=2)	{
			throw new IllegalArgumentException();
		}
		return optionValue;
	}

}