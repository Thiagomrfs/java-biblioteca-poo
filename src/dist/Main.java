package dist;

import java.util.HashMap;
import java.util.Map;

import user.User;
import user.UserManager;

public class Main {

	public static void main(String[] args) {
		Map<String, String> arguments = parseArguments(args);
		
		if (arguments.get("init") != null) {
			Init.generalInit();
            return;
		}
		
		Map<String, User> users = UserManager.getUsers();
		
		String username = arguments.get("uid");
		User currentUser = users.get(username);
		
		if (currentUser == null) {			
			System.out.println("Unable to get the current user!");
			return;
		}
		
		if (arguments.get("loans") != null) {
			currentUser.printLoans();
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

}
