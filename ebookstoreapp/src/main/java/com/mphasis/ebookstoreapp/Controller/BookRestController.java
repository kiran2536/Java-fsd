package com.mphasis.ebookstoreapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.mphasis.ebookstoreapp.Book.Book;
import com.mphasis.ebookstoreapp.Repo.BookRepository;
import com.mphasis.ebookstoreapp.Services.IBookService;


@RestController
@Scope("request")
public class BookRestController {

	@Autowired
	@Qualifier("bookService")
	private IBookService bookService;
	
	@GetMapping(value = "/books", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Book> getAllBooks() {
		
		return bookService.getAllBooks();
	}
	
	@GetMapping(value = "/books/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Book getBookById(@PathVariable("id")Integer id) {
		
		return bookService.getBookById(id);
	}
	@GetMapping(value = "/books/year={year}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Book getBookByYear(@PathVariable("year") int year) {
		
		return bookService.getBookByYear(year);
	}
	
	@GetMapping(value = "/books/publisher/{publisher}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Book getBookByPublisher(@PathVariable("publisher") String publisher) {
		
		return bookService.getBookByPublisher(publisher);
	}
//	@GetMapping(value = "/books/publisher/{publisher}", produces = {MediaType.APPLICATION_JSON_VALUE})
//	public Book getBookpublisher(@PathVariable("publisher") String publisher) {
//		
//		return bookService.getBookPublisher(publisher);
//	}
	
	@GetMapping(value = "/books/title/{title}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Book getBookByTitle(@PathVariable("title")String title) {
		
		return bookService.getBookByTitle(title);
	}
	
	@PostMapping(value = "/books", produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Book addBook(@RequestBody Book book) {
		
		return bookService.addBook(book);
	}

	@PutMapping(value = "/books", produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Book updateBook(@RequestBody Book book) {
		
		return bookService.updateBook(book);
	}

	@DeleteMapping(value = "/books/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteBookById(@PathVariable("id")Integer id) {
		
		bookService.deleteBookById(id);
	}
}

