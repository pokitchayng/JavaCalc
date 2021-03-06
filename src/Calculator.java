import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Handles input sanitizing, determines if special commands are made. Parent class to JavaCalc.
 * 
 * @author Chris Gray
 * Last modified 08/28/2017
 */
public class Calculator {
	protected static ArrayList<Calculation> history = new ArrayList<Calculation>(); // For object storage and retrieval.
	protected static String tempInput1 = ""; // Temporary input storage
	protected static String tempInput2 = ""; // Temporary input storage
	protected static String tempInput3 = ""; // Temporary input storage
	protected static String operator = "";
	protected static double firstNum = 0.0;
	protected static double secondNum = 0.0;
	protected static boolean userWantsToExit = false; // Controls program exit
	protected static String[] commands = new String[]{ "OFF", "P", "HIST", "HELP", "PI" };
	/**
	 * Method to display greeting with basic instructions at launch.
	 */
	public static void WelcomeMessage() {
		System.out.println("\nWelcome to the JavaCalc, the lightweight calculator for command line use. Type 'help' for help or 'off' to exit.\n");
	}
	/**
	 * Handles input validation and logic for first number.
	 * 
	 * @param input Scanner instance passed from JavaCalc.
	 * @return Value for valid number entered as first operand.
	 */
	protected static double handleFirstInput(Scanner input) {
		
		firstNum = 0.0;
		boolean loopExit = false;
		do{
			
			System.out.print("Please enter a number, pi for PI, or use p for previous result: ");
			if(input.hasNextLine()) { // Verifies input is not empty.
				tempInput1 = input.nextLine().trim().toUpperCase();
				if(!Arrays.stream(commands).anyMatch(tempInput1::equals)) { // Verifies input does not use any of our special commands.
					try { // Attempts to parse the string to a double until successful
						firstNum = Double.parseDouble(tempInput1);
						loopExit = true; 
					} catch(NumberFormatException e) { // Alerts user if input is not valid.
						System.out.println("Not a valid entry.");
					}
				} else if(tempInput1.equalsIgnoreCase("P")) { // Checks for request of previous value.
					if(history.isEmpty()) { // Checks if history has a previous value.
						System.out.println("No previous result");
					} else {
						firstNum = history.get(history.size()-1).getResult(); // Sets first number equal to previous result.
						System.out.println("Using previous result: " + firstNum);
						loopExit = true;
					}
				} else if(tempInput1.equalsIgnoreCase("off")) { // Checks for request to exit.
					userWantsToExit = true;
					loopExit = true;
				} else if(tempInput1.equalsIgnoreCase("hist")) { // Checks for request of history.
					if(!history.isEmpty()) { // Checks if history has a previous value.
						getHistory(); // Calls getHistory from this class.	
					} else {
						System.out.println("No history is available.");
					}
				} else if(tempInput1.equalsIgnoreCase("help")) { // Checks for request of help.
					help(); // Calls help from this class.
				} else if(tempInput1.equalsIgnoreCase("pi")) { // Checks for request of pi.
					firstNum = Math.PI;
					System.out.println("Using PI: " + firstNum);
					loopExit = true;
				}
			}
		} while(loopExit == false);
		return firstNum; // Returns a double with the value for the first number.
	}
	/**
	 * Handles input validation and logic for operator.
	 * 
	 * @param input Scanner instance from JavaCalc.
	 * @return value for a valid operator.
	 */
	protected static String handleOperator(Scanner input) {
		operator = "";
		boolean loopExit = false;
		if(userWantsToExit == false) { // Skips section if a request to exit has already been made.
			do{
				System.out.println("Please enter an operator");
				System.out.print("Valid operators: +, -, *, /, ^, %, SQRT, LOG: ");
				if(input.hasNextLine()) { // Verifies input is not empty.
					tempInput2 = input.nextLine().trim();
					if(tempInput2.equals("+")) {
						operator = "ADDITION";
						loopExit = true;
					} else if(tempInput2.equals("-")) {
						operator = "SUBTRACTION";
						loopExit = true;
					} else if(tempInput2.equals("*")) {
						operator = "MULTIPLICATION";
						loopExit = true;
					} else if(tempInput2.equals("/")) {
						operator = "DIVISION";
						loopExit = true;
					} else if(tempInput2.equals("^")) {
						operator = "POWER";
						loopExit = true;
					} else if(tempInput2.trim().equals("%")) {
						operator = "MODULO";
						loopExit = true;
					} else if(tempInput2.equalsIgnoreCase("SQRT")) {
						operator = "SQRT";
						loopExit = true;
					} else if(tempInput2.equalsIgnoreCase("LOG")) {
						operator = "LOG";
						loopExit = true;
					} else if(tempInput2.equalsIgnoreCase("off")) { // Checks for special commands from here.
						userWantsToExit = true;
						loopExit = true;
					} else if(tempInput2.equalsIgnoreCase("hist")) {
						if(!history.isEmpty()) {
							getHistory();	
						} else {
							System.out.println("No history is available.");
						}
					} else if(tempInput2.equalsIgnoreCase("help")) {
						help();
					}
				}
			} while(loopExit == false);
		}
		return operator; // returns String with operator type.
	}
	/**
	 * Handles input validation and logic for second number.
	 * @param input Scanner instance from JavaCalc.
	 * @return value for valid number entered as second operand.
	 */
	protected static double handleSecondInput(Scanner input) {
		secondNum = 0.0;
		boolean loopExit = false;
		if(userWantsToExit == false) { // Skips section if a request to exit has been made.
			if(!tempInput2.equalsIgnoreCase("SQRT") && !tempInput2.equalsIgnoreCase("LOG")) { // Skips this section if unitary operation selected.
				do{
					System.out.print("Please enter a number, pi for PI, or use p for previous result:");
					if(input.hasNextLine()) {
						tempInput3 = input.nextLine().trim().toUpperCase();
						if(!Arrays.stream(commands).anyMatch(tempInput3::equals)) { // Verifies input does not use any of our special commands.
							try{ // Attempts to parse the string to a double until successful
								secondNum = Double.parseDouble(tempInput3);
								loopExit = true;
							} catch(NumberFormatException e) {
								System.out.println("Not a valid entry.");
							}
						}
						if(tempInput3.equalsIgnoreCase("P")) { // Checks for special commands from here.
							if(history.isEmpty()){
								System.out.println("No previous result.");
							} else {
								secondNum = history.get(history.size()-1).getResult();
								System.out.println("Using previous result: " + secondNum);
								loopExit = true;
							}
						} else if(tempInput3.equalsIgnoreCase("off")) {
							userWantsToExit = true;
							loopExit = true;
						} else if(tempInput3.equalsIgnoreCase("hist")) {
							if(!history.isEmpty()) {
								getHistory();	
							} else {
								System.out.println("No history is available.");
							}
						} else if(tempInput3.equalsIgnoreCase("help")) {
							help();
						} else if(tempInput3.equalsIgnoreCase("pi")) { // Checks for request of pi.
							secondNum = Math.PI;
							System.out.println("Using PI: " + secondNum);
							loopExit = true;
						} else if(secondNum == 0 && operator.equalsIgnoreCase("DIVISION")) { // Prevents divide by 0.
							System.out.println("Cannot divide by zero choose a new divisor.");
							loopExit = false;
						} 
					}
				} while(loopExit == false);
			} else {
				secondNum = 0.0;
			}
		}
		return secondNum; // Returns a double for the value of the second number.
	}
	/**
	 * Prints all previous calculations using the object's showHist call and getResult call.
	 */
	protected static void getHistory() {
		for (Calculation i : history) { // For Each loop iterating through all of ArrayList.
			i.showHist(); // Calls the object's showHist method. 
			System.out.println(i.getResult()); // Prints the value from the getResult method.
		}
	}
	/**
	 * Prints basic commands and general information.
	 */
	protected static void help() {
		System.out.println("Type 'help' for this infomration.\nType 'hist' to see all previous calculations"
				+ " from this session.\nType p at the first or second input to use previous calculation's result.\nSQRT operator is for square root."
				+ "\n^ operator is for raising the first number to the power of the second.\nThe % operator will return the remainder of "
				+ "the first number divided by the second.\nThe log operator will return the log(base e).\nType 'off' to exit JavaCalc.");
	}
	/**
	 * Prints closing message indicating program is terminating.
	 */
	protected static void goodBye() {
		System.out.print("Goodbye");
	}
}
