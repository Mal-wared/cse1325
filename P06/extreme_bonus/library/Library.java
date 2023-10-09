package library;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

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
	
	public Library(BufferedReader br){
		boolean patronsSectionReached = false;
		try(br){
			while(br.readLine() != null){
				String line = br.readLine().trim();
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
					}
					catch(NumberFormatException e){
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
		}catch(IOException e){
			e.printStackTrace();
		}
		
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
	
	/**
	  * Checks in a publication from the list of publications from a patron
	  * 
	  * @param publicationIndex   the index of the intended publication to checkin
	  * @since                    1.0
	  */
	public void checkIn(int publicationIndex){
		publications.get(publicationIndex).checkIn();
	}
	
	/**
	  * Generates the list of command options, a.k.a. the menu
	  * 
	  * @since          1.0
	  */
	public String toMenu(){
		StringBuilder menu = new StringBuilder();
		menu.append("\n\tMain Menu\n");
		menu.append(String.format("\t*%s\n\n", name));
		
		menu.append("Publications\n");
		menu.append("1) List\n");
		menu.append("2) Add New Publication\n");
		menu.append("3) Add New Video\n");
		menu.append("4) Check Out\n");
		menu.append("5) Check In\n\n");
		
		menu.append("Patrons\n");
		menu.append("6) List\n");
		menu.append("7) Add\n\n");
		
		
		menu.append("Files\n");
		menu.append("8) Load\n");
		menu.append("9) Save\n");
		menu.append("0) Exit\n");
		return menu.toString();
	}
	
	public void save(BufferedWriter bw){
		try{
			bw.write(String.format("%s", name));
			for(int i = 0; i < publications.size(); i++){
				publications.get(i).save(bw);
			}
			bw.write("\nPatrons");
			for(int i = 0; i < patrons.size(); i++){
				patrons.get(i).save(bw);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	/**
	  * Reads in a file's values to the intended library
	  * 
	  * @param fileName	  the name of the file to be read
	  * @since            1.0
	  */
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
					}
					catch(NumberFormatException e){
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
		}
		catch(FileNotFoundException e){
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
		toString.append(String.format("\n*%s\n\n", name));
		for(int i = 0; i < publications.size(); i++){
			toString.append(String.format("%d) %s", i, publications.get(i).toString()));
		}
	
		return toString.toString();
	}
}
