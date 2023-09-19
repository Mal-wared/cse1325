package library;

import java.time.Duration;

public class Video extends Publication{
	private Duration runtime;
	
	public Video(String title, String author, int copyright, int runtime){
		super(title, author, copyright);
		this.runtime = Duration.ofMinutes(runtime);
		if(runtime <= 0){
			throw new InvalidRuntimeException(title, runtime);
		}
	}
	
	@Override
	public String toString(){
		return toStringBuilder("Video", String.format("%d", runtime.toMinutes()));
	}
}
