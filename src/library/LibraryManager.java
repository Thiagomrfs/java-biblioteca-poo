package library;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public final class LibraryManager {
	private static String filename = System.getProperty("user.dir") + "/libraries.bin";
	
	public static void saveLibraries(HashMap<String, Library> libraries) {
		try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(libraries);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static HashMap<String, Library> getLibraries() {
		try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            @SuppressWarnings("unchecked")
			HashMap<String, Library> hashMap = (HashMap<String, Library>) objectIn.readObject();
            objectIn.close();
            fileIn.close();

            return hashMap;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		return null;
	}
	
	public static void updateLibrary(Library lib) {
		HashMap<String, Library> libs = getLibraries();
		libs.put(lib.getName(), lib);
		saveLibraries(libs);
	}
}
