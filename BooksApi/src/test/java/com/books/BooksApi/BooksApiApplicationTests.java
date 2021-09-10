package com.books.BooksApi;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.books.BooksApi.Model.Book;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BooksApiApplicationTests {

	
	@LocalServerPort
	private int port ;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	org.springframework.http.HttpHeaders headers =  new org.springframework.http.HttpHeaders();
	
	 private String createURLWithPort(String uri) {
	       return "http://127.0.0.1:"+ port + uri; }
	
 
	 @Test
	 void jsonTest() throws JsonParseException, JsonMappingException, IOException {
			 
			 
	    	HttpEntity<Book> entity = new HttpEntity<Book>(null,headers);
            ResponseEntity<Book> response = restTemplate.exchange(createURLWithPort("/list"),
		                                           HttpMethod.GET,entity,Book.class);
            assertNotNull(response);

		   
	}
}

      

