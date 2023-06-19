package library;

import java.io.Serializable;
import java.util.ArrayList;
import book.Book;
import book.Ebook;
import book.PhysicalBook;
import java.util.Scanner;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Book> books = new ArrayList<Book>();

	public Category(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void addBook() {
		System.out.println("Adding book! \n");
		Scanner scanner = new Scanner(System.in);
		
		String title = askUserInput(scanner, "Book's title");
		String author = askUserInput(scanner, "Book's author");
		String isbn = askUserInput(scanner, "Book's isbn");
		int pageCount = askUserNumberInput(scanner, "Book's page count");
		boolean isEbook = askYesOrNo(scanner, "Is it an E-book");
		
		if (isEbook) {
			String downloadUrl = askUserInput(scanner, "Book's download url");
			Ebook book = new Ebook(title, author, isbn, pageCount, downloadUrl);
			this.books.add(book);
		} else {
			PhysicalBook book = new PhysicalBook(title, author, isbn, pageCount);
			this.books.add(book);
		}

        scanner.close();
        System.out.println("Book added! \n");
	}
	
	private String askUserInput(Scanner scanner, String msg) {
		System.out.print(msg + ": ");
        String res = scanner.nextLine();
        return res;
	}
	
	private int askUserNumberInput(Scanner scanner, String msg) {
		System.out.print(msg + ": ");
		int res = 0;
		
		try {
			res = scanner.nextInt();
			scanner.nextLine();
		} catch (Exception e) {
			System.out.println("tipo de valor inválido! Setando valor para 0.");
		}
        
        return res;
	}
	
	private boolean askYesOrNo(Scanner scanner, String msg) {
		System.out.print(msg + "?[Y/N] ");
        String res = scanner.nextLine();
        
        ArrayList<String> accepted = new ArrayList<String>();
        accepted.add("Y");
        accepted.add("y");
        accepted.add("yes");
        
        return accepted.contains(res);
	}
	
	public void removeBook(PhysicalBook instance) {
		this.books.remove(instance);
	}
	
	public void removeBook(Ebook instance) {
		this.books.remove(instance);
	}

	public ArrayList<Book> getBooks() {
		return books;
	}
	
	public ArrayList<Book> getBooksByTitles(ArrayList<String> titles) {
		ArrayList<Book> response = new ArrayList<>();
        
        for (String title : titles) {
            for (Book book : getBooks()) {
                if (book.getTitle().equals(title)) {
                    response.add(book);
                    break;
                }
            }
        }
        
        return response;
	}
	
	public void listBooks() {
		System.out.println("Books on " + name + ":");
		for (Book book: books) {
			System.out.println("  - " + book.getTitle());
		}
	}
}
