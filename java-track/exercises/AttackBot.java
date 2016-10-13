
public class AttackBot extends Robot implements RobotBehavior {
	private String weapon;
	private Robot target;

	public AttackBot(String name, int x, int y, int speed, String weapon) {
		super(name, x, y, speed);
		this.weapon=weapon;
		this.target=null;
	}
	
	public void setTarget(Robot a)	{
		this.target=a;
	}

	@Override
	public void getInPosition() {
		this.setX(target.getX()+1);
		this.setY(target.getY());
	}
	
	public String getWeapon() {
		return weapon;
	}

	public void doNextMove(){
		System.out.println(this.getName() + " blasted "+target.getName()+" with it's "+this.weapon+"!!");
	}

}
