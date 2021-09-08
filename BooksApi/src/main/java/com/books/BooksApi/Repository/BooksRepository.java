package com.books.BooksApi.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.books.BooksApi.Model.Book;

public interface BooksRepository extends MongoRepository<Book, Long>{

	void save(List<Book> books);

}
