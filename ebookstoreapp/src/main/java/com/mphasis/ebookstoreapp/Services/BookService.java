package com.mphasis.ebookstoreapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mphasis.ebookstoreapp.Book.Book;
import com.mphasis.ebookstoreapp.Repo.BookRepository;



@Service(value = "bookService")
@Scope("singleton")
@Transactional
public class BookService implements IBookService {

	@Autowired
	@Qualifier("bookRepository")
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {

		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {

		return bookRepository.save(book);
	}

	@Override
	public void deleteBookById(Integer id) {

		bookRepository.deleteById(id);
	}

	@Override
	public Book getBookById(Integer id) {

		return bookRepository.findById(id).get();
	}


	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	public Book getBookByYear(int year) {
		return bookRepository.getBookByYear(year).get();
	}

	@Override
	public Book getBookByTitle(String title) {
		 return bookRepository.findByTitle(title);
	}

	@Override
	public Book getBookByPublisher(String publisher) {
		return bookRepository.getBookByPublisher(publisher).get();
	}
}