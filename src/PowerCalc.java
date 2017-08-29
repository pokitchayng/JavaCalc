/**
 * Defines object for raised to a Power.
 *
 * @author Chris Gray
 * Last modified 08/28/2017
 */
public class PowerCalc implements Calculation {
	// declares variables unique to this object.
	protected double first = 0.0;
	protected double second = 0.0;
	@Override
	public void setVars(double firstNum, double secondNum) {
		first = firstNum;
		second = secondNum;
	}
	@Override
	public double getResult() {
		double total = Math.pow(this.first, this.second);
		return total;
	}
	@Override
	public void showHist() {
		System.out.print(this.first + " to the power of " + this.second + " = ");
	}
}