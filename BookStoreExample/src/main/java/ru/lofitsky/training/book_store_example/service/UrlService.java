package ru.lofitsky.training.book_store_example.service;

import org.springframework.stereotype.Service;

@Service
public class UrlService {

    // at index template
    // Add new book button
    public String getAddNewBookActionURL() {
        return Endpoints.ADDNEWBOOK_REQUEST;
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
    public String getEditBookButtonURL(int bookId) {
        return Endpoints.EDITBOOK_REQUEST + "?id=" + bookId;
    }



    // at addNewBook template
    // editing form action URL
    public String getAddNewBookFormSubmitActionURL() {
        return Endpoints.SAVEBOOK_REQUEST + "?id=-1";
    }

    // 'Cancel' button form action
    public String getAddNewBookFormCancelActionURL() {
        return Endpoints.ADDNEWBOOK_CANCEL;
    }



    // at editBook template
    // editing form action URL
    public String getEditBookFormSubmitActionURL(int id) {
        return Endpoints.SAVEBOOK_REQUEST + "?id=" + id;
    }

    // 'Cancel' button form action
    public String getEditBookFormCancelActionURL() {
        return Endpoints.EDITBOOK_CANCEL;
    }

    // 'Delete' button form action
    public String getEditBookFormDeleteActionURL(int id) {
        return Endpoints.EDITBOOK_DELETE + "?id=" + id;
    }
}