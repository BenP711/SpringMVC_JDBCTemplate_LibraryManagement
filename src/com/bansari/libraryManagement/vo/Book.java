package com.bansari.libraryManagement.vo;

public class Book {

	private int bookId;
	private String bookName;
	private String author;
	private String isbn;
	private int numberOfCopies;
	
	public Book() {
		super();
	}

	public Book(int bookId, String bookName, String author, String isbn, int numberOfCopies) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.isbn = isbn;
		this.numberOfCopies = numberOfCopies;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
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

	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	
	
}
