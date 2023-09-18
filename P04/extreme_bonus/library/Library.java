package library;

import java.util.ArrayList;

public class Library{
	private String name;
	private ArrayList<Publication> publications = new ArrayList<>();
	private ArrayList<Patron> patrons = new ArrayList<>();
	
	public Library(String name){
		this.name = name;
	}
	
	public void addPublication(Publication publication){
		publications.add(publication);
	}
	
	public void addPatron(Patron patron){
		patrons.add(patron);
	}
	
	public String patronMenu(){
		StringBuilder patMenu = new StringBuilder();
		patMenu.append(String.format("Patrons\n\n"));
		for(int i = 0; i < patrons.size(); i++){
			patMenu.append(String.format("%d) %s\n", i, patrons.get(i).toString()));
		}
		return patMenu.toString();
	}
	
	public void checkOut(int publicationIndex, int patronIndex){
		publications.get(publicationIndex).checkOut(patrons.get(patronIndex));
		
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
