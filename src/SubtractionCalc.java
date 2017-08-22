/**
 * Defines Subtraction object.
 * 
 * @author Chris Gray
 *
 */
public class SubtractionCalc implements Calculation {
	protected double first = 0.0;
	protected double second = 0.0;
	@Override
	public void setVars(double firstNum, double secondNum) {
		first = firstNum;
		second = secondNum;
	}
	@Override
	public double getResult() {
		double total = this.first - this.second;
		return total;
	}
	@Override
	public void showHist() {
		System.out.print(this.first + " - " + this.second + " = ");
	}
}
