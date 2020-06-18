import java.util.*; 

public class CreateAthlete { 
    public static void main(String[] args) {
	// Creation of generic athlete using the Athlete class  
	Athlete theKing = new Athlete("Kobe", "Bryant"); 
        long salary = theKing.getSalary(); 
        int jersey = theKing.getNumber(); 
        System.out.print(theKing.getName() + " jersey = " + jersey); 
        System.out.println(" salary = " + salary);
        theKing.setNumber(8); 
        theKing.setSalary(135000000);
        long newSalary = theKing.getSalary(); 
        int newJersey = theKing.getNumber(); 	
        System.out.print(theKing.getName() + ": jersey = " + newJersey);
        System.out.println(" salary = $" + newSalary);

	// Creating MJ with BasketBall player class that extends athlete
	BasketBallPlayer MJ = new BasketBallPlayer("Michael", "Jordan", 500000000, 23, 62.1, 88.9);
        System.out.println(MJ.getName());
        long mjSalary = MJ.getSalary(); 
        int mjJersey = MJ.getNumber(); 
        System.out.print(MJ.getName() + ": " + "jersey = " + MJ.getNumber()); 
        System.out.println(" salary = $" + MJ.getSalary());
        System.out.println(MJ.printStats()); 	
    } 
}     
