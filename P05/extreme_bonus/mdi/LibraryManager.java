package mdi;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import library.Library;
import library.Publication;
import library.Patron;
import library.Video;

public class LibraryManager{
	public static void main(String args[]){
		// Instancing a new library
		Library library = new Library("UTA Bookstore");
	
		// Instancing new scanner to utilize
		try{
			Scanner fileScanner = new Scanner(new File("library.txt"));
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
							library.addPublication(newPub);
						}
						else if(parts.length == 4){
							int runtime = Integer.parseInt(parts[3].trim());
							
							Video newPub = new Video(title, author, copyright, runtime);
							library.addPublication(newPub);
						}
						
					}catch(NumberFormatException e){
						System.err.println("Error parsing copyright for line: " + line);
					}
					
				}
				else{
					String name = parts[0].trim();
					String email = parts[1].trim();
					
					Patron newPat = new Patron(name, email);
					library.addPatron(newPat);
				}
				
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
	
		// Printing out the contents of the library
		System.out.println(library.toString());
		
		// Utilizing scanners to ask the user their information
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Which book would you like to check out? ");
		String bookIndex = scanner.nextLine();
		
		System.out.println(library.patronMenu());
		
		System.out.println("Which patron are you? ");
		String patronIndex = scanner.nextLine();
		
		// Checking out the publication (book) for the user while checking for valid inputs
		try{
			library.checkOut(Integer.valueOf(bookIndex), Integer.valueOf(patronIndex));
		} catch(IndexOutOfBoundsException e){
			System.err.println(String.format("IndexOutOfBoundsException thrown: Invalid book index input \"%s\"", bookIndex));
		} catch(NumberFormatException e){
			System.err.println(String.format("NumberFormatException thrown: Invalid book index input \"%s\"", bookIndex));
		}
		
		System.out.println(library.toString());
	}
}
