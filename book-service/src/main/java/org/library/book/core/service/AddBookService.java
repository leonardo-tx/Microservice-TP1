package org.library.book.core.service;

import lombok.RequiredArgsConstructor;
import org.library.book.core.exception.ConflictException;
import org.library.book.core.model.Book;
import org.library.book.core.port.in.AddBookUseCase;
import org.library.book.core.port.out.FindBookPort;
import org.library.book.core.port.out.SaveBookPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddBookService implements AddBookUseCase {
    private final SaveBookPort saveBookPort;
    private final FindBookPort findBookPort;

    @Override
    public Book add(Book book) {
        Optional<Book> optionalBook = findBookPort.findByIsbn(book.getIsbn());
        if (optionalBook.isPresent()) {
            throw new ConflictException("book.isbn.conflict", "A book already exists with the specified ISBN.");
        }
        return saveBookPort.save(book);
    }
}
