package com.mphasis.ebookstoreapp.Repo;

import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.ebookstoreapp.Book.Book;


@Repository(value = "bookRepository")
@Scope("singleton")
public interface BookRepository extends JpaRepository<Book, Integer> {


	Optional<Book> getBookByYear(int year);

	Book findByTitle(String title);

	Optional<Book> getBookByPublisher(String publisher);

	
}

