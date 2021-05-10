package com.start.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.start.model.Book;

public interface BookRepositery extends MongoRepository<Book,Integer>{

}
