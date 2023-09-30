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
		
		// Utilizing scanners to ask the user their information
		Scanner scanner = new Scanner(System.in);
		
		boolean quit = false;
		while(!quit){
			System.out.println(library.toMenu());
			String cmdInput = scanner.nextLine();
			StringBuilder result = new StringBuilder();                
			if(cmdInput.equals("1")){
				System.out.println("Enter File Name to Read: ");
				String fileName = scanner.nextLine();
				library.readFile(fileName);
				result.append(String.format("Read file \"%s\"\n", fileName));
			} 
			else if(cmdInput.equals("2")){
				System.out.println(library.toString());
			} 
			else if(cmdInput.equals("3")){
				System.out.println("Enter New Publication's Title: ");
				String title = scanner.nextLine();
				System.out.println("Enter New Publication's Author: ");
				String author = scanner.nextLine();
				System.out.println("Enter New Publication's Copyright: ");
				int copyright = Integer.parseInt(scanner.nextLine());
				Publication newPub = new Publication(title, author, copyright);
				library.addPublication(newPub);
				result.append(String.format("Added publication %s", newPub.toString()));
			} 
			else if(cmdInput.equals("4")){
				System.out.println("Enter New Publication's Title: ");
				String title = scanner.nextLine();
				System.out.println("Enter New Publication's Author: ");
				String author = scanner.nextLine();
				System.out.println("Enter New Publication's Copyright: ");
				int copyright = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter New Publication's Runtime: ");
				int runtime = Integer.parseInt(scanner.nextLine());
				Video newVid = new Video(title, author, copyright, runtime);
				library.addPublication(newVid);
				result.append(String.format("Added video %s", newVid.toString()));
			} 
			else if(cmdInput.equals("5")){
				System.out.println("Enter New Patron's Name: ");
				String name = scanner.nextLine();
				System.out.println("Enter New Patron's E-mail: ");
				String email = scanner.nextLine();
				Patron newPat = new Patron(name, email);
				library.addPatron(newPat);
				System.out.println(String.format("Added patron %s", newPat.toString()));
			} 
			else if(cmdInput.equals("6")){
				System.out.println(library.patronMenu());
			} 
			else if(cmdInput.equals("7")){
				System.out.println(library.toString());
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
			else if(cmdInput.equals("9")){
				quit = true;
			}
			else{
				result.append("Invalid input, try another command");
			}
	
			System.out.println(result.toString());
		}
	}
}
