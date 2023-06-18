package dist;

import java.util.HashMap;
import java.util.Map;

import library.Library;
import library.LibraryManager;
import user.User;
import user.Employee;
import user.UserManager;
import library.Category;

public final class Init {
	public static void generalInit() {
		initUsers();
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
		Library ventos = new Library("Ventos fortes");
		
		Category centralTerror = new Category("Central assustada");
		Category centralAmor = new Category("Central amada");
		central.addCategory(centralTerror);
		central.addCategory(centralAmor);
		
		Category ventosComedia = new Category("Ventos engraçados");
		Category ventosSuspeitos = new Category("Ventos suspeitos");
		ventos.addCategory(ventosComedia);
		ventos.addCategory(ventosSuspeitos);
		
		
		HashMap<String, Library> map = new HashMap<String, Library>() {
			private static final long serialVersionUID = 1L;
		{
	        put(central.getName(), central);
	        put(ventos.getName(), ventos);
	    }};
	    
	    LibraryManager.saveLibraries(map);
	}
}
