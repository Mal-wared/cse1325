public class Publication{
	private String title;
	private String author;
	private int copyright;
	private String loanedTo;
	private LocalDate dueDate;
	
	public Publication(String title, String author, int copyright){
		this.title = title;
		this.author = author;
		if(copyright < 1900 || copyright > LocalDate.getYear()){
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
		String loanStatus;
		if(!loanedTo.equals(NULL)){
			loanStatus = String.format("    --> loaned to %s ", loanedTo);
		}
		String toString = String.format("%s's \"%s\", copyright %d\n%s", author, title, copyright, loanStatus);
	}
}
