
public class CalculationFactory {

	//use getShape method to get object of type shape
	public Calculation getCalculation(String operator){
		if(operator.equals(null)){
			return null;
		}
		if(operator.equalsIgnoreCase("ADDITION")){
			return new AdditionCalc();
		} else if(operator.equalsIgnoreCase("SUBTRACTION")){
			return new SubtractionCalc();
		} else if(operator.equalsIgnoreCase("MULTIPLICATION")){
			return new MultiplicationCalc();
		} else if(operator.equalsIgnoreCase("DIVISION")){
			return new DivisionCalc();
		} else if(operator.equalsIgnoreCase("POWER")){
			return new PowerCalc();
		} else if(operator.equalsIgnoreCase("MODULO")){
			return new ModuloCalc();
		} else if(operator.equalsIgnoreCase("SQRT")){
			return new SQRTCalc();
		} else if(operator.equalsIgnoreCase("LOG")){
			return new LogCalc();
		}
		return null;
	}
}
