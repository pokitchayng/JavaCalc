/**
 * Defines Modulo division object.
 * 
 * @author Chris Gray
 *
 */
public class ModuloCalc implements Calculation {
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
		if(this.second != 0.0) { // Makes absolutely sure there is no division by 0.
			double total = this.first % this.second;
			return total;	
		} else {
			System.out.println("Cannot divide by zero returning 0");
			return 0;
		} 
	}
	@Override
	public void showHist() {
		System.out.print(this.first + " % " + this.second + " = ");
	}
}
