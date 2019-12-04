package ru.lofitsky.training.book_store_example.service;

import ru.lofitsky.training.book_store_example.model.Book;

import java.util.List;

public interface BookServiceInterface {
    Book getBookById(Long id);
    Book getBookByTitle(String title);
    List<Book> getAll();

    void saveBook(Book book);
    void deleteBook(Long id);
}
