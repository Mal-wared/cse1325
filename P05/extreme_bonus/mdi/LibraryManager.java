package mdi;

import java.util.Scanner;
import library.Library;
import library.Publication;
import library.Patron;
import library.Video;

public class LibraryManager{
	public static void main(String args[]){
		// Instancing a new library
		Library library = new Library("UTA Bookstore");
	
		// Instancing new scanner to utilize
		library.readFile("library.txt");
		
	
		// Printing out the contents of the library
		System.out.println(library.toString());
		
		// Utilizing scanners to ask the user their information
		Scanner scanner = new Scanner(System.in);
		
		
		
		// Checking out the publication (book) for the user while checking for valid inputs
		
		
		System.out.println(library.toString());
		
		boolean quit = false;
		while(!quit){
			System.out.println(library.toMenu());
			String cmdInput = scanner.nextLine();
			StringBuilder result = new StringBuilder();                
			if(cmdInput.equals("1")){
				String fileName = scanner.nextLine();
				library.readFile(fileName);
				result.append(String.format("Read file \"%s\"", fileName));
			} 
			else if(cmdInput.equals("2")){
				library.toString();
			} 
			else if(cmdInput.equals("3")){
				
				library.addPublication();
			} 
			else if(cmdInput.equals("4")){
			
			
				library.addPublication();
			} 
			else if(cmdInput.equals("5")){
				
				library.addPatron();
			} 
			else if(cmdInput.equals("6")){
				library.patronMenu();
			} 
			else if(cmdInput.equals("7")){
				System.out.println("Which book would you like to check out? ");
				String bookIndex = scanner.nextLine();
		
				System.out.println(library.patronMenu());
		
				System.out.println("Which patron are you? ");
				String patronIndex = scanner.nextLine();
			
				try{
					library.checkOut(Integer.valueOf(bookIndex), Integer.valueOf(patronIndex));
				} catch(IndexOutOfBoundsException e){
					System.err.println(String.format("IndexOutOfBoundsException thrown: Invalid book index input \"%s\"", bookIndex));
				} catch(NumberFormatException e){
					System.err.println(String.format("NumberFormatException thrown: Invalid book index input \"%s\"", bookIndex));
				}
			} 
			else if(cmdInput.equals("8")){
				
			}
			else{
			
			}
			
			System.out.println(result.toString());
			
			
		}
	}
}
