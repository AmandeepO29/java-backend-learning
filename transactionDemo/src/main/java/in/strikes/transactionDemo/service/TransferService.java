package in.strikes.transactionDemo.service;

import in.strikes.transactionDemo.entity.Account;
import in.strikes.transactionDemo.entity.TransferRecord;
import in.strikes.transactionDemo.repository.AccountRepository;
import in.strikes.transactionDemo.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {

    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public TransferService(AccountRepository accountRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void transfer(Long fromAccountId,
                         Long toAccountId,
                         BigDecimal amount){
        Account fromAccount=accountRepository.findById(fromAccountId)
                .orElseThrow(()-> new RuntimeException("User not found"));

        Account toAccount=accountRepository.findById(toAccountId)
                .orElseThrow(()-> new RuntimeException("User not found"));

        fromAccount.debitAmount(amount);
        //accountRepository.saveAndFlush(fromAccount);

        toAccount.creditAmount(amount);
        //accountRepository.saveAndFlush(toAccount);

        transferRepository.save(new TransferRecord(
                fromAccountId,toAccountId,amount, LocalDate.now()
        ));
        //transferRepository.flush();

        //throw new RuntimeException("some error occured");
        // agar transactional mein exception aayi to sb rollback ho jayega,chahe vo saved ho ya unsaved
        // iska mtlb agar transactional mein exception aa gyi to mtlb vo method kuch changes nhi kr payega
        // sb revert back ho jayenge
    }
}
