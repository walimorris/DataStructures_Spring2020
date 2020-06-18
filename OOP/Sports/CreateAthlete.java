import java.util.*; 

public class CreateAthlete { 
    public static void main(String[] args) { 
	Athlete theKing = new Athlete("Kobe", "Bryant"); 
	System.out.println(theKing.getName()); 
        long salary = theKing.getSalary(); 
        int jersey = theKing.getNumber(); 
        System.out.print(theKing.getName() + " jersey: " + jersey); 
        System.out.println(" salary: " + salary);
        theKing.setNumber(8); 
        theKing.setSalary(135000000);
        long newSalary = theKing.getSalary(); 
        int newJersey = theKing.getNumber(); 	
        System.out.print(theKing.getName() + " jersey: " + newJersey);
        System.out.println(" salary: " + newSalary);	
    } 
}     
