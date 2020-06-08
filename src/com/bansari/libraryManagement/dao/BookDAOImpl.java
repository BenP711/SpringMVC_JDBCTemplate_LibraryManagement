package com.bansari.libraryManagement.dao;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bansari.libraryManagement.vo.Book;
import com.bansari.libraryManagement.vo.BookIssue;

@Service
public class BookDAOImpl implements BookDAO {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public BookDAOImpl() {
		super();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Book> getAllAvailableBooks() {

		String selectSql = "select * from book where numberOfcopies>0";

		@SuppressWarnings("unchecked")
		List<Book> availableBooksList = this.jdbcTemplate.query(selectSql, (rs, rowNum) -> new Book(rs.getInt("bookId"),
				rs.getString("bookName"), rs.getString("author"), rs.getString("isbn"), rs.getInt("numberOfCopies")));

		return availableBooksList;
	}

	@Override
	public List<Book> getAllBooks() {

		String selectSql = "select * from book";

		@SuppressWarnings("unchecked")
		List<Book> allBooksList = this.jdbcTemplate.query(selectSql, (rs, rowNum) -> new Book(rs.getInt("bookId"),
				rs.getString("bookName"), rs.getString("author"), rs.getString("isbn"), rs.getInt("numberOfCopies")));

		return allBooksList;
	}

	@Override
	public List<BookIssue> getIssuedBooks() {

		String selectSql = "select book.bookName, book.isbn, user.userName from book, user, bookissue where book.bookId = bookissue.bookId and user.userId =bookissue.userId";

		@SuppressWarnings("unchecked")
		List<BookIssue> issuedBooksList = this.jdbcTemplate.query(selectSql, (rs,
				rowNum) -> new BookIssue(rs.getString("userName"), rs.getString("bookName"), rs.getString("isbn")));

		return issuedBooksList;
	}

	@Override
	public void addNewBook(Book book) {

		String InsertBookSql = "INSERT INTO Book (bookName, author, isbn, numberOfCopies) values(?, ?, ?, ?)";
		Object[] bookObjForSql = new Object[] { book.getBookName(), book.getAuthor(), book.getIsbn(),
				book.getNumberOfCopies() };
		int[] columnDataTypes = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER };

		this.jdbcTemplate.update(InsertBookSql, bookObjForSql, columnDataTypes);
	}

	@Override
	public void deleteBook(int bookId) {

		String deleteSql = "DELETE FROM Book WHERE bookId=" + bookId;
		this.jdbcTemplate.update(deleteSql);
	}

	@Override
	public Book displayBookInfoToUpdate(int bookId) {
		String selectSqlById = "select * from Book where bookId=" + bookId;

		@SuppressWarnings("unchecked")
		List<Book> bookDataFromDB = this.jdbcTemplate.query(selectSqlById, (rs, rowNum) -> new Book(rs.getInt("bookId"),
				rs.getString("bookName"), rs.getString("author"), rs.getString("isbn"), rs.getInt("numberOfCopies")));

		if (bookDataFromDB != null) {
			return bookDataFromDB.get(0);
		}
		return null;
	}

	@Override
	public void updateBook(Book book) {

		String updateSql = "UPDATE book SET bookName='" + book.getBookName() + "', author='" + book.getAuthor()
				+ "',isbn='" + book.getIsbn() + "', numberOfCopies='" + book.getNumberOfCopies() + "'   where bookId=" + book.getBookId();
		this.jdbcTemplate.update(updateSql);
	}
}
