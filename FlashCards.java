//Flash Cards v0.1 : main class.
//Code by Ethan MacDonald on  4/9/16
//Takes several terms and definitions and creates a flash-card came.
import java.util.*;
public class mainClass {

	//Method returns a random number
	public static int randomWithRange(int range){
		return (int) ((Math.random() * (range+1))-1);
	}
	
	public static void main(String[] args) {
		//Some default strings used in the program
		String start = "//TODO: descriptoin of game.";
		String firstPrompt = "How many card whould you like to make?";
		String termPrompt = "Enter term: ";
		String defPrompt = "Enter definition: ";
		String modePrompt = "Which would you like first? (term/def)";
		int runGame = 1;
		
		Scanner input = new Scanner(System.in);
		
		//Starts the program and gets the number of cards (array indexes) to be created. 
		System.out.println(start);
		System.out.println(firstPrompt);
		int numOfCards = input.nextInt();
		String[] terms = new String[numOfCards];
		String[] defs = new String[numOfCards];
		
		//Populates the arrays with terms and definitions from the user.
		System.out.println("(Careful, everything's case-sensitive)");
		for(int i=0; i<numOfCards; i++){
			System.out.print(termPrompt);
			terms[i] = input.next();
			System.out.print(defPrompt);
			defs[i] = input.next();	
		}
		
		//Asks if the term or definition should be displayed first.
		System.out.println(modePrompt);
		String mode = input.next();
		if(mode.equals("term") || mode.equals("terms") || mode.equals("Term") || mode.equals("Terms")){
			System.out.println("Term>Def selected.");
			//Main term>def game loop.
			do{
				//Gets a random number within range of the number of indexes.
				int indexNum = randomWithRange(numOfCards);
				//Gets the data that the user inputed into the index and prints it.
				String outputString = terms[indexNum];
				System.out.print(outputString + " : ");
				//Take the answer from the user
				String inputString = input.next();
				//Checks to see if the term and def array indexes match.
				String matchingString = defs[indexNum];
				if(inputString.equals(matchingString)){System.out.println("Correct!");
				} //Exits the program
				else if(inputString.equals("exit") || inputString.equals("quit")){runGame = 0; System.out.println("Thanks for playing!");}
				//Handles incorrect answers
				else {System.out.println("Incorrect! The correct answer was: "); System.out.println(matchingString);}
				
			}while(runGame == 1);	
		} else if(mode.equals("def") || mode.equals("defs") || mode.equals("Def") || mode.equals("Defs")){
			System.out.println("Def>Term selected.");
			//Main def>term game loop.
			do{
				//Gets a random number within range of the number of indexes.
				int indexNum = randomWithRange(numOfCards);
				//Gets the data that the user inputed into the index and prints it.
				String outputString = defs[indexNum];
				System.out.print(outputString + " : ");
				//Take the answer from the user
				String inputString = input.next();
				//Checks to see if the term and def array indexes match.
				String matchingString = terms[indexNum];
				if(inputString.equals(matchingString)){System.out.println("Correct!");
				} //Exits the program
				else if(inputString.equals("exit") || inputString.equals("quit")){runGame = 0; System.out.println("Thanks for playing!");}
				//Handles incorrect answers
				else {System.out.println("Incorrect! The correct answer was: "); System.out.println(matchingString);}
	
			}while(runGame == 1);	
		} else {System.out.println("SPOOKY SCARY ERROR CODE 23!"); System.out.println("(please use 'term' or 'def')");}
		//Uncomment for testing:
		//System.out.println(terms[0]);
		//System.out.println(defs[0]);
	}
}
