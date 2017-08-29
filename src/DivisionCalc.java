/**
 * Defines Division object.
 * 
 * @author Chris Gray
 * Last modified 08/28/2017
 */
public class DivisionCalc implements Calculation {
	// declares variables unique to this object.
	protected double first = 0.0;
	protected double second = 0.0;
	@Override
	public void setVars(double firstNum, double secondNum) {
		first = firstNum;
		second = secondNum;
	}
	/**
	 * Gets only the result of the computation for this object. Validates that the divisor is not zero.
	 */
	@Override
	public double getResult() {
		if(this.second != 0.0) {
			double total = this.first / this.second;
			return total;
		} else {
			System.out.println("Cannot divide by zero returning 0.0");
			return 0.0;
		}
	}
	@Override
	public void showHist() {
		System.out.print(this.first + " / " + this.second + " = ");
	}
}
