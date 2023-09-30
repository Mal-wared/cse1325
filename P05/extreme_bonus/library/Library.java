package library;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
  * Models a library containing various publications.
  * 
  * @author             Nicholas Tran
  * @version            1.0
  * @since              1.0
  * @license.agreement  Gnu General Public License 3.0
  */
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
	  * @return   returns the list of patrons 
	  * @since    1.0
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
	  * @param publicationIndex   the index of the intended publication to checkout
	  * @param patronIndex        the index of the intended patron that checks out
	  * @since                    1.0
	  */
	public void checkOut(int publicationIndex, int patronIndex){
		publications.get(publicationIndex).checkOut(patrons.get(patronIndex));
	}
	
	public void checkIn(int publicationIndex){
		publications.get(publicationIndex).checkIn();
	}
	
	public String toMenu(){
		StringBuilder menu = new StringBuilder();
		menu.append("1) Load Library from File\n");
		menu.append("2) List Publications and Videos\n");
		menu.append("3) Add New Publication\n");
		menu.append("4) Add New Video\n");
		menu.append("5) Add New Patron\n");
		menu.append("6) List Patrons\n");
		menu.append("7) Check Out Publication or Video\n");
		menu.append("8) Check In Publication or Video\n");
		menu.append("9) Exit program\n");
		return menu.toString();
	}
	
	public void readFile(String fileName){
		try{
			Scanner fileScanner = new Scanner(new File(fileName));
			boolean patronsSectionReached = false;
			
			while(fileScanner.hasNextLine()){
				String line = fileScanner.nextLine().trim();
				String[] parts = line.split(",");
				
				if(parts[0].equals("Patrons")){
					patronsSectionReached = true;
				}
				else if(!patronsSectionReached){
					String title = parts[0].trim();
					String author = parts[1].trim();
					int copyright = Integer.parseInt(parts[2].trim());
					try{
						if(parts.length == 3){
							Publication newPub = new Publication(title, author, copyright);
							addPublication(newPub);
						}
						else if(parts.length == 4){
							int runtime = Integer.parseInt(parts[3].trim());
							
							Video newPub = new Video(title, author, copyright, runtime);
							addPublication(newPub);
						}
						
					}catch(NumberFormatException e){
						System.err.println("Error parsing copyright for line: " + line);
					}
					
				}
				else{
					String name = parts[0].trim();
					String email = parts[1].trim();
					
					Patron newPat = new Patron(name, email);
					addPatron(newPat);
				}
				
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
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
