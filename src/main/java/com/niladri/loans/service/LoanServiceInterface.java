package com.niladri.loans.service;

import com.niladri.loans.dto.loan.LoanDto;
import jakarta.validation.Valid;

public interface LoanServiceInterface {
    LoanDto applyLoan(@Valid String mobileNumber);

    LoanDto getLoan(String loanNumber);

    LoanDto updateLoan(String loanNumber, @Valid LoanDto loanDto);

    void deleteLoan(String loanNumber);
}
