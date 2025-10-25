package org.library.book.core.service;

import lombok.RequiredArgsConstructor;
import org.library.book.core.exception.NotFoundException;
import org.library.book.core.model.Book;
import org.library.book.core.port.in.GetBookUseCase;
import org.library.book.core.port.out.FindBookPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetBookService implements GetBookUseCase {
    private final FindBookPort findBookPort;

    @Override
    public Book getByIsbn(String isbn) {
        return findBookPort.findByIsbn(isbn)
                .orElseThrow(() -> new NotFoundException("book.not.found", "The book was not found."));
    }
}
