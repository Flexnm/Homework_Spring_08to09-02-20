package beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Book {
	
	private int id;
	private String title;
	private int pages;
	private int authorID;
	
	public Book(int id, String title, int pages, int authorID) {
		this.id = id;
		setTitle(title);
		setPages(pages);
		setAuthorID(authorID);
	}
	
	public Book(String title, int pages, int authorID) {
		setTitle(title);
		setPages(pages);
		setAuthorID(authorID);
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getPages() {
		return pages;
	}
	
	public int getAuthorID() {
		return authorID;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	
	public String toString() {
		return "Book title: " + title + ", Pages: " + pages + ", Written by " + authorID;
	}

}
