package com.drew.mvc.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.drew.mvc.models.Book;
import com.drew.mvc.services.BookService;

@Controller
public class BooksController {
    private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    // View all books
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/index.jsp";
    }
    
    // Add new book
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/new.jsp";
    }
    
    // Post route that creates a book and checks for errors
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/new.jsp";
        } else {
            bookService.createOrEditBook(book);
            return "redirect:/books";
        }
    }
    
    // Show one book
    @GetMapping("/books/{id}")
    public String show(Model model, @PathVariable ("id") String id) {
    	model.addAttribute("book", bookService.findBook((long) Integer.parseInt(id)));
        return "/show.jsp";
    }
    
    // Edit one book
    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/edit.jsp";
    }
    
    // Post route that edits a book and checks for errors
    @PostMapping("/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit.jsp";
        } else {
            bookService.createOrEditBook(book);
            return "redirect:/books";
        }
    }
    // Delete one book    
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}