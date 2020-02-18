package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import beans.Author;

@Component
public class AuthorDBDAO implements RowMapper<Author> {
	
	@Autowired
	private JdbcTemplate jt;
	
	public void addAuthor(Author author) {
		jt.update("INSERT INTO authors(name, email, age) values(?, ?, ?)", author.getName(), author.getEmail(), author.getAge());
	}
	
	public void deleteAuthor(int id) {
		jt.update("DELETE FROM authors WHERE id = " + id);
	}
	
	public List<Author> getAllAuthors() {
		return jt.query("SELECT * FROM authors", this);
	}
	
//	public Author getAuthor(int id) {
//		return jt.query("SELECT * FROM authors WHERE id = " + id, this);
//	}

	@Override
	public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Author(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("age"));
	}
	
	

}
