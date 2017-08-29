/**
 * Defines Log object.
 * 
 * @author Chris Gray
 * Last modified 08/28/2017
 */
public class LogCalc implements Calculation {
	// declares variables unique to this object.
	protected double first = 0.0;
	protected double second = 0.0;
	@Override
	public void setVars(double firstNum, double secondNum) {
		first = firstNum;
		second = secondNum;
	}
	@Override
	public void setVars(double firstNum) {
		first = firstNum;
	}
	/**
	 * Gets only the result of the computation for this object. Ignores second number for unary operation.
	 */
	@Override
	public double getResult() {
		double total = Math.log(this.first);
		return total;
	}
	@Override
	public void showHist() {
		System.out.print("The Log of " + this.first + " = ");
	}	
}
