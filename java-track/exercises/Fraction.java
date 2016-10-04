
public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public Fraction add(Fraction other) {
		Integer newNum, newDen, common;

		newNum = other.getDenominator()*this.numerator + this.denominator*other.getNumerator();
		newDen = this.denominator * other.getDenominator();
		common = gcd(newNum,newDen);
		return new Fraction(newNum/common, newDen/common );
	}
	
	private Integer gcd(Integer m, Integer n) {
		while (m % n != 0) {
			Integer oldm = m;
			Integer oldn = n;
			m = oldn;
			n = oldm%oldn;
		}
		return n;
	}
	
	private Fraction recipricol(Fraction f)	{
		
		return new Fraction(f.getDenominator(),f.getNumerator());
	}
	
	



}
