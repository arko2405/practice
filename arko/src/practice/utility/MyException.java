package practice.utility;

public class MyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public MyException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
