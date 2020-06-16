import java.util.*; 

public class NumberBloom { 
    public static void main(String[] args) { 
	RationalNumber r = new RationalNumber(); // should produce 0
	System.out.println(r);
        RationalNumber r1 = new RationalNumber(12, -1); // should produce -12
        System.out.println(r1);
        RationalNumber r2 = new RationalNumber(7, 8); 
	int r2Numerator = r2.getNumerator(); 
	int r2Denominator = r2.getDenominator(); 
        System.out.print("Fraction: " + r2 + " has numerator = " + r2Numerator); 
        System.out.println(" denominator = " + r2Denominator); 	
    } 
} 
