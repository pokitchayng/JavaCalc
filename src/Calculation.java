/**
 * Defines parameters for the Objects created by the CalculationFactory.
 * 
 * @author Chris Gray
 * Last modified 08/28/2017
 */
public interface Calculation {
	/**
	 * Sets the variables for the object needed for computation.
	 * 
	 * @param firstNum A double passed in from the calling method for the first operand.
	 * @param secondNum A double passed in from the calling method for the second operand.
	 */
	public void setVars(double firstNum, double secondNum);
	/**
	 * Overloads method setVars for unary operation.
	 * @param tempFirst A double passed in from the calling method for the first operand.
	 */
	default public void setVars(double tempFirst){
		System.out.println("Unary call for binary operation, not valid, will not set values.");
	}
	/**
	 * Gets only the result of the computation for this object.
	 * 
	 * @return the calculated value.
	 */
	public double getResult();
	/**
	 * Prints out the value of this object's variables and the appropriate operator for its type but not the result.
	 */
	public void showHist();
	
}
