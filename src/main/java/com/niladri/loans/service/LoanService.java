package com.niladri.loans.service;

import com.niladri.loans.constants.LoanConstants;
import com.niladri.loans.dto.loan.LoanDto;
import com.niladri.loans.exception.LoanAlreadyExists;
import com.niladri.loans.exception.ResourceNotFound;
import com.niladri.loans.mapper.LoanMapper;
import com.niladri.loans.model.loan.LoanModel;
import com.niladri.loans.repository.loan.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanService implements LoanServiceInterface {

    private LoanRepository loanRepo;

    @Override
    public LoanDto applyLoan(String mobileNumber) {
        Optional<LoanModel> existingLoan = Optional.ofNullable(loanRepo.findByMobileNumber(mobileNumber));
        if (existingLoan.isPresent()) {
            throw new LoanAlreadyExists("Loan already exists for mobile number: " + mobileNumber);
        }
        LoanModel newLoan = createNewLoan(mobileNumber);
        loanRepo.save(newLoan);
        return LoanMapper.toLoanDto(newLoan);
    }

    @Override
    public LoanDto getLoan(String loanNumber) {
        Optional<LoanModel> loan = loanRepo.findByLoanNumber(loanNumber);
        if(loan.isEmpty()){
            throw new ResourceNotFound("Loan","loan number",loanNumber);
        }
        return LoanMapper.toLoanDto(loan.get());
    }

    @Override
    public LoanDto updateLoan(String loanNumber, LoanDto loanDto) {
        Optional<LoanModel> loan = loanRepo.findByLoanNumber(loanNumber);
        if(loan.isEmpty()){
            throw new ResourceNotFound("Loan","loan number",loanNumber);
        }
        LoanModel updatedLoan = loanRepo.save(LoanMapper.toLoanModel(loanDto));
        return LoanMapper.toLoanDto(updatedLoan);
    }

    @Override
    public void deleteLoan(String loanNumber) {
        Optional<LoanModel> loan = loanRepo.findByLoanNumber(loanNumber);
        if(loan.isEmpty()){
            throw new ResourceNotFound("Loan","loan number",loanNumber);
        }
        loanRepo.delete(loan.get());
    }

    private LoanModel createNewLoan(String mobileNumber) {
        LoanModel newLoan = new LoanModel();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoanConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }
}
