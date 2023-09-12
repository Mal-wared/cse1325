import java.util.ArrayList;

public class Library{
	private String name;
	private ArrayList<Publication> publications = new ArrayList<>();
	
	public Library(String name){
		this.name = name;
	}
	
	public void addPublication(Publication publication){
		publications.add(publication);
	}
	
	public void checkOut(int publicationIndex, String patron){
		publications.get(publicationIndex).checkOut(patron);
		
	}
	
	public String toString(){
		StringBuilder toString = new StringBuilder();
		toString.append(String.format("%s\n\n", name));
		for(int i = 0; i < publications.size(); i++){
			toString.append(String.format("%d) %s", i, publications.get(i).toString()));
		}
	
		return toString.toString();
	}
}
