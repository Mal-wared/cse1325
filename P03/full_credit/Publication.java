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
	
	public checkOut(String patron){
		loanedTo = patron;
		LocalDate today = LocalDate.now();
		dueDate = today.plusDays(14);
	}
	
	public checkIn(){
	
	}
	
	public String toString(){
		
	}
}
