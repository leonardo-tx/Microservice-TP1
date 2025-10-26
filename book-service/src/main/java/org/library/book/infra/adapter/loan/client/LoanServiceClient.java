package org.library.book.infra.adapter.loan.client;

import org.library.book.infra.adapter.loan.dto.LoanServiceApiResponse;
import org.library.book.infra.adapter.loan.dto.LoanCreateDTO;
import org.library.book.infra.adapter.loan.dto.LoanViewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "loan-service")
public interface LoanServiceClient {
    @PostMapping("/loan")
    LoanServiceApiResponse<LoanViewDTO> createLoan(@RequestBody LoanCreateDTO form);
}
