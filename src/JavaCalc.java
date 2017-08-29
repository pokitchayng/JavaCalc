
import java.util.Scanner;

/**
 * This is a basic command line calculator to handle most basic functions, and store a history.
 * 
 * @author Chris Gray
 * @version 1.0.0
 * Last modified 08/28/2017
 */

public class JavaCalc extends Calculator {
	/**
	 * Main Method - Handles exiting of program through protected variable inherited from Calculator class.
	 * Stores objects into ArrayList 'history' in Calculator class, also declares the Scanner object.
	 * 
	 * @param args string array passed in via command line options.
	 */
	public static void main(String[] args) {
		CalculationFactory CFac = new CalculationFactory();
		
		try(Scanner input = new Scanner(System.in)){ // Creates Scanner instance.
			WelcomeMessage(); // Called from Calculator class
			do { //will continue until turnMeOff is no longer 0.
				// temporary storage section controls flow order.
				double tempFirst = handleFirstInput(input); 
				String tempOperator = handleOperator(input);
				double tempSecond = handleSecondInput(input);
				
				if(userWantsToExit == false) {
					history.add(CFac.getCalculation(tempOperator)); // Creates object based on operator type, and adds to the ArrayList.
					if(operator.equalsIgnoreCase("SQRT") || operator.equalsIgnoreCase("LOG")){
						history.get(history.size()-1).setVars(tempFirst); // Sets the variable through the SQRT object's setVars method.
					} else {
						history.get(history.size()-1).setVars(tempFirst, tempSecond); // Sets the variables through the object's setVars method.
					}
					System.out.println("");
					history.get(history.size()-1).showHist();
					System.out.println(history.get(history.size()-1).getResult() + "\n"); // Prints results to the screen.	
				}
			} while(userWantsToExit == false); // Inherited class level variable from Calculator class.
			input.close(); // Closes Scanner instance.
			goodBye();
		} 
	}
	/**
	 * Prints closing comment, lets user know program is terminating.
	 */
	public static void goodBye() { // Method overridden from parent.
		System.out.println("\nThank you for using JavaCalc.");
	}
}