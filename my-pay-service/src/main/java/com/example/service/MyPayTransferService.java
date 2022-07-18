package com.example.service;

import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.entity.TxnType;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MyPayTransferService implements TransferService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;


    @Transactional
    @Override
    public void transfer(double amount, String sourceAccNumber, String destinationAccNumber) {

        Account sourceAccount = accountRepository.findById(sourceAccNumber)
                .orElseThrow(() -> new IllegalStateException("Account not found"));

        Account destinationAccount = accountRepository.findById(destinationAccNumber)
                .orElseThrow(() -> new IllegalStateException("Account not found"));

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        Transaction debitTransaction = new Transaction();
        debitTransaction.setAmount(amount);
        debitTransaction.setDate(new Date());
        debitTransaction.setType(TxnType.DEBIT);
        debitTransaction.setAccount(sourceAccount);

        Transaction creditTransaction = new Transaction();
        creditTransaction.setAmount(amount);
        creditTransaction.setDate(new Date());
        creditTransaction.setType(TxnType.CREDIT);
        creditTransaction.setAccount(destinationAccount);

        transactionRepository.saveAll(List.of(debitTransaction, creditTransaction));

        accountRepository.save(sourceAccount);
        accountRepository.save(destinationAccount);

    }

}
