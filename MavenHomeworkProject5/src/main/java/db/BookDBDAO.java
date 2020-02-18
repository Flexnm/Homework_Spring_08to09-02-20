package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import beans.Book;

@Component
public class BookDBDAO implements RowMapper<Book> {

	@Autowired
	private JdbcTemplate jt;
	
	public void addBook(Book book) {
		jt.update("INSERT INTO books(title, pages, author_id) values(?, ?, ?)", book.getTitle(), book.getPages(), book.getAuthorID());
	}
	
	public void deleteBook(int id) {
		jt.update("DELETE FROM books WHERE id = " + id);
	}
	
	public List<Book> getAllBooks(){
		return jt.query("SELECT * FROM books", this);
	}

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Book(rs.getInt("id"), rs.getString("title"), rs.getInt("pages"), rs.getInt("author_id"));
	}
}
