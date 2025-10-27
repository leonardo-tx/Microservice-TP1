package org.library.book.infra.adapter.loan.client;

import org.library.book.infra.adapter.loan.dto.LoanServiceApiResponse;
import org.library.book.infra.adapter.loan.dto.LoanCreateDTO;
import org.library.book.infra.adapter.loan.dto.LoanViewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "loan-service")
public interface LoanServiceClient {
    @GetMapping("/loan")
    LoanServiceApiResponse<List<LoanViewDTO>> getAllOverdue(@RequestParam("productType") String productType);

    @GetMapping("/loan/{productType}/{id}")
    LoanServiceApiResponse<LoanViewDTO> getLoanById(
            @PathVariable("productType") String productType,
            @PathVariable("id") UUID id
    );

    @PostMapping("/loan")
    LoanServiceApiResponse<LoanViewDTO> createLoan(@RequestBody LoanCreateDTO form);

    @PostMapping("/loan/{productType}/{id}/close")
    LoanServiceApiResponse<LoanViewDTO> closeLoan(
            @PathVariable("productType") String productType,
            @PathVariable("id") UUID id
    );
}
