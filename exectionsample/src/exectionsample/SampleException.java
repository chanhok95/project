package exectionsample;

public class SampleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2431652314626465793L;
				//사용자 지정 exception
	
	
	public SampleException() {
		
	}
	
	
	public SampleException(String message) {
			super(message);
	}
}
