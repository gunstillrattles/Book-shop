package kz.narxoz.springbootdemo.controllers;

import kz.narxoz.springbootdemo.entity.Student;
import kz.narxoz.springbootdemo.entity.Book;
import kz.narxoz.springbootdemo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import kz.narxoz.springbootdemo.service.BookService;
import kz.narxoz.springbootdemo.service.UserService;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "books";
    }

    @GetMapping("/books/new")
    public String addBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "add_book";
    }

    @PostMapping("/books")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/update/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model) {
        bookService.findOneById(id);
        model.addAttribute("book", bookService.findOneById(id));
        return "updateBook";
    }

    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
        Book existstingBook = bookService.findOneById(id);
        existstingBook.setId(id);
        existstingBook.setBookName(book.getBookName());
        existstingBook.setAuthorName(book.getAuthorName());
        existstingBook.setPrice(book.getPrice());
        bookService.saveBook(existstingBook);
        return "redirect:/books";
    }

    @GetMapping("books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping(value = "/403")
    public String accessDenied(Model model) {
        return "403";
    }

    @GetMapping(value = "login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping(value = "/profile")
    @PreAuthorize("isAuthenticated()")
    public String profile(Model model) {
        return "profile";
    }

    @GetMapping(value = "about_us")
    public String aboutUs() {
        return "about_us";
    }
}