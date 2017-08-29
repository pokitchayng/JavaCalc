/**
 * Factory class calls for object creation based on type requested.
 * 
 * @author Chris Gray
 * Last modified 08/28/2017
 */
public class CalculationFactory {

	/**
	 * Uses passed in operator type to select the correct object type, calls the constructor
	 * method for that object.
	 * 
	 * @param operator specifies what type of object to create.
	 * @return the object of the appropriate type.
	 */
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
