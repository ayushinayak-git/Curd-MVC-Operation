package com.bikkadit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.dao.BookDao;
import com.bikkadit.entity.Book;

@Service
public class BookService {
	@Autowired 
	private BookDao dao;
	
	
	 
	public Book savebook(Book book)
	{
		 return dao.save(book);
		
	}
	public Book getBook(int bid)
	{
		 Optional<Book> byId = dao.findById(bid);
		 Book book = byId.get();
		 return book;
		
	}
	public List<Book> getAllBooks()
	{
		 return dao.findAll();
		
	}
	public String deleteBook(int bid)
	{
		 dao.deleteById(bid);
		 return "Book deleted";
	}
	
	
}
