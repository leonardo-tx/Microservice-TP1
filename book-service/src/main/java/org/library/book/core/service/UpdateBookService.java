package org.library.book.core.service;

import lombok.RequiredArgsConstructor;
import org.library.book.core.exception.NotFoundException;
import org.library.book.core.model.Book;
import org.library.book.core.port.in.UpdateBookUseCase;
import org.library.book.core.port.out.FindBookPort;
import org.library.book.core.port.out.SaveBookPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateBookService implements UpdateBookUseCase {
    private final SaveBookPort saveBookPort;
    private final FindBookPort findBookPort;

    @Override
    public Book update(Book book) {
        Optional<Book> optionalBook = findBookPort.findByIsbn(book.getIsbn());
        if (optionalBook.isEmpty()) {
            throw new NotFoundException("book.not.found", "The book to update was not found.");
        }
        return saveBookPort.save(book);
    }
}
