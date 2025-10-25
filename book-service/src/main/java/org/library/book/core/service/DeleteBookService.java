package org.library.book.core.service;

import org.library.book.core.model.Book;
import org.library.book.core.port.in.DeleteBookUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteBookService implements DeleteBookUseCase {
    @Override
    public void delete(Book book) {

    }
}
