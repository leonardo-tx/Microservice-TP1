package org.library.book.core.service;

import lombok.RequiredArgsConstructor;
import org.library.book.core.model.Book;
import org.library.book.core.port.in.GetAllBooksUseCase;
import org.library.book.core.port.out.FindAllBookPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllBooksService implements GetAllBooksUseCase {
    private final FindAllBookPort findAllBookPort;

    @Override
    public List<Book> getAll() {
        return findAllBookPort.findAll();
    }
}
