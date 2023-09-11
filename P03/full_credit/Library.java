public class Library{
	private String name;
	private ArrayList<Publication> publications;
	
	public Library(String name){
		this.name = name;
	}
	
	public addPublication(Publication publication){
		publications.add(publication);
	}
	
	public void checkOut(int publicationIndex, String patron){
		publications.get(publicationIndex).checkOut(patron);
		
	}
	
	public String toString(){
		return name;
	}
}
