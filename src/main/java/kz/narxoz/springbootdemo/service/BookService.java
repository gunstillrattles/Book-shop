package kz.narxoz.springbootdemo.service;

import kz.narxoz.springbootdemo.entity.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> findAllBooks();
    Book findOneById(Long id);
    void deleteBook(Long id);
}