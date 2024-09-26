package com.niladri.loans.dto.loan;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class LoanDto {

    private Long loanId;
    @NotEmpty(message = "Mobile number is required")
    private String mobileNumber;
    @NotEmpty(message = "Loan number is required")
    private String loanNumber;
    @NotEmpty(message = "Loan type is required")
    private String loanType;
    @NotNull(message = "Total loan amount is required")
    private int totalLoan;
    @NotNull(message = "Amount paid is required")
    private int amountPaid;
    @NotNull(message = "Outstanding amount is required")
    private int outstandingAmount;
}
