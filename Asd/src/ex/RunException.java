package ex;

public class RunException {

	
	public void runException() throws CodeValueNotFoundException {
		throw new CodeValueNotFoundException("code value not found");
	}
}
