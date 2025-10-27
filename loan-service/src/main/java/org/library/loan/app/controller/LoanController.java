package org.library.loan.app.controller;

import lombok.RequiredArgsConstructor;
import org.library.loan.app.request.dto.LoanCreateDTO;
import org.library.loan.app.request.mapper.LoanCreateMapper;
import org.library.loan.app.response.dto.ApiResponse;
import org.library.loan.app.response.dto.LoanViewDTO;
import org.library.loan.app.response.mapper.LoanViewMapper;
import org.library.loan.core.model.Loan;
import org.library.loan.core.port.in.LoanFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {
    private final LoanFacade loanFacade;
    private final LoanViewMapper loanViewMapper;
    private final LoanCreateMapper loanCreateMapper;

    @GetMapping("/overdue")
    public ResponseEntity<ApiResponse<List<LoanViewDTO>>> getAllOverdue(@RequestParam("productType") String productType) {
        List<LoanViewDTO> loansViews = loanFacade.getAllOverdue(productType)
                .stream()
                .map(loanViewMapper::toEntity)
                .toList();
        return ApiResponse.success(loansViews).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{productType}/{id}")
    public ResponseEntity<ApiResponse<LoanViewDTO>> getLoanById(
            @PathVariable("productType") String productType,
            @PathVariable("id") UUID id
    ) {
        Loan loan = loanFacade.getLoanById(productType, id);
        LoanViewDTO loanView = loanViewMapper.toEntity(loan);

        return ApiResponse.success(loanView).createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<LoanViewDTO>> createLoan(@RequestBody LoanCreateDTO form) {
        Loan loan = loanCreateMapper.toModel(form);
        Loan createdLoan = loanFacade.create(loan);
        LoanViewDTO loanView = loanViewMapper.toEntity(createdLoan);

        return ApiResponse.success(loanView).createResponse(HttpStatus.CREATED);
    }

    @PostMapping("/{productType}/{id}/close")
    public ResponseEntity<ApiResponse<LoanViewDTO>> closeLoan(
            @PathVariable("productType") String productType,
            @PathVariable("id") UUID id
    ) {
        Loan loan = loanFacade.closeById(productType, id);
        LoanViewDTO loanView = loanViewMapper.toEntity(loan);

        return ApiResponse.success(loanView).createResponse(HttpStatus.OK);
    }
}
