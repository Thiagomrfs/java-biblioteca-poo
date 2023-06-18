package book;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public final class BookManager {
	private static String filename = System.getProperty("user.dir") + "/books.bin";
	
	public static void saveBooks(HashMap<String, Book> books) {
		try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(books);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static HashMap<String, Book> getBooks() {
		try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            @SuppressWarnings("unchecked")
			HashMap<String, Book> hashMap = (HashMap<String, Book>) objectIn.readObject();
            objectIn.close();
            fileIn.close();

            return hashMap;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		return null;
	}
}
