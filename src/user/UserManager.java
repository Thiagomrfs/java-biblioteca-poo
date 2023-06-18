package user;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

public final class UserManager {
	private static String filename = System.getProperty("user.dir") + "/users.bin";
	
	public static void saveUsers(HashMap<String, User> users) {
		try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(users);
            objectOut.close();
            fileOut.close();
            System.out.println("HashMap serialized and saved to hashmap.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static HashMap<String, User> getUsers() {
		try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            @SuppressWarnings("unchecked")
			HashMap<String, User> hashMap = (HashMap<String, User>) objectIn.readObject();
            objectIn.close();
            fileIn.close();

            return hashMap;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return null;
	}
}
