package ru.lofitsky.training.BookStoreExample.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @RequestMapping("/")
    public String greeting() {
        return "Hello, world!";
    }
}