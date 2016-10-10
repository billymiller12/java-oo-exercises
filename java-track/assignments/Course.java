import java.util.Arrays;

public class Course {
	private String name;
	Student[] roster;
	int remainingSeats, credits;

	public Course(String name, int credits, int remainingSeats)	{
		this.name=name;
		this.credits=credits;
		this.roster=new Student[remainingSeats];
		this.remainingSeats=remainingSeats;
	}


	public int getRemainingSeats() {
		return remainingSeats;
	}


	public void removeSeat() {
		this.remainingSeats = this.remainingSeats-1;
	}


	public String getName() {
		return name;
	}


	public Student[] getRoster() {
		return roster;
	}


	public int getCredits() {
		return credits;
	}

	public Boolean addStudent(Student a)	{
		Boolean success=false;
		if	(roster[0]==null)	{
			success=true;
			this.removeSeat();
			this.roster[0]=a;
			return success;
		}
		for	(int i=0;i<this.roster.length;i++)	{
			if (roster[i]!=null&&this.roster[i].getName()==a.getName())	{
				success=false;
			}
		}
		for	(int i=0;i<this.roster.length;i++)	{
			if	(roster[i]==null)	{	
				this.removeSeat();
				this.roster[i]=a;
				success=true;
				return success;
			}
		}
		return success;
	}
	
	public String generateRoster()	{
		String a="";
		int b=0;
		for	(int i=0;i<this.roster.length;i++)	{
			if (this.roster[i]!=null)	{
				b++;
			}
		}
		for	(int i=0;i<b;i++)	{
			a=a+""+this.roster[i].getName();
		}
		return a;
	}
	
	public double averageGPA()	{
		double a=0.0;
		int d=0;
		for	(int i=0;i<this.roster.length;i++)	{
			if	(this.roster[i]!=null)	{
				d++;
			}
		}
		for	(int i=0;i<d;i++)	{
			a=a+this.roster[i].getGPA();
		}
		return a/d;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", roster=" + Arrays.toString(roster) + ", remainingSeats=" + remainingSeats
				+ ", credits=" + credits + "]";
	}

	public static void main(String[] args)	{
		for (int i = 0; i < 100; i++) {
			double a =  (Math.random() * 5000);
			int s = (int)(Math.random() * 50);
			Course c = new Course("" + a, s, s);

			for (int j = 0; j < s; j++) {
				String aa =  "" + (Math.random() * 5000);
				String b =  "" + (Math.random() * 5000);
				int cc = (int)Math.random() * 500000;
				Student s2 = new Student(aa, b, cc);
				boolean added = c.addStudent(s2);
				System.out.println(added);
				System.out.println(s);
				System.out.println(c.getRemainingSeats());
			}
		}
	}

}
