package com.niladri.loans.mapper;

import com.niladri.loans.dto.loan.LoanDto;
import com.niladri.loans.model.loan.LoanModel;

public class LoanMapper {
    public static LoanDto toLoanDto(LoanModel loanModel) {
        LoanDto loanDto = new LoanDto();
        loanDto.setLoanId(loanModel.getLoanId());
        loanDto.setMobileNumber(loanModel.getMobileNumber());
        loanDto.setLoanNumber(loanModel.getLoanNumber());
        loanDto.setLoanType(loanModel.getLoanType());
        loanDto.setTotalLoan(loanModel.getTotalLoan());
        loanDto.setAmountPaid(loanModel.getAmountPaid());
        loanDto.setOutstandingAmount(loanModel.getOutstandingAmount());
        return loanDto;
    }

    public static LoanModel toLoanModel(LoanDto loanDto) {
        LoanModel loanModel = new LoanModel();
        loanModel.setLoanId(loanDto.getLoanId());
        loanModel.setMobileNumber(loanDto.getMobileNumber());
        loanModel.setLoanNumber(loanDto.getLoanNumber());
        loanModel.setLoanType(loanDto.getLoanType());
        loanModel.setTotalLoan(loanDto.getTotalLoan());
        loanModel.setAmountPaid(loanDto.getAmountPaid());
        loanModel.setOutstandingAmount(loanDto.getOutstandingAmount());
        return loanModel;
    }
}
