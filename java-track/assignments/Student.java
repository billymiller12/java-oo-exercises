
public class Student {
	private String fName,lName;
	private int studentID, credits;
	private double gPA,gradePoints,tuition;

	public Student(String fName,String lName, int studentID)	{
		this.fName=fName;
		this.lName=lName;
		this.studentID=studentID;
		this.gPA=0.0;
		this.credits=0;
		this.gradePoints=0;
	}
	
	public Student(Student a, Student b)	{
		this.fName=a.getName();
		this.lName=b.getName();
		this.gPA=(a.getGPA()+b.getGPA())/2;
		this.studentID=a.getStudentID()+b.getStudentID();
		if	(a.getCredits()>b.getCredits())	{
			this.credits=a.getCredits();
		}	else	{
			this.credits=b.getCredits();
		}
		this.gradePoints=this.gPA*this.credits;
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

	public void submitGrade(double gradePoints, int credits)	{
		this.credits+=credits;
		this.gradePoints+=gradePoints*credits;
		this.gPA=(Math.round(this.gradePoints/this.credits*1000.0)/1000.0);
	}

	public double computeTuition()	{	
		if	(this.credits%15==0)	{
			this.tuition=20000.00*(this.credits/15);
		}	else	
			if	(this.credits<15)	{
				this.tuition=this.credits*1333.33;
			}	else	{
				this.tuition=((this.credits%15)*1333.33)+((this.credits/15)*20000.00);
			}
		this.tuition=Math.round(this.tuition*1000.0)/1000.0;
		return tuition;
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
	
	public Student createLegacy(Student a,Student b)	{
		Student kid=new Student(a,b);
		return kid;
	}

	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", studentID=" + studentID + ", credits=" + credits
				+ ", gPA=" + gPA + "]";
	}

	public static void main(String[] args)	{
		Student s = new Student("D", "S", 1);
		for (int i = 0; i < 14; i++) {
			s.submitGrade(0, 1);
			System.out.println(s.credits+" credits:"+"test code= "+(i+1) * 1333.33 +"  My code= "+ s.computeTuition());
		}

		s.submitGrade(0, 1);
		System.out.println(s.credits+" credits:"+"test code= "+20000.0+"  My code= "+ s.computeTuition());

		for (int i = 0; i < 14; i++) {
			s.submitGrade(0, 1);
			System.out.println(s.credits+" credits:"+"test code= "+(1333.33 * (i+1) + 20000.0)+"  My code= "+ s.computeTuition());
		}
	}



}
