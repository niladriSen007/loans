package com.niladri.loans.controller.loan;

import com.niladri.loans.dto.loan.LoanDto;
import com.niladri.loans.service.LoanService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/loans")
@RestController
@AllArgsConstructor
@Validated
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<LoanDto> applyLoan(@Valid @RequestParam String mobileNumber) {
        LoanDto newLoan = loanService.applyLoan(mobileNumber);
        return ResponseEntity.ok(newLoan);
    }

    @GetMapping("/get/{loanNumber}")
    public ResponseEntity<LoanDto> getLoan(@PathVariable String loanNumber) {
        LoanDto loan = loanService.getLoan(loanNumber);
        return ResponseEntity.ok(loan);
    }

    @PutMapping("/update/{loanNumber}")
    public ResponseEntity<LoanDto> updateLoan(@PathVariable String loanNumber, @Valid @RequestBody LoanDto loanDto) {
        LoanDto updatedLoan = loanService.updateLoan(loanNumber, loanDto);
        return ResponseEntity.ok(updatedLoan);
    }

    @DeleteMapping("/delete/{loanNumber}")
    public ResponseEntity<String> deleteLoan(@PathVariable String loanNumber) {
        loanService.deleteLoan(loanNumber);
        return ResponseEntity.ok("Loan deleted successfully");
    }

}
