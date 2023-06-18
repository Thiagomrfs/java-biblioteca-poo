package book;

public class Ebook extends Book 
{
	private static final long serialVersionUID = 1L;
	private String downloadUrl;

	public Ebook(String title, String author, String isbn, int pageCount, String downloadUrl) {
		super(title, author, isbn, pageCount);
		this.downloadUrl = downloadUrl;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

}
