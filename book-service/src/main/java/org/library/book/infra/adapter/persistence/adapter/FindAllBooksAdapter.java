package org.library.book.infra.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.library.book.core.model.Book;
import org.library.book.core.port.out.FindAllBookPort;
import org.library.book.infra.adapter.persistence.mapper.BookMapper;
import org.library.book.infra.adapter.persistence.repository.BookJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllBooksAdapter implements FindAllBookPort {
    private final BookJpaRepository bookJpaRepository;
    private final BookMapper bookMapper;

    @Override
    public List<Book> findAll() {
        return bookJpaRepository.findAll()
                .stream()
                .map(bookMapper::toModel)
                .toList();
    }
}
