package org.library.book.infra.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.library.book.core.model.Book;
import org.library.book.core.port.out.FindBookPort;
import org.library.book.infra.adapter.persistence.mapper.BookMapper;
import org.library.book.infra.adapter.persistence.repository.BookJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindBookAdapter implements FindBookPort {
    private final BookJpaRepository bookJpaRepository;
    private final BookMapper bookMapper;

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookJpaRepository.findById(isbn)
                .map(bookMapper::toModel);
    }
}
