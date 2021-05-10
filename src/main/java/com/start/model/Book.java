package com.start.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Document("book") //this is only book
//@Document(collection = "book1")
@Document("book") //this is only book
public class Book {
	
	@Id
	private int bookId;
	private String bookName;
	private String bookAuthor;
	

	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
	}
	
	
	
	

}
