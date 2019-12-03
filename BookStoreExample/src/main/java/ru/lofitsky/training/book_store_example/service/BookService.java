package ru.lofitsky.training.book_store_example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lofitsky.training.book_store_example.model.Book;
import ru.lofitsky.training.book_store_example.repository.BookRepository;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    private BookRepository bookRepository;

    @Autowired
    public void setRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}