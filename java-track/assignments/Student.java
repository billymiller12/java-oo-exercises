
public class Student {
	private String fName,lName;
	private int studentID, credits;
	private double gPA,gradePoints;
	

	public Student(String fName,String lName, int studentID)	{
		this.fName=fName;
		this.lName=lName;
		this.studentID=studentID;
		this.gPA=0.0;
		this.credits=0;
		this.gradePoints=0;
	}

	public String getName() {
		return fName +" "+lName;
	}

	public int getCredits() {
		return credits;
	}

	public double getGPA() {
		return gPA;
	}

	public int getStudentID() {
		return studentID;
	}
	
	public void addGradePoints(double gradePoints) {
		this.gradePoints = this.gradePoints+gradePoints;
	}
	
	public void addCredits(int credits)	{
		this.credits=this.credits+credits;
	}

	public void submitGrade(double gradePoints, int credits)	{
		this.addCredits(credits);
		this.addGradePoints(gradePoints*credits);
		this.gPA=(double)Math.round((this.gradePoints/this.credits*10000)/10000.0);
	}

	public String getClassStanding()	{
		if	(this.credits<30)	{
			return "Freshman";
		}	else
			if	(this.credits<60&&this.credits>=30)	{
				return "Sophomore";
			}	else
				if	(this.credits<90&&this.credits>=60)	{
					return "Junior";
				}	else	{
					return "Senior";
				}
	}
	
	

	public static void main(String[] args)	{
		Student a=new Student("Doug","Shook",111111);
		System.out.println(a.getName());
		System.out.println(a.getStudentID());
	}

	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", studentID=" + studentID + ", credits=" + credits
				+ ", gPA=" + gPA + "]";
	}


}
