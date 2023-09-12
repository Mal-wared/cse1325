import java.time.LocalDate;

public class Publication{
	private String title;
	private String author;
	private int copyright;
	private String loanedTo;
	private LocalDate dueDate;
	
	public Publication(String title, String author, int copyright){
		this.title = title;
		this.author = author;
		if(copyright < 1900 || copyright > LocalDate.now().getYear()){
			throw new IllegalArgumentException("Invalid date");
		}
		this.copyright = copyright;
	}
	
	public void checkOut(String patron){
		loanedTo = patron;
		dueDate = LocalDate.now().plusDays(14);
	}
	
	public void checkIn(){
		
	}
	
	@Override
	public String toString(){
		String loanStatus = new String();
		String toString = new String();
		if(loanedTo != null){
			loanStatus = String.format("    --> loaned to %s until %s\n", loanedTo, dueDate.toString());
			toString = String.format("%s's \"%s\", copyright %d\n%s", author, title, copyright, loanStatus);
		}
		else{
			toString = String.format("%s's \"%s\", copyright %d\n", author, title, copyright);
		}
		
		return toString;
	}
}
