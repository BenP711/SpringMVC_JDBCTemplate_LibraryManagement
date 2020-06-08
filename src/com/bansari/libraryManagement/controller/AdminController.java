package com.bansari.libraryManagement.controller;

import static com.bansari.libraryManagement.constant.AdminAccessConstants.ADD_BOOK_MODEL_ATTR_NAME;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.ADD_NEW_BOOK_VIEW;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.BOOK_LIST_MODEL_ATTR_NAME;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.BOOK_LIST_TYPE_ALL_MODEL_ATTR_VALUE;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.BOOK_LIST_TYPE_AVAILABLE_MODEL_ATTR_VALUE;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.BOOK_LIST_TYPE_ISSUED_MODEL_ATTR_VALUE;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.BOOK_LIST_TYPE_MODEL_ATTR_NAME;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.LIST_OF_BOOKS_VIEW;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.LIST_OF_ISSUED_BOOKS;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.LIST_OF_USERS_VIEW;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.LOGIN_MODEL_ATTR_NAME;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.LOGIN_MODEL_ATTR_VALUE;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.USER_DETAILS_ADMIN_ACCESS_VIEW;
import static com.bansari.libraryManagement.constant.AdminAccessConstants.USER_LIST_MODEL_ATTR_NAME;
import static com.bansari.libraryManagement.constant.UserLoginConstants.ADMIN_HOME_PAGE_VIEW;
import static com.bansari.libraryManagement.constant.UserLoginConstants.LOGIN_VIEW;
import static com.bansari.libraryManagement.constant.UserLoginConstants.USER_OBJ;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bansari.libraryManagement.bo.BookBO;
import com.bansari.libraryManagement.bo.LoginCredentialsBO;
import com.bansari.libraryManagement.bo.UserBO;
import com.bansari.libraryManagement.vo.Book;
import com.bansari.libraryManagement.vo.BookIssue;
import com.bansari.libraryManagement.vo.User;

@Controller
public class AdminController {

	@Autowired
	UserBO userBO;

	@Autowired
	BookBO bookBO;

	@Autowired
	LoginCredentialsBO loginCredentialsBO;

	public AdminController() {
		super();
	}

