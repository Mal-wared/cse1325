package mdi;

import java.util.Scanner;
import library.Library;
import library.Publication;
import library.Patron;
import library.Video;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class LibraryManager{
	public static void main(String args[]) throws IOException{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\nWhat would you like to name your library? ");
		String libraryName = scanner.nextLine();
		Library library = new Library(libraryName);
	
		boolean quit = false;
		while(!quit){
			System.out.println(library.toMenu());
			System.out.print("Enter a command from the list: ");
			String cmdInput = scanner.nextLine();             
			if(cmdInput.equals("1")){
				listPublications(library);
			} 
			else if(cmdInput.equals("2")){
				addPublication(library, scanner);
			} 
			else if(cmdInput.equals("3")){
				addVideo(library, scanner);
			} 
			else if(cmdInput.equals("4")){
				checkOut(library, scanner);
			} 
			else if(cmdInput.equals("5")){
				checkIn(library, scanner);
			} 
			else if(cmdInput.equals("6")){
				listPatrons(library);
			} 
			else if(cmdInput.equals("7")){
				addPatron(library, scanner);
			} 
			else if(cmdInput.equals("8")){
				openLibrary(library, scanner);
			}
			else if(cmdInput.equals("9")){
				System.out.print("Enter File Name to Read: ");
				String fileName = scanner.nextLine();
			
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
					library.save(bw);
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			else if(cmdInput.equals("0")){
				quit = true;
			}
			else{
				System.out.println("Invalid input, try another command");
			}
		}
	}
	
	public static void openLibrary(Library library, Scanner scanner){
		System.out.print("Enter File Name to Read: ");
		String fileName = scanner.nextLine();
		library = new Library(fileName);
		System.out.println(String.format("\nOpened library from \"%s\"\n", fileName));
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			name = br.readLine().trim();
			boolean patronsSectionReached = false;
			
			while(fileScanner.readLine() != null){
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
						if(parts.length == 4){
							Publication newPub = new Publication(title, author, copyright);
							library.addPublication(newPub);
						}
						else if(parts.length == 5){
							int runtime = Integer.parseInt(parts[4].trim());
							
							Video newPub = new Video(title, author, copyright, runtime);
							library.addPublication(newPub);
						}
						else if(parts.length == 7){
							String name = parts[4].trim();
							String email = parts[5].trim();
							String date = parts[6].trim();
						
							Publication newPub = new Publication(title, author, copyright);
							library.addPublication(newPub);
							
						}
						else if(parts.length == 8){
							String name = parts[4].trim();
							String email = parts[5].trim();
							String date = parts[6].trim();
						
							int runtime = Integer.parseInt(parts[7].trim());
							
							Video newPub = new Video(title, author, copyright, runtime);
							library.addPublication(newPub);
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
					library.addPatron(newPat);
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void addVideo(Library library, Scanner scanner){
		System.out.print("Enter New Publication's Title: ");
		String title = scanner.nextLine();
		System.out.print("Enter New Publication's Author: ");
		String author = scanner.nextLine();
		System.out.print("Enter New Publication's Copyright: ");
		int copyright = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter New Publication's Runtime: ");
		int runtime = Integer.parseInt(scanner.nextLine());
		Video newVid = new Video(title, author, copyright, runtime);
		library.addPublication(newVid);
		System.out.println(String.format("\nAdded video %s", newVid.toString()));
	}
	
	public static void addPublication(Library library, Scanner scanner){
		System.out.print("Enter New Publication's Title: ");
		String title = scanner.nextLine();
		System.out.print("Enter New Publication's Author: ");
		String author = scanner.nextLine();
		System.out.print("Enter New Publication's Copyright: ");
		int copyright = Integer.parseInt(scanner.nextLine());
		Publication newPub = new Publication(title, author, copyright);
		library.addPublication(newPub);
		System.out.println(String.format("\nAdded publication %s", newPub.toString()));
	}
	
	public static void addPatron(Library library, Scanner scanner){
		System.out.print("Enter New Patron's Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter New Patron's E-mail: ");
		String email = scanner.nextLine();
		Patron newPat = new Patron(name, email);
		library.addPatron(newPat);
		System.out.println(String.format("\nAdded patron %s", newPat.toString()));
	}
	
	public static void listPublications(Library library){
		System.out.println(library.toString());
	}
	
	public static void listPatrons(Library library){
		System.out.print(library.patronMenu());
	}
	
	public static void checkOut(Library library, Scanner scanner){
		System.out.print(library.toString());
		System.out.print("Which book would you like to check out? ");
		String bookIndex = scanner.nextLine();

		System.out.print(library.patronMenu());

		System.out.print("Which patron are you? ");
		String patronIndex = scanner.nextLine();
	
		try{
			library.checkOut(Integer.valueOf(bookIndex), Integer.valueOf(patronIndex));
		} 
		catch(IndexOutOfBoundsException e){
			System.err.println(String.format("IndexOutOfBoundsException thrown: Invalid book index input \"%s\"", bookIndex));
		} 
		catch(NumberFormatException e){
			System.err.println(String.format("NumberFormatException thrown: Invalid book index input \"%s\"", bookIndex));
		}
		System.out.println(String.format("\nChecked out book %d for patron %d", Integer.valueOf(bookIndex), Integer.valueOf(patronIndex)));
		
		
	}
	
	public static void checkIn(Library library, Scanner scanner){
		System.out.println(library.toString());
		System.out.print("Which book would you like to check in? ");
		String bookIndex = scanner.nextLine();

		System.out.println(library.patronMenu());
		
		try{
			library.checkIn(Integer.valueOf(bookIndex));
		} 
		catch(IndexOutOfBoundsException e){
			System.err.println(String.format("IndexOutOfBoundsException thrown: Invalid book index input \"%s\"", bookIndex));
		} 
		catch(NumberFormatException e){
			System.err.println(String.format("NumberFormatException thrown: Invalid book index input \"%s\"", bookIndex));
		}
		System.out.println(String.format("\nChecked in book %d", Integer.valueOf(bookIndex)));
	}
	
	
}
