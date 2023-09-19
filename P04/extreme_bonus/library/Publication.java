package library;

import java.time.LocalDate;

/**
  * A library resource that can be checked out by a patron.
  * 
  * @author             Nicholas Tran
  * @version            1.0
  * @since              1.0
  * @license.agreement  Gnu General Public License 3.0
  */
public class Publication{
	private String title;
	private String author;
	private int copyright;
	private Patron loanedTo;
	private LocalDate dueDate;
	
	/**
	  * Creates a Publication instance
	  * 
	  * @param title                          the title of a publication
	  * @param author                         the author of the publication
	  * @param copyright                      the copyright year of the publication
	  * @exception IllegalArgumentException   the exception used to catch an invalid date given
	  * @since                                1.0
	  */
	public Publication(String title, String author, int copyright){
		this.title = title;
		this.author = author;
		if(copyright < 1900 || copyright > LocalDate.now().getYear()){
			throw new IllegalArgumentException("Invalid date");
		}
		this.copyright = copyright;
	}
	
	/**
	  * Checks out a publication to a patron and sets its due date 2 weeks from today
	  * 
	  * @param patron   the patron that checks out this publication
	  * @since          1.0
	  */
	public void checkOut(Patron patron){
		loanedTo = patron;
		dueDate = LocalDate.now().plusDays(14);
	}
	
	/**
	  * N/a
	  * 
	  * @since          1.0
	  */
	public void checkIn(){
		
	}
	
	/**
	  * Creates a string depending on whether or not the publication is a book or video
	  * 
	  * @param pre   the input determining if the publication is a book or video
	  * @param mid   the runtime of the publication in minutes (given the publication is a video)
	  * @return      returns a string depending on the input of parameter pre
	  * @since       1.0
	  */
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
	
	/**
	  * The publication instance converted to a string
	  * 
	  * @since   1.0
	  */
	@Override
	public String toString(){		
		return toStringBuilder("Book", "");
	}
}
