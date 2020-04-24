package org.freakz.books.resource;

import org.freakz.books.model.Book;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BooksResource {

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = GET, value = "/api/books")
    @ResponseBody
    List<Book> getBooks() {
        Book b1 = Book.builder().id(1).title("title1").description("desc1").build();
        Book b2 = Book.builder().id(2).title("title2").description("desc2").build();
        Book b3 = Book.builder().id(3).title("title3").description("desc3").build();
        List<Book> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        return list;
    }
}
