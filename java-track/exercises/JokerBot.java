
public class JokerBot extends Robot implements RobotBehavior {

	private String joke1="You have an unattractive aroma!";
	private String joke2="You're shirt doesn't match your pants!";
	private String joke3="If you were any shorter tall people would look down at you!";
	private String joke4="You look like lemonade!";
	private Robot target;

	public JokerBot(String name, int x, int y, int speed) {
		super(name, x, y, speed);
		this.target=null;
	}
	
	public void setTarget(Robot a)	{
		this.target=a;
	}


	@Override
	public void getInPosition() {
		this.setX(target.getX()-1);
		this.setY(target.getY());
	}

	@Override
	public void doNextMove() {
		System.out.println(this.getName()+"looks at "+target.getName()+" and says:");
		float z=(float)Math.random();
		if	(z<=.25)	{
			System.out.println(joke1);
		}
		else	if	(z<=.5)	{
			System.out.println(joke2);
		}
		else if	(z<=.75)	{
			System.out.println(joke3);
		}
		else		{
			System.out.println(joke4);
		}
		
	}
	
	

	public static void main(String[] args)	{
		AttackBot a=new AttackBot("Jim",3,4,4,"lazer blaster");
		JokerBot b=new JokerBot("Harry",36,7,3);
		b.setTarget(a);
		b.doNextMove();
		a.setTarget(b);
	}





}
