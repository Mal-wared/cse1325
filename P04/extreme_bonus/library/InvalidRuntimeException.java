package library;

public class InvalidRuntimeException extends ArithmeticException{


	public InvalidRuntimeException(String s){
		super(s);
	}
	
	public InvalidRuntimeException(String title, int runtime){
		System.err.println(String.format("%s has invalid runtime %d", title, runtime));
	}
}
