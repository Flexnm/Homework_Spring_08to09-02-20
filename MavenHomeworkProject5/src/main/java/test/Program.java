package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Author;
import beans.Book;
import config.SpringConfig;
import db.AuthorDBDAO;
import db.BookDBDAO;

public class Program {
	public static void main(String[] args) {
		
		
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)){
			
			AuthorDBDAO auDB = ctx.getBean(AuthorDBDAO.class);
			BookDBDAO boDB = ctx.getBean(BookDBDAO.class);
			
//			auDB.addAuthor(new Author("Writer Man", "writing@books.com", 25));
//			boDB.addBook(new Book("The Book", 500, 2));
//			boDB.addBook(new Book("How to Java 201", 458, 1));
			
			boDB.deleteBook(2);
			auDB.deleteAuthor(2);
			
			System.out.println(auDB.getAllAuthors());
			System.out.println(boDB.getAllBooks());
			
			
		}
	}

}
