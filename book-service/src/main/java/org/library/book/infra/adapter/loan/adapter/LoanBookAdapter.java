package org.library.book.infra.adapter.loan.adapter;

import lombok.RequiredArgsConstructor;
import org.library.book.core.model.Book;
import org.library.book.core.port.out.LoanBookPort;
import org.library.book.infra.adapter.loan.client.LoanServiceClient;
import org.library.book.infra.adapter.loan.dto.LoanCreateDTO;
import org.library.book.infra.adapter.loan.dto.LoanViewDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LoanBookAdapter implements LoanBookPort {
    private final LoanServiceClient loanServiceClient;

    @Override
    public UUID loan(Book book, LocalDate dueDate) {
        LoanCreateDTO loanCreateDTO = new LoanCreateDTO(book.getIsbn(), dueDate);
        LoanViewDTO loanViewDTO = loanServiceClient.createLoan(loanCreateDTO);

        return loanViewDTO.getId();
    }
}
