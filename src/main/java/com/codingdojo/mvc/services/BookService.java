package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	 public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    //Creando un libro.
	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }
	    //Obteniendo la información de un libro
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
	    	Optional<Book> optionalBook = bookRepository.findById(id);
	    	
	    	if(optionalBook.isPresent()) {
		    	Book b = optionalBook.get();
		    	b.setTitle(title);
		    	b.setDescription(desc);
		    	b.setLanguage(lang);
		    	b.setNumberOfPages(numOfPages);
	    	
		    	return bookRepository.save(b);
	    	}
	    	else {
	    		return null;
	    	}
	    	
	    }
	    
	    public void deleteBook(Long id) {
	    	Optional<Book> optionalBook = bookRepository.findById(id);
	    	Book b = optionalBook.get();
	    	
	    	bookRepository.delete(b);
	    
	    }
	}


