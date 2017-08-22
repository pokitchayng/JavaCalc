/**
 * Defines Square Root object.
 * 
 * @author Chris Gray
 *
 */
public class SQRTCalc implements Calculation {
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
	@Override
	public double getResult() { // Ignores second number so as to be able to do a unitary operation.
		double total = Math.sqrt(this.first);
		return total;
	}
	@Override
	public void showHist() {
		System.out.print("The Square root of " + this.first + " = ");
	}
}
