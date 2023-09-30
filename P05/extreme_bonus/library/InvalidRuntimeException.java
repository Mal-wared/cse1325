package library;

/**
  * Models an exception pertaining to an invalid integer input for movie runtime.
  * 
  * @author              Nicholas Tran
  * @version             1.0
  * @since               1.0
  * @license.agreement   Gnu General Public License 3.0
  */
public class InvalidRuntimeException extends ArithmeticException{
	/** 
	  * Default constructor for InvalidRuntimeException
	  * 
	  * @since 1.0
	  */
	public InvalidRuntimeException(){
		
	}
	
	/** 
	  * Default constructor for InvalidRuntimeException
	  * 
	  * @param s   the custom message the users inputs when this error occurs 
	  * @since     1.0
	  */
	public InvalidRuntimeException(String s){
		super(s);
	}
	
	/** 
	  * Default constructor for InvalidRuntimeException
	  * 
	  * @param title     the title of a publication whose runtime input is invalid
	  * @param runtime   the invalid runtime of a publication
	  * @since           1.0
	  */
	public InvalidRuntimeException(String title, int runtime){
		System.err.println(String.format("%s has invalid runtime %d", title, runtime));
	}
}
