package ru.lofitsky.training.book_store_example.service;

import org.springframework.stereotype.Service;

@Service
public class UrlService {
    // at index template
    // Add new book button
    public String getAddNewBookActionURL() {
        return "/" + Endpoints.ADDNEWBOOK_TEMPLATE;
    }

    // 'Prev'- and 'next'-page buttons
    public String getPrevPageURL(boolean hasPrevPage, int currentPageNumber) {
        return hasPrevPage ? "/?page=" + (currentPageNumber - 1) : "";
    }
    public String getNextPageURL(boolean hasNextPage, int currentPageNumber) {
        return hasNextPage ? "/?page=" + (currentPageNumber + 1) : "";
    }

    // Pages list
    public String getUrlForPage(int pageNumber, int currentPageNumber) {
        return pageNumber != currentPageNumber+1 ? "/?page=" + (pageNumber-1) : "";
    }

    // 'Edit book' button
    public String getEditBookURL(int bookId) {
        // editBook(id=${book.id})
        return "/" + Endpoints.EDITBOOK_TEMPLATE + "?id=" + bookId;
    }

    // at addNewBook template
    // editing form action URL
    public String getAddNewBookFormActionURL() {
        return Endpoints.SAVEBOOK_REQUEST + "?id=-1";
    }

    // 'Cancel' button form action
    public String getAddNewBookFormCancelActionURL() {
        return Endpoints.ADDNEWBOOK_CANCEL;
    }
}