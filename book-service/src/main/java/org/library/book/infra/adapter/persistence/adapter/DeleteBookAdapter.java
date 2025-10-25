package org.library.book.infra.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.library.book.core.model.Book;
import org.library.book.core.port.out.DeleteBookPort;
import org.library.book.infra.adapter.persistence.repository.BookJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteBookAdapter implements DeleteBookPort {
    private final BookJpaRepository bookJpaRepository;

    @Override
    public void delete(Book book) {
        bookJpaRepository.deleteById(book.getIsbn());
    }
}
