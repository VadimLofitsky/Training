package ru.lofitsky.training.book_store_example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.lofitsky.training.book_store_example.model.Book;

import java.util.List;

public interface BookServiceInterface {

    // Commons
    Book getBookById(Long id);
    Book getBookByTitle(String title);
    List<Book> getAllBooks();

    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBook(Long id);

    // Pageables
    Page<Book> getAllBooks(Pageable pageable);
}
