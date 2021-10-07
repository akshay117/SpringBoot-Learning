package com.books.BooksApi.Controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.BooksApi.Model.Book;
import com.books.BooksApi.Service.BookService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	private BookService bookService;

	public BooksController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	
	//Get from  Json file
	
	@GetMapping("/list")
	public  Iterable<Book> show() throws JsonParseException, JsonMappingException, IOException{
		return bookService.runner();
	}
	
	

}
