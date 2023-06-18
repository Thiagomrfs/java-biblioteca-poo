package dist;

import java.util.HashMap;
import java.util.Map;

import user.User;
import user.UserManager;

public class Main {

	public static void main(String[] args) {
		Map<String, String> arguments = parseArguments(args);
		Map<String, User> users = UserManager.getUsers();
		
		for (String arg : args) {
            if (arg.equals("--init")) {
                Init.generalInit();
                return;
            }
        }
		
		String username = arguments.get("uid");
		String library = arguments.get("lib");
		String category = arguments.get("cat");
		
		User currentUser = users.get(username);
		
		if (currentUser == null) {			
			System.out.println("Não foi possível encontrar um usuário com esse uid!");
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
        }

        return arguments;
    }

}
