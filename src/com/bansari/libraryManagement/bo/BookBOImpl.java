package com.bansari.libraryManagement.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansari.libraryManagement.dao.BookDAO;
import com.bansari.libraryManagement.vo.Book;
import com.bansari.libraryManagement.vo.BookIssue;

@Service
public class BookBOImpl implements BookBO {
	
	@Autowired
	BookDAO bookDAO;

	public BookBOImpl() {
		super();
	}
	
	public BookDAO getUserDAO() {
		return bookDAO;
	}

	public void setUserDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public List<Book> getAllAvailableBooks() {
		return this.bookDAO.getAllAvailableBooks();
	}

	@Override
	public List<Book> getAllBooks() {
		return this.bookDAO.getAllBooks();
	}

	@Override
	public List<BookIssue> getIssuedBooks() {
		return this.bookDAO.getIssuedBooks();
	}

	@Override
	public void addNewBook(Book book) {
		this.bookDAO.addNewBook(book);
	}

	@Override
	public void deleteBook(int bookId) {
		this.bookDAO.deleteBook(bookId);
		
	}

	@Override
	public Book displayBookInfoToUpdate(int bookId) {
		return this.bookDAO.displayBookInfoToUpdate(bookId);
	}

	@Override
	public void updateBook(Book book) {
		this.bookDAO.updateBook(book);
	}
}
