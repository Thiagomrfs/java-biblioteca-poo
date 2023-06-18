package book;

public abstract class Book {
	private String title;
    private String author;
    private String isbn;
    private int pageCount;
    
	public Book(String title, String author, String isbn, int pageCount) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.pageCount = pageCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
    
    
}
