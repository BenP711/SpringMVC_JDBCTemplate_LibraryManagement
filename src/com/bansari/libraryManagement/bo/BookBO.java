package com.bansari.libraryManagement.bo;

import java.util.List;

import com.bansari.libraryManagement.vo.Book;
import com.bansari.libraryManagement.vo.BookIssue;

public interface BookBO {

	public List<Book> getAllAvailableBooks();

	public List<Book> getAllBooks();
	
	public List<BookIssue> getIssuedBooks();
	
	public void addNewBook(Book book);
	
	public void deleteBook(int bookId);
	
	public Book displayBookInfoToUpdate(int bookId);
	
	public void updateBook(Book book);
}
