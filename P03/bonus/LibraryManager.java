import java.util.Scanner;

public class LibraryManager{
	public static void main(String args[]){
		// Instancing a new library
		Library library = new Library("UTA Bookstore");
		
		// Instancing new publications (books) and adding them to the library
		Publication rpiHandbook = new Publication("Raspberry Pi Operating System Assembly Language", "Smith", 2023);
		library.addPublication(rpiHandbook);
		
		Publication algorithms = new Publication("Intro to Algorithms", "Cormen", 2023);
		library.addPublication(algorithms);
		
		Publication physics = new Publication("Physics II Electricity and Light", "Sipes", 2023);
		library.addPublication(physics);
		
		// Instancing new patron and adding them to library
		Patron patron1 = new Patron("Nicholas Tran", "nvt7150@mavs.uta.edu");
		library.addPatron(patron1);
		
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
