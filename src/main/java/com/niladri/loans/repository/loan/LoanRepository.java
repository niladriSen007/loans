package com.niladri.loans.repository.loan;

import com.niladri.loans.model.loan.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<LoanModel,Long> {
    LoanModel findByMobileNumber(String mobileNumber);

    Optional<LoanModel> findByLoanNumber(String l);
}
