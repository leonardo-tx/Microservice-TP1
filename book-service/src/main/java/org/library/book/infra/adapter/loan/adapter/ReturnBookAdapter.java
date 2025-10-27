package org.library.book.infra.adapter.loan.adapter;

import lombok.RequiredArgsConstructor;
import org.library.book.core.port.out.ReturnBookPort;
import org.library.book.infra.adapter.loan.client.LoanServiceClient;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.library.book.infra.adapter.loan.constant.LoanConstants.PRODUCT_TYPE_NAME;

@Component
@RequiredArgsConstructor
public class ReturnBookAdapter implements ReturnBookPort {
    private final LoanServiceClient loanServiceClient;

    @Override
    public boolean returnBook(UUID loanId) {
        try {
            loanServiceClient.closeLoan(PRODUCT_TYPE_NAME, loanId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
