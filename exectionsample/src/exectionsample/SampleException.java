package exectionsample;

public class SampleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2431652314626465793L;
				//����� ���� exception
	
	
	public SampleException() {
		
	}
	
	
	public SampleException(String message) {
			super(message);
	}
}
