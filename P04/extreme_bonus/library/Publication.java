package library;

import java.time.LocalDate;

public class Publication{
	private String title;
	private String author;
	private int copyright;
	private Patron loanedTo;
	private LocalDate dueDate;
	
	public Publication(String title, String author, int copyright){
		this.title = title;
		this.author = author;
		if(copyright < 1900 || copyright > LocalDate.now().getYear()){
			throw new IllegalArgumentException("Invalid date");
		}
		this.copyright = copyright;
	}
	
	public void checkOut(Patron patron){
		loanedTo = patron;
		dueDate = LocalDate.now().plusDays(14);
	}
	
	public void checkIn(){
		
	}
	
	protected String toStringBuilder(String pre, String mid){
		String loanStatus = new String();
		String toString = new String();
		if(loanedTo != null){
			if(pre.equals("Book")){
				loanStatus = String.format("    --> loaned to %s until %s\n", loanedTo, dueDate.toString());
				toString = String.format("Book %s's \"%s\", copyright %d\n%s", author, title, copyright, loanStatus);
			}
			else if(pre.equals("Video")){
				loanStatus = String.format("    --> loaned to %s until %s\n", loanedTo, dueDate.toString());
				toString = String.format("Video %s's \"%s\", copyright %d, runtime %d\n%s", author, title, copyright, Integer.parseInt(mid), loanStatus);
			}
			
		}
		else{
			if(pre.equals("Book")){
				toString = String.format("Book %s's \"%s\", copyright %d\n", author, title, copyright);
			}
			else if(pre.equals("Video")){
				toString = String.format("Video %s's \"%s\", copyright %d, runtime %d\n", author, title, copyright, Integer.parseInt(mid));
			}
		}
		
		return toString;
	}
	
	@Override
	public String toString(){		
		return toStringBuilder("Book", "");
	}
}
