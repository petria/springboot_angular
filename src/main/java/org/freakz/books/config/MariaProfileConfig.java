package org.freakz.books.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freakz.books.jpa.entity.Book;
import org.freakz.books.jpa.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Component
@Profile("mariadb")
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MariaProfileConfig implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        log.debug("Populate DB!");
        generateDB();
    }

    private void generateDB() {
        if (bookRepository.findAll().size() == 0) {
            log.debug("Add some entries to empty DB!");
            bookRepository.save(createBook("title1", "auth1", "desc1"));
            bookRepository.save(createBook("title2", "auth2", "desc2"));
            bookRepository.save(createBook("title3", "auth3", "desc3"));
        } else {
            log.debug("Skip DB populate!");
        }
    }

    private Book createBook(String title, String auth, String desc) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(auth);
        book.setDescription(desc);
        return book;
    }

}
