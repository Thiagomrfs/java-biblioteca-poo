package dist;

import java.util.HashMap;
import java.util.Map;

import book.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import library.Category;
import library.Library;
import library.LibraryManager;
import user.Employee;
import user.User;
import user.UserManager;
import library.Loan;

public class Main {
	private static Map<String, String> arguments;
	private static User currentUser;
	private static Library currentLib;
	private static Category currentCategory;

	public static void main(String[] args) {
		arguments = parseArguments(args);
		
		if (arguments.get("init") != null) {
			Init.generalInit();
            return;
		}
		
		try {
			currentUser = getCurrentUser();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		if (arguments.get("loans") != null) {
			currentUser.printLoans();
            return;
		}
		
		try {
			currentLib = getCurrentLibrary();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
			currentCategory = getCurrentCategory();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		if (arguments.get("books") != null) {
			currentCategory.listBooks();
            return;
		}
		
		try {
			checkMethod(args);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	private static Map<String, String> parseArguments(String[] args) {
        Map<String, String> arguments = new HashMap<>();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            
            if (arg.startsWith("--")) {
                String key = arg.substring(2);
                
                if (i + 1 < args.length) {
                    String value = args[i + 1];
                    arguments.put(key, value);
                    i++;
                } else {
                	arguments.put(key, null);
                }
            }
            
            if (arg.startsWith("-")) {
                String key = arg.substring(1);
                
                arguments.put(key, "present");
            }
        }

        return arguments;
    }

	private static User getCurrentUser() throws Exception {
		Map<String, User> users = UserManager.getUsers();
		String username = arguments.get("uid");
		User currentUser = users.get(username);
		
		if (currentUser == null) {			
			throw new Exception("Unable to get the current user!"); 
		}
		
		return currentUser;
	}
	
	private static Library getCurrentLibrary() throws Exception {
		Map<String, Library> libs = LibraryManager.getLibraries();
		String lib = arguments.get("lib");
		Library currentLib = libs.get(lib);
		
		if (currentLib == null) {			
			throw new Exception("Unable to get the current library!"); 
		}
		
		return currentLib;
	}
	
	private static Category getCurrentCategory() throws Exception {
		for (Category category : currentLib.getCategories()) {
            if (category.getName().equals(arguments.get("cat"))) {
                return category;
            }
        }
		
		throw new Exception("Unable to get the current category!"); 
	}
	
	private static void checkMethod(String[] args) throws Exception {
		if (arguments.get("add") != null) {
			if (!(currentUser instanceof Employee)) throw new Exception("You need to be an Employee to add a new book!");
			if (!currentLib.getEmployees().contains(currentUser)) throw new Exception("You does not have access to this library!"); 
			
			currentCategory.addBook();
			currentLib.saveState();
            return;
		}
		
		loanBooks(args);
	}
	
	private static void loanBooks(String[] args) {
		ArrayList<String> titles = getTitles(args);
        ArrayList<Book> books = currentCategory.getBooksByTitles(titles);
        System.out.println("This is your receipt: \n");
        
        if (!books.isEmpty()) {
        	Loan loan = new Loan(currentLib, currentUser, LocalDate.now(), LocalDate.now().plusDays(7));
            
            for (Book book: books) {
        		book.addToLoan(loan);
            }
        } else {
        	System.out.println("This library doesn't have the specified books!");
        }
	}
	
	private static ArrayList<String> getTitles(String[] args) {
		String query = "--loan";
		ArrayList<String> titles = new ArrayList<String>();
		boolean loaning = false;
		
		if (!Arrays.asList(args).contains(query)) return null;
		

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(query)) loaning = true;
            
            if(loaning) {
            	if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                    titles.add(args[i + 1]);
                } else loaning = false;
            }
        }
        
        return titles;
	}
}
