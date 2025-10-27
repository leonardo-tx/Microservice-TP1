package org.library.book.infra.adapter.loan.adapter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.library.book.core.exception.ExternalException;
import org.library.book.core.model.Book;
import org.library.book.core.port.out.LoanBookPort;
import org.library.book.infra.adapter.loan.client.LoanServiceClient;
import org.library.book.infra.adapter.loan.dto.LoanServiceApiResponse;
import org.library.book.infra.adapter.loan.dto.LoanCreateDTO;
import org.library.book.infra.adapter.loan.dto.LoanViewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

import static org.library.book.infra.adapter.loan.constant.LoanConstants.PRODUCT_TYPE_NAME;

@Component
@RequiredArgsConstructor
public class LoanBookAdapter implements LoanBookPort {
    private final LoanServiceClient loanServiceClient;
    private final ObjectMapper objectMapper;

    @Override
    public UUID loan(Book book, LocalDate dueDate) {
        LoanCreateDTO loanCreateDTO = new LoanCreateDTO(book.getIsbn(), PRODUCT_TYPE_NAME, dueDate);
        try {
            try {
                LoanServiceApiResponse<LoanViewDTO> response = loanServiceClient.createLoan(loanCreateDTO);
                return response.getResult().getId();
            } catch (FeignException e) {
                LoanServiceApiResponse<Object> errorResponse = objectMapper.readValue(
                        e.contentUTF8(),
                        new TypeReference<>() {}
                );
                throw new ExternalException(
                        errorResponse.getError().getCode(),
                        errorResponse.getError().getMessage(),
                        HttpStatus.valueOf(e.status())
                );
            }
        } catch (ExternalException e) {
            throw e;
        } catch (Exception e) {
            throw new ExternalException(
                    "service.unavailable",
                    "Unable to communicate with loan service.",
                    HttpStatus.SERVICE_UNAVAILABLE
            );
        }
    }
}