	// Display all the users to admin
	@RequestMapping(value = "/adminAccess", params = "listOfUsers", method = { RequestMethod.POST, RequestMethod.GET })
	public String getAllUsers(@ModelAttribute User user, Model model, HttpServletRequest request) {

		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			List<User> userList = this.userBO.getAllUsers();
			model.addAttribute(USER_LIST_MODEL_ATTR_NAME, userList);
			return LIST_OF_USERS_VIEW;
		} else {
			return LOGIN_VIEW;
		}
	}

	// Display selected user details from admin account
	@RequestMapping(value = "/{userName}Details{userId}", method = RequestMethod.GET)
	public String getSelectedUsedDetails(@PathVariable int userId, Model model, HttpServletRequest request) {

		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			User user = this.userBO.getSelectedUsedDetails(userId);
			model.addAttribute(USER_OBJ, user);

			return USER_DETAILS_ADMIN_ACCESS_VIEW;
		} else {
			return LOGIN_VIEW;
		}
	}

	// Display all available books
	@RequestMapping(value = "/adminAccess", params = "availableBooks", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String getAllAvailableBooks(Model model, HttpServletRequest request) {

		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			List<Book> bookList = this.bookBO.getAllAvailableBooks();
			model.addAttribute(BOOK_LIST_MODEL_ATTR_NAME, bookList);
			model.addAttribute(BOOK_LIST_TYPE_MODEL_ATTR_NAME, BOOK_LIST_TYPE_AVAILABLE_MODEL_ATTR_VALUE);
			model.addAttribute(LOGIN_MODEL_ATTR_NAME, LOGIN_MODEL_ATTR_VALUE);

			return LIST_OF_BOOKS_VIEW;
		} else {
			return LOGIN_VIEW;
		}
	}

	// Display all books POST
	@RequestMapping(value = "/adminAccess", params = "listAllBooks", method = { RequestMethod.POST, RequestMethod.GET })
	public String getAllBooks(Model model, HttpServletRequest request) {

		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			List<Book> allBookList = this.bookBO.getAllBooks();
			model.addAttribute(BOOK_LIST_MODEL_ATTR_NAME, allBookList);
			model.addAttribute(BOOK_LIST_TYPE_MODEL_ATTR_NAME, BOOK_LIST_TYPE_ALL_MODEL_ATTR_VALUE);
			model.addAttribute(LOGIN_MODEL_ATTR_NAME, LOGIN_MODEL_ATTR_VALUE);

			return LIST_OF_BOOKS_VIEW;
		} else {
			return LOGIN_VIEW;
		}
	}

	// Display issued books
	@RequestMapping(value = "/adminAccess", params = "issuedBooks", method = { RequestMethod.POST, RequestMethod.GET })
	public String getIssuedBooks(Model model, HttpServletRequest request) {
		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			List<BookIssue> issuedBooksList = this.bookBO.getIssuedBooks();
			model.addAttribute(BOOK_LIST_MODEL_ATTR_NAME, issuedBooksList);
			model.addAttribute(BOOK_LIST_TYPE_MODEL_ATTR_NAME, BOOK_LIST_TYPE_ISSUED_MODEL_ATTR_VALUE);
			model.addAttribute(LOGIN_MODEL_ATTR_NAME, LOGIN_MODEL_ATTR_VALUE);

			return LIST_OF_ISSUED_BOOKS;
		} else {
			return LOGIN_VIEW;
		}
	}

	// Go to add new book page
	@RequestMapping(value = "/adminAccess", params = "addNewBook", method = { RequestMethod.POST, RequestMethod.GET })
	public String addNewBook(@ModelAttribute Book book, Model model, HttpServletRequest request) {

		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			model.addAttribute(ADD_BOOK_MODEL_ATTR_NAME, book);
			return ADD_NEW_BOOK_VIEW;
		} else {
			return LOGIN_VIEW;
		}
	}

	// Add new book details into database
	@RequestMapping(value = "/saveNewBook", params = "Save", method = { RequestMethod.POST, RequestMethod.GET })
	public String saveNewBook(@ModelAttribute Book book, Model model, HttpServletRequest request) {

		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			this.bookBO.addNewBook(book);

			return ADMIN_HOME_PAGE_VIEW;
		} else {
			return LOGIN_VIEW;
		}
	}

	// Display book info to update data
	@RequestMapping(value = "/updateBook{bookId}", method = RequestMethod.GET)
	public String getBookInfoForUpdate(@PathVariable int bookId, Model model, HttpServletRequest request) {

		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			Book book = bookBO.displayBookInfoToUpdate(bookId);
			model.addAttribute(ADD_BOOK_MODEL_ATTR_NAME, book);

			return ADD_NEW_BOOK_VIEW;
		} else {
			return LOGIN_VIEW;
		}
	}

	// Update book data
	@RequestMapping(value = "/saveNewBook", params = "Update", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute Book book, Model model, HttpServletRequest request) {

		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			bookBO.updateBook(book);
			List<Book> bookList = bookBO.getAllBooks();

			model.addAttribute(BOOK_LIST_MODEL_ATTR_NAME, bookList);
			model.addAttribute(LOGIN_MODEL_ATTR_NAME, LOGIN_MODEL_ATTR_VALUE);
			model.addAttribute(BOOK_LIST_TYPE_MODEL_ATTR_NAME, BOOK_LIST_TYPE_ALL_MODEL_ATTR_VALUE);

			return LIST_OF_BOOKS_VIEW;
		} else {
			return LOGIN_VIEW;
		}
	}

	// delete a book from list of all books page
	@RequestMapping(value = "/deleteBook{bookId}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable int bookId, Model model, HttpServletRequest request) {

		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			bookBO.deleteBook(bookId);
			List<Book> bookList = bookBO.getAllBooks();

			model.addAttribute(BOOK_LIST_MODEL_ATTR_NAME, bookList);
			model.addAttribute(LOGIN_MODEL_ATTR_NAME, LOGIN_MODEL_ATTR_VALUE);
			model.addAttribute(BOOK_LIST_TYPE_MODEL_ATTR_NAME, BOOK_LIST_TYPE_ALL_MODEL_ATTR_VALUE);

			return LIST_OF_BOOKS_VIEW;
		} else {
			return LOGIN_VIEW;
		}
	}

	// Sign out
	@RequestMapping(value = "/adminAccess", params = "logOut", method = RequestMethod.POST)
	public String logOut(@ModelAttribute User user, Model model, HttpServletRequest request) {

		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			this.loginCredentialsBO.logOut(request);
		}
		return LOGIN_VIEW;
	}

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	public BookBO getBookBO() {
		return bookBO;
	}

	public void setBookBO(BookBO bookBO) {
		this.bookBO = bookBO;
	}

	public LoginCredentialsBO getLoginCredentialsBO() {
		return loginCredentialsBO;
	}

	public void setLoginCredentialsBO(LoginCredentialsBO loginCredentialsBO) {
		this.loginCredentialsBO = loginCredentialsBO;
	}
}
