package com.books.BooksApi.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.stereotype.Service;
import com.books.BooksApi.Model.Book;
import com.books.BooksApi.Repository.BooksRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookService {
	
	private BooksRepository booksRepository;

	public BookService(BooksRepository booksRepository) {
		this.booksRepository= booksRepository;
		
	}
	
	public Iterable<Book> list(){return booksRepository.findAll();}
	
	public Book save(Book books) { return booksRepository.save(books); }
	
	public void save(List<Book> books) { booksRepository.saveAll(books);}

	
	 public   Iterable<Book> runner() throws JsonParseException, JsonMappingException, IOException {
		
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/books.json");
			 List<Book> books = mapper.readValue(inputStream,typeReference);
				return books;
				
		
			}
	
	
}
	

