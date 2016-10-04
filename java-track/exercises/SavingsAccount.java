
public class SavingsAccount {
private Integer balance;
private double intRate;


	public SavingsAccount(int balance, double intRate)	{
		this.balance=balance;
		this.intRate=intRate;
	}
	
	public Integer getBalance()	{
		return this.balance;
	}
	
	public double getIntRate()	{
		return this.intRate;
	}
	
	public void deposit(Integer deposit)	{
		this.balance+=deposit;
	}
	
	public void withdraw(Integer withdraw)	{
		this.balance-=withdraw;
	}
	
	public void accrueInt()	{
		this.balance+=(int)(this.balance*this.intRate);
	}
	
	public String toString()	{
		return "balance= "+this.balance+" interest rate= "+this.intRate;
	}
	
	public static void main(String[] args)	{
		SavingsAccount a=new SavingsAccount(100,.5);
		System.out.println(a.getBalance());
		a.accrueInt();
		System.out.println(a.getBalance());
		System.out.println(a);
	}
}
