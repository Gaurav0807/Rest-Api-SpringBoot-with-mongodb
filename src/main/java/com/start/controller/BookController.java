package com.start.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.start.Exception.*;

import com.start.model.Book;
import com.start.repo.BookRepositery;

@RestController
public class BookController {
	
	@Autowired
	private  BookRepositery repo;
	
	@GetMapping("/books")
	public  ResponseEntity<List<Book>> getAllBooks(HttpServletRequest request)
	{
		 List<Book> book = repo.findAll();
	        if (book.isEmpty()) {
	            return  new ResponseEntity(HttpStatus.NO_CONTENT);
	        }
	        return  new ResponseEntity<List<Book>>(HttpStatus.OK);
	}
	
	
	@GetMapping("/books/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") int id,HttpServletRequest request)
		{
		
		 Optional<Book> book = repo.findById(id);
	        if (book == null) {
	            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Book>(HttpStatus.OK);
	}
	
	@PostMapping("/books")
	public ResponseEntity<?> CreateBook(@RequestBody Book b,HttpServletRequest request)
	{
		repo.save(b);
		return new ResponseEntity<Book>(HttpStatus.CREATED);
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable(value = "id") int id,
			 @RequestBody Book b ,HttpServletRequest request) {
		b.setBookId(id);		
	    repo.save(b);
		return new ResponseEntity<Book>(HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") int id,HttpServletRequest request)
			throws ResourceNotFoundException {
		Book book  = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));

		repo.delete(book);
		
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
	
	

}
