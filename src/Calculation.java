/**
 * Defines parameters for the Objects created by the CalculationFactory.
 * 
 * @author Chris Gray
 *
 */
public interface Calculation {
	/**
	 * Sets the variables for the object needed for computation.
	 * 
	 * @param firstNum
	 * @param secondNum
	 */
	public void setVars(double firstNum, double secondNum);
	/**
	 * Overloads method setVars for unitary operation.
	 * @param tempFirst
	 */
	default public void setVars(double tempFirst){
		System.out.println("Unitary call for binary operation, not valid, will not set values.");
	}
	/**
	 * Gets only the result of the computation for this object.
	 * 
	 * @return calculated value.
	 */
	public double getResult();
	/**
	 * Prints out the value of this object's variables and the appropriate operator for its type.
	 */
	public void showHist();
	
}
