
public class Rectangle {
	private int length;
	private int width;
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public int getWidth() {
		return width;
	}
	public int area()	{
		return this.length*this.width;
	}
	public int perimeter()	{
		return (this.length*2)+(this.width*2);
	}
	public Boolean isSquare()	{
		if	(this.length==this.width)	{
			return true;
		}	else	{
			return false;
		}
	}
	public String CompareSize(Rectangle a)	{
		if (this.area()>a.area())	{
			return "I am bigger!";
		}	else	{
			return "I am smaller :(";
		}
	}

}
