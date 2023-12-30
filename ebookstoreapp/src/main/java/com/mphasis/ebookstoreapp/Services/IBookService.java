package com.mphasis.ebookstoreapp.Services;

import java.util.List;

import com.mphasis.ebookstoreapp.Book.Book;


public interface IBookService {

	Book addBook(Book product);
	
	Book updateBook(Book product);
	
	void deleteBookById(Integer id);
	
	Book getBookById(Integer id);
	
	List<Book> getAllBooks();

	Book getBookByYear(int year);

	Book getBookByTitle(String title);

	Book getBookByPublisher(String publisher);
}

