/**
  * Models a library containing various publications.
  * 
  * @author             Nicholas Tran
  * @version            1.0
  * @since              1.0
  * @license.agreement  Gnu General Public License 3.0
  */

package library;

import java.util.ArrayList;

public class Library{
	private String name;
	private ArrayList<Publication> publications = new ArrayList<>();
	private ArrayList<Patron> patrons = new ArrayList<>();
	
	/**
	  * Creates a Library instance
	  * 
	  * @param name   the name of the library
	  * @since        1.0
	  */
	public Library(String name){
		this.name = name;
	}
	
	/**
	  * Adds a publication to the library's list of publications
	  * 
	  * @param publication   the publication to be added 
	  * @since               1.0
	  */
	public void addPublication(Publication publication){
		publications.add(publication);
	}
	
	/**
	  * Adds a patron to the library's list of patrons
	  * 
	  * @param patron   the patron to be added 
	  * @since          1.0
	  */
	public void addPatron(Patron patron){
		patrons.add(patron);
	}
	
	/**
	  * Generates the list of patrons
	  * 
	  * @since          1.0
	  */
	public String patronMenu(){
		StringBuilder patMenu = new StringBuilder();
		patMenu.append(String.format("Patrons\n\n"));
		for(int i = 0; i < patrons.size(); i++){
			patMenu.append(String.format("%d) %s\n", i, patrons.get(i).toString()));
		}
		return patMenu.toString();
	}
	
	/**
	  * Checks out a publication from the list of publications to a specific patron
	  * 
	  * @since   1.0
	  */
	public void checkOut(int publicationIndex, int patronIndex){
		publications.get(publicationIndex).checkOut(patrons.get(patronIndex));
		
	}
	
	/**
	  * Generates the list of publications
	  * 
	  * @since          1.0
	  */
	public String toString(){
		StringBuilder toString = new StringBuilder();
		toString.append(String.format("%s\n\n", name));
		for(int i = 0; i < publications.size(); i++){
			toString.append(String.format("%d) %s", i, publications.get(i).toString()));
		}
	
		return toString.toString();
	}
}
