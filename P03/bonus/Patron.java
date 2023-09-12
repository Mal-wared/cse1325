public class Patron{
	private String name;
	private String email;
	
	public Patron(String name, String email){
		this.name = name;
		this.email = email;
	}
	
	public String toString(){
		String toString = String.format("%s (%s)", name, email);
		return toString;
		
	}
}
