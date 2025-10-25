package org.library.book.infra.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.library.book.core.model.Book;
import org.library.book.core.port.out.SaveBookPort;
import org.library.book.infra.adapter.persistence.entity.BookJpa;
import org.library.book.infra.adapter.persistence.mapper.BookMapper;
import org.library.book.infra.adapter.persistence.repository.BookJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveBookAdapter implements SaveBookPort {
    private final BookJpaRepository bookJpaRepository;
    private final BookMapper bookMapper;

    @Override
    public Book save(Book book) {
        BookJpa entity = bookMapper.toEntity(book);
        BookJpa savedEntity = bookJpaRepository.save(entity);

        return bookMapper.toModel(savedEntity);
    }
}
