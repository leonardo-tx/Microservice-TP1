package org.library.book.infra.adapter.loan.adapter;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.library.book.core.exception.ExternalException;
import org.library.book.core.port.out.FindProductIdFromLoanPort;
import org.library.book.infra.adapter.loan.client.LoanServiceClient;
import org.library.book.infra.adapter.loan.dto.LoanServiceApiResponse;
import org.library.book.infra.adapter.loan.dto.LoanViewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

import static org.library.book.infra.adapter.loan.constant.LoanConstants.PRODUCT_TYPE_NAME;

@Component
@RequiredArgsConstructor
public class FindProductIdFromLoanAdapter implements FindProductIdFromLoanPort {
    private final LoanServiceClient loanServiceClient;

    @Override
    public Optional<String> findProductIdByLoanId(UUID loanId) {
        try {
            LoanServiceApiResponse<LoanViewDTO> response = loanServiceClient.getLoanById(PRODUCT_TYPE_NAME, loanId);
            return Optional.of(response.getResult().getProductId());
        } catch (FeignException e) {
            return Optional.empty();
        } catch (Exception e) {
            throw new ExternalException(
                    "service.unavailable",
                    "Unable to communicate with loan service.",
                    HttpStatus.SERVICE_UNAVAILABLE
            );
        }
    }
}
