/**
 * RationalNumber class represents a fraction with an integer numerator and denominator. 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 * @since 06/26/2020
 */ 

import java.util.*; 

/**
 * Each RationalNumber object should contain both a numerator and denominator 
 */ 
public class RationalNumber { 
    private int numerator; 
    private int denominator; 

    /**
     * @param numerator: integer  
     * @param denominator: integer
     * @throws IllegalArgumentException if denomintor is 0
     */ 
    public RationalNumber(int numerator, int denominator) { 
	if ( denominator == 0 ) { 
	    throw new IllegalArgumentException("Illegal denominator with value 0"); 
	} 
	this.numerator = numerator; 
	this.denominator = denominator; 
    } 

    /** 
     * Constructs a RationalNumber with numerator 0 and denominator 1
     */ 
    public RationalNumber() { 
	this(0, 1); 
    } 

    /**
     * @return numerator 
     */ 
    public int getNumerator() { 
	return this.numerator; 
    } 

    /**
     * @return denominator 
     */ 
    public int getDenominator() { 
	return this.denominator; 
    } 

    @Override 
    public String toString() {
	StringBuilder sb = new StringBuilder();
	/* In any case, if numerator is 0 : return 0 */ 
        if ( this.numerator == 0 ) { 
	    sb.append("0");
	    return sb.toString();  
	/* If numerator or denomintor is negative with a denominator of 1, return negative numerator */ 
	} else if ( this.numerator < 0 || this.denominator < 0 && this.denominator == -1 ||
			                                          this.denominator == 1 ) { 
	    sb.append("-");
	    sb.append(Integer.toString(this.numerator)); 
	    return sb.toString();  
	/* numerator and denomintor are positive, with a denominator of 1 return positive numerator */ 
	} else if ( this.denominator == 1 && this.numerator > 0 ) { 
            sb.append(Integer.toString(this.numerator)); 
	    return sb.toString(); 
	/* numerator is negative and denominator is negative return negative rational number */ 
	} else if ( this.numerator < 0 || this.denominator < 0 ) { 
	    sb.append("-"); 
	    sb.append(Integer.toString(Math.abs(this.numerator)));
	    sb.append("/");  
	    sb.append(Integer.toString(Math.abs(this.denominator)));
	    return sb.toString(); 
	} else { 
	    /* positive numerator and denominator returns positive rational number */
	    sb.append(Integer.toString(this.numerator));
	    sb.append("/");  
            sb.append(Integer.toString(this.denominator)); 
            return sb.toString(); 
	} 
    } 
}    
