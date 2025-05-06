package com.niladri.loans.repository.loan;

import com.niladri.loans.model.loan.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<LoanModel,Long> {
    LoanModel findByMobileNumber(String mobileNumber);

    Optional<LoanModel> findByLoanNumber(String l);
}
