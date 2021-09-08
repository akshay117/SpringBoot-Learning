package com.books.BooksApi.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.books.BooksApi.Model.Book;
import com.books.BooksApi.Repository.BooksRepository;

@Service
public class BookService {
	
	private BooksRepository booksRepository;

	public BookService(BooksRepository booksRepository) {
		this.booksRepository= booksRepository;
		
	}
	
	public Iterable<Book> list(){return booksRepository.findAll();}
	
	public Book save(Book books) { return booksRepository.save(books); }
	
	public void save(List<Book> books) { booksRepository.saveAll(books);}

	
	
	
}
