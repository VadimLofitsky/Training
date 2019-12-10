package ru.lofitsky.training.book_store_example.service;

public class Endpoints {

    public static final String ROOT_REQUEST = "/";
	public static final String ROOT_RESPONSE = "index";

    public static final String ADDNEWBOOK_REQUEST = "/addNewBook";
	public static final String ADDNEWBOOK_RESPONSE = "addNewBook";
	public static final String ADDNEWBOOK_TEMPLATE = "addNewBook";
    public static final String ADDNEWBOOK_CANCEL = "/";

    public static final String SAVEBOOK_REQUEST = "/saveBook";
	public static final String SAVEBOOK_RESPONSE = "redirect:/";

    public static final String EDITBOOK_REQUEST = "/editBook";
	public static final String EDITBOOK_RESPONSE = "editBook";
	public static final String EDITBOOK_TEMPLATE = "editBook";
    public static final String EDITBOOK_CANCEL = "/";
    public static final String EDITBOOK_DELETE = "/deleteBook";

    public static final String DELETEBOOK_REQUEST = "/deleteBook";
	public static final String DELETEBOOK_RESPONSE = "redirect:/";
}