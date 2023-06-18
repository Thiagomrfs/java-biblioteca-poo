package dist;

import java.util.HashMap;
import java.util.Map;
import user.User;
import user.Employee;
import user.UserManager;

public final class Init {
	public static void generalInit() {
		initUsers();
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
}
