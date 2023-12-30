package com.mphasis.ebookstoreapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.mphasis.ebookstoreapp.Book.Book;
import com.mphasis.ebookstoreapp.Repo.BookRepository;

@SpringBootApplication
public class BookstoreappApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BookstoreappApplication.class, args);
	}
	
	

	@Autowired
	@Qualifier("bookRepository")
	private BookRepository bookRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		bookRepository.save(new Book(1,".NET","255887-9765-8656",256,1990,"Austen"));
		bookRepository.save(new Book(2,"Python", "34534",2569,1989,"Dickens"));
    	bookRepository.save(new Book(3,"Java", "44534-865-988",200,1897,"A.C.Doyle"));
		bookRepository.save(new Book(4,"Artificial Intelligence", "335-87789-9834",150,1913,"T.Hardly"));
		bookRepository.save(new Book(5,"Machine Learning", "789-988-63534",143,2021,"Rainesford Stauffer"));

		System.out.println(bookRepository.findAll());
	}

}