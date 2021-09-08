package com.books.BooksApi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.BooksApi.Model.Book;
import com.books.BooksApi.Service.BookService;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	private BookService bookService;

	public BooksController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping("/list")
	public  Iterable<Book> list(){
		return bookService.list();
	}
	

}
