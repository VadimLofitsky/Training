package ru.lofitsky.training.book_store_example.service;

public class Endpoints {

    public static final String ROOT_MAPPING = "/";
	public static final String ROOT_TEMPLATE = "index";

    public static final String ADDNEWBOOK_MAPPING = "/addNewBook";
	public static final String ADDNEWBOOK_TEMPLATE = "addNewBook";
    public static final String ADDNEWBOOK_CANCEL = "/";

    public static final String SAVEBOOK_MAPPING = "/saveBook";
	public static final String SAVEBOOK_REDIRECT = "redirect:/";

    public static final String EDITBOOK_MAPPING = "/editBook";
	public static final String EDITBOOK_TEMPLATE = "editBook";
    public static final String EDITBOOK_CANCEL = "/";
    public static final String EDITBOOK_DELETE = "/deleteBook";

    public static final String DELETEBOOK_MAPPING = "/deleteBook";
	public static final String DELETEBOOK_REDIRECT = "redirect:/";
}