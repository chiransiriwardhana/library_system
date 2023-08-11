package com.librarySystem.RestAPI.controller;

import java.util.List;

import com.librarySystem.RestAPI.Service.LibraryService;
import com.librarySystem.RestAPI.dto.ResponseMessageBody;
import com.librarySystem.RestAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarySystem.RestAPI.model.Book;

@RestController
public class LibraryController {

	@Autowired
	LibraryService libraryService;

	@RequestMapping(value = "/all-books", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Book>> getAllBooks() {
		try {
//			List<Book> books = bookRepository.findAll();
			List<Book> books = libraryService.getAllBooks();
			if(books.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/add-books", method = RequestMethod.POST)
	public ResponseEntity<Book> addBooks(@RequestBody Book book) {
		try {
			ResponseMessageBody responseMessageBody = libraryService.addBook(book);
			return new ResponseEntity<>(responseMessageBody.getBook(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@RequestMapping(value = "/search-by-title-and-author/{author}/{title}", method = RequestMethod.GET)
//	public ResponseEntity<List<Book>> getBookByTitleAndAuthor(@PathVariable("author") String author,
//			@PathVariable("title") String title) {
//
//		List<Book> books = bookRepository.findByAuthorAndTitle(title, author);
//
//		if(books.isEmpty()) {
//			return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
//	}

	@RequestMapping(value = "/search-by-title/{title}", method = RequestMethod.GET)
	public ResponseEntity<Book> getBookByTitleAndAuthor(@PathVariable("title") String title) {

//		Book book = bookRepository.findByTitle(title);

		Book book = libraryService.searchByTitle(title);

		if(book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@RequestMapping(value = "/search-by-author/{author}", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable("author") String author) {


		List<Book> book = libraryService.searchByAuthor(author);

		if(book == null) {
			return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
	}

	@RequestMapping(value = "/loan/{title}", method = RequestMethod.POST)
	public ResponseEntity<String> loan(@PathVariable("title") String title, @RequestBody User user) {
		try {
			ResponseMessageBody responseMessageBody = libraryService.loanBook(title, user);
			if(responseMessageBody.getMessage() != null) {
				return new ResponseEntity<String>(responseMessageBody.getMessage(), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<String>(responseMessageBody.getUser().getName() + " has borrowed the book.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/return/{title}", method = RequestMethod.POST)
	public ResponseEntity<String> returnBook(@PathVariable("title") String title, @RequestBody User user) {

		try {
			ResponseMessageBody responseMessageBody = libraryService.returnBook(user,title);
			return new ResponseEntity<String>(responseMessageBody.getMessage(), HttpStatus.OK);

		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
//	@RequestMapping(value = "/loan/{title}", method = RequestMethod.POST)
//	public ResponseEntity<String> loan(@PathVariable("title") String title) {
//		try {
//			Book book =  bookRepository.findByTitle(title);
//			if(book.getStock() < 1) {
//				return new ResponseEntity<String>("Your requested book \"" + book.getTitle() + "\" is out of stock!"+" "+book.getStock(), HttpStatus.NOT_FOUND);
//			}
//			book.borrow();
//			Date currentDate = new Date();
//			book.setBorrowDate(currentDate);
//			bookRepository.save(book);
//			return new ResponseEntity<String>(" has borrowed one copy of \"" + book.getTitle() + "\"!" + " "+book.getStock() + " borrow Date: "+ book.getBorrowedDate(), HttpStatus.OK);
//		} catch(Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@RequestMapping(value = "/return/{title}", method = RequestMethod.PUT)
//	public ResponseEntity<String> returnBook(@PathVariable("title") String title) {
//		try {
//			Book book = bookRepository.findByTitle(title);
//			book.returned();
//			bookRepository.save(book);
//			Date currentDate = new Date();
//			book.setReturnedDate(currentDate);
//			return new ResponseEntity<String>("Successfully returned"+ " availble books " + book.getStock()+ " returned Date: "+book.getReturnedDate(), HttpStatus.OK);
//		} catch(Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
}
