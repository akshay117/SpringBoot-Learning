package com.books.BooksApi;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.books.BooksApi.Model.Book;
import com.books.BooksApi.Service.BookService;





@SpringBootApplication
public class BooksApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApiApplication.class, args);}
	
	@Bean
	CommandLineRunner runner(BookService bookService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/books.json");
			try {
				List<Book> books = mapper.readValue(inputStream,typeReference);
				bookService.save(books);
				System.out.println("Books are Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Books: " + e.getMessage());
			}
			
		};
	}

}
