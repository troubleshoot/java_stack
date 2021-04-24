package com.drew.mvc.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.drew.mvc.models.Book;
import com.drew.mvc.repositories.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    public Book createOrEditBook(Book book) {
        return bookRepository.save(book);
        
    }
    
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book editBook = this.findBook(id);
		editBook.setTitle(title);
		editBook.setDescription(desc);
		editBook.setLanguage(lang);
		editBook.setNumberOfPages(numOfPages);
		bookRepository.save(editBook);
		return editBook;
	}
	
	public void deleteBook(Long id) {
		Book deleteBook = this.findBook(id);
		bookRepository.delete(deleteBook);
	}
}