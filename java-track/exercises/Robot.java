
public class Robot {
private String name;
private int x,y;
private int speed;
private int direction;//1=n,2=e,3=s,4=w

	
	public Robot(String name, int x, int y, int speed) {
	this.name = name;
	this.x = x;
	this.y = y;
	this.speed = speed;
	this.direction = 1;
}
	public String getName()	{
		return this.name;
	}
	
	public int getX()	{
		return this.x;
	}
	
	public int getY()	{
		return this.y;
	}
	
	public int getSpeed()	{
		return this.speed;
	}
	
	public String getDir()	{
		String dir="North";
		if (this.direction==2)	{
			dir="East";
		}
		if (this.direction==3)	{
			dir="South";
		}
		if (this.direction==4)	{
			dir="West";
		}
		return dir;		
	}
	
	public void move()	{
		if (this.direction==1)	{
			this.y=this.y+speed;
		}
		if	(this.direction==2)	{
			this.x=this.x+speed;
		}
		if (this.direction==3)	{
			this.y=this.y-speed;
		}
		if	(this.direction==4)	{
			this.x=this.x-speed;
		}
	}
	
	public void rotate()	{
		if	(this.direction<4)	{
			this.direction++;
		}	else	{
			this.direction=1;
		}
	}
	
	public double getDistance(Robot a)	{
		int x1=this.x; int y1=this.y;
		int x2=a.getX(); int y2=a.getY();
		double distance=Math.sqrt((double)(Math.pow(x2-x1, 2)) + (double)(Math.pow(y2-y1, 2)));
		return distance;
	}
	
	public String toString()	{
		return "name= "+this.name+", position= ("+x+", "+y+"), speed="+speed+", orientation= "+this.getDir();
	}
	

	public static void main(String[] args) {
		int a=(int)Math.round(Math.random()*100.0);
		int b=(int)Math.round(Math.random()*100.0);
		int c=(int)Math.round(Math.random()*100.0);
		int d=(int)Math.round(Math.random()*100.0);
		Robot jim=new Robot("Jim",0,0,c);
		Robot bob=new Robot("Bob", 2,2,d);
		System.out.println(jim.getDistance(bob));
		System.out.println(bob.getDistance(jim));
		for(int i=0;i<a;i++)	{
			bob.move();
			bob.rotate();
		}
	
		
		for(int i=0;i<b;i++)	{
			jim.move();
			jim.rotate();
		}
		System.out.println(jim.getDistance(bob));
		System.out.println(bob.getDistance(jim));
		System.out.println(jim);
		System.out.println(bob);
	}

}
