package com.bansari.libraryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bansari.libraryManagement.bo.BookBO;
import com.bansari.libraryManagement.bo.UserBO;

@Controller
public class CustomerController {

	@Autowired
	UserBO userBO;

	@Autowired
	BookBO bookBO;
	

	public CustomerController() {
		super();
	}

	// Display all books POST
	@RequestMapping(value = "/customerAccess.do", params = "listAllBooks", method = RequestMethod.POST)
	public String getAllBooks(Model model) {

		//this.bookList = this.bookBO.getAllBooks();
		//AdminController.bookListPage
		
		return "redirect:/listOfAllBooksCustomer.do";
	}

	// Display all books GET
	@RequestMapping(value = "/listOfAllBooksCustomer.do", method = RequestMethod.GET)
	public String getAllBooksGET(Model model) {

		/*
		 * model.addAttribute(this.bookListObj, this.bookList);
		 * model.addAttribute("customerLogin", "customer");
		 * model.addAttribute(this.bookListPage, "AllBooks");
		 */
		return "listOfBooks";
	}

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	/*
	 * public static String getBookListObj() { return bookListObj; }
	 * 
	 * public static void setBookListObj(String bookListObj) {
	 * CustomerController.bookListObj = bookListObj; }
	 * 
	 * public static String getBookListPage() { return bookListPage; }
	 * 
	 * public static void setBookListPage(String bookListPage) {
	 * CustomerController.bookListPage = bookListPage; }
	 */
	
	
}
