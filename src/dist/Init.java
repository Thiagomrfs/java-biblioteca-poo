package dist;

import java.util.HashMap;
import java.util.Map;

import library.Library;
import library.LibraryManager;
import user.User;
import user.Employee;
import user.UserManager;
import library.Category;
import book.Book;
import book.BookManager;
import book.PhysicalBook;
import book.Ebook;
import book.BookStates;

public final class Init {
	public static void generalInit() {
		initUsers();
		initBooks();
		initLibraries();
		System.out.println("Sistema populado com sucesso!!!");
	}
	
	private static Map<String, User> initUsers() {
		User thiago = new User("Thiago", "000.000.000");
		User gilvan = new User("Gilvan", "000.000.001");
		
		Employee nickolas = new Employee("Nickolas", "000.000.002", 1500);
		Employee julio = new Employee("Julio", "000.000.003", 1500);
		
		HashMap<String, User> map = new HashMap<String, User>() {
			private static final long serialVersionUID = 1L;
		{
	        put(thiago.getName(), thiago);
	        put(gilvan.getName(), gilvan);
	        put(nickolas.getName(), nickolas);
	        put(julio.getName(), julio);
	    }};
	    
	    UserManager.saveUsers(map);
	    
	    return map;
	}
	
	private static void initLibraries() {
		Library central = new Library("Central");
		Library ventos = new Library("Ventos");
		
		Category centralTerror = new Category("Central assustada");
		Category centralAmor = new Category("Central amada");
		populateCategory(centralTerror);
		populateCategory(centralAmor);
		central.addCategory(centralTerror);
		central.addCategory(centralAmor);
		
		Category ventosComedia = new Category("Ventos engraçados");
		Category ventosSuspeitos = new Category("Ventos suspeitos");
		populateCategory(ventosComedia);
		populateCategory(ventosSuspeitos);
		ventos.addCategory(ventosComedia);
		ventos.addCategory(ventosSuspeitos);
		
		HashMap<String, User> users = UserManager.getUsers();
		ventos.addEmployee((Employee) users.get("Nickolas"));
		ventos.addEmployee((Employee) users.get("Julio"));
		central.addEmployee((Employee) users.get("Julio"));
		
		
		HashMap<String, Library> map = new HashMap<String, Library>() {
			private static final long serialVersionUID = 1L;
		{
	        put(central.getName(), central);
	        put(ventos.getName(), ventos);
	    }};
	    
	    LibraryManager.saveLibraries(map);
	}
	
	private static void populateCategory(Category category) {
		HashMap<String, Book> books = BookManager.getBooks();
		
		for (Map.Entry<String, Book> entry : books.entrySet()) {
            Book value = entry.getValue();
            category.addBook(value);
        }
	}
	
	private static void initBooks() {
		Book b1 = new PhysicalBook("Viagem ao centro da terra", "Jorje", "isbn1", 10, BookStates.EXCELLENT);
		Book b2 = new PhysicalBook("A bela e a fera", "Jorjin", "isbn2", 10, BookStates.FAIR);
		Book b3 = new PhysicalBook("Eu", "Marcos", "isbn3", 10, BookStates.EXCELLENT);
		
		Book eb1 = new Ebook("Marley e eu", "Jorje", "isbn4", 10, "http://baixarlivros.com");
		Book eb2 = new Ebook("Tristeza sem fim", "Jorjin", "isbn5", 10, "http://baixarlivros.com");
		Book eb3 = new Ebook("Amongus", "Marcos", "isbn6", 10, "http://baixarlivros.com");
		
		
		HashMap<String, Book> map = new HashMap<String, Book>() {
			private static final long serialVersionUID = 1L;
		{
	        put(b1.getTitle(), b1);
	        put(b2.getTitle(), b2);
	        put(b3.getTitle(), b3);
	        put(eb1.getTitle(), eb1);
	        put(eb2.getTitle(), eb2);
	        put(eb3.getTitle(), eb3);
	    }};
	    
	    BookManager.saveBooks(map);
	}
}
