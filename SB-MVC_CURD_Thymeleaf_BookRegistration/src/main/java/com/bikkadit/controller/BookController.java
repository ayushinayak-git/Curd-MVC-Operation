package com.bikkadit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bikkadit.entity.Book;
import com.bikkadit.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	
	@GetMapping("/addbook")
	public String loadform(Model model)
	{
		Book book= new Book();
		model.addAttribute("bookadded", book);
		return "addbook";
		
	}
	@PostMapping("/savebook")
	public String savebook(@ModelAttribute Book book)
	{
		if("NO".equalsIgnoreCase(book.getStatus()))
		{
			return "outofstock";
		}
		service.savebook(book);
		return "success";
	}
	@GetMapping("/getbook/{bid}")
	public String getbook(@PathVariable int bid, Model model)
	{
		Book book = service.getBook(bid);
		model.addAttribute("getbook", book);
		return "bookdetails" ;
	}
	@GetMapping("/getallbooks")
	public String getallbooks(Model model)
	{
		List<Book> allBooks = service.getAllBooks();
		model.addAttribute("books", allBooks);
		return "listofbooks";
	}
  @GetMapping("/update/{bid}")
  public String updateBook(@PathVariable int bid, Model model)
  {
	  Book book = service.getBook(bid);
	  model.addAttribute("update", book);
	return "updatebook";
}
  @PostMapping("/updatebook")
  public String updateBook(@ModelAttribute Book book)
  {
	  service.savebook(book);
	return "updatesuccess";
	  
  }
  @GetMapping("/delete/{bid}")
  public String delete(@PathVariable int bid,Model model)
  {
	  service.deleteBook(bid);
	  return "redirect:/getallbooks";
  }
}
