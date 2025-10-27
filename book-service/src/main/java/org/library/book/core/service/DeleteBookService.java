package org.library.book.core.service;

import lombok.RequiredArgsConstructor;
import org.library.book.core.model.Book;
import org.library.book.core.port.in.DeleteBookUseCase;
import org.library.book.core.port.out.DeleteBookPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteBookService implements DeleteBookUseCase {
    private final DeleteBookPort deleteBookPort;

    @Override
    public void delete(Book book) {
        deleteBookPort.delete(book);
    }
}
