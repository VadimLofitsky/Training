package ru.lofitsky.training.book_store_example.service;

public enum Endpoints {

    ROOT("/", "index"),
    ADDNEWBOOK("/addNewBook", "addNewBook"),
    SAVEBOOK("/saveBook", "redirect:/"),
    EDITBOOK("/editBook", "editBook"),
    DELETEBOOK("/deleteBook", "redirect:/");

    public final String request;
    public final String response;

    Endpoints(String request, String response) {
        this.request = request;
        this.response = response;
    }
}