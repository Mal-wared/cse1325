package library;

import java.time.Duration;

/**
  * A library video that can be checked out by a patron.
  * 
  * @author             Nicholas Tran
  * @version            1.0
  * @since              1.0
  * @license.agreement  Gnu General Public License 3.0
  */
public class Video extends Publication{
	private Duration runtime;
	
	/**
	  * Creates a Video instance
	  * 
	  * @param title                         the title of a video
	  * @param author                        the author of the video
	  * @param copyright                     the copyright year of the video
	  * @param runtime                       the length of the video in minutes
	  * @exception InvalidRuntimeException   a custom exception used to catch an invalid runtime input
	  * @since                               1.0
	  */
	public Video(String title, String author, int copyright, int runtime){
		super(title, author, copyright);
		if(runtime <= 0){
			throw new InvalidRuntimeException(title, runtime);
		}
		this.runtime = Duration.ofMinutes(runtime);
	}
	
	/**
	  * The video instance converted to a string
	  * 
	  * @since   1.0
	  */
	@Override
	public String toString(){
		return toStringBuilder("Video", String.format("%d", runtime.toMinutes()));
	}
}
