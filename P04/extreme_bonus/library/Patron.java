package library;

/**
  * A person authorized to check out a library resource.
  * 
  * @author             Nicholas Tran
  * @version            1.0
  * @since              1.0
  * @license.agreement  Gnu General Public License 3.0
  */
public class Patron{
	private String name;
	private String email;
	
	/**
	  * Creates a Patron instance
	  * 
	  * @param name    the name of the patron
	  * @param email   the email of the patron
	  * @since         1.0
	  */
	public Patron(String name, String email){
		this.name = name;
		this.email = email;
	}
	
	/**
	  * The patron instance converted to a string
	  * 
	  * @since   1.0
	  */
	public String toString(){
		String toString = String.format("%s (%s)", name, email);
		return toString;
	}
}
