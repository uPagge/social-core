package org.sadtech.bot.core.service.impl;

import org.sadtech.bot.core.domain.money.Account;
import org.sadtech.bot.core.domain.money.AccountStatus;
import org.sadtech.bot.core.exception.PaymentException;
import org.sadtech.bot.core.repository.AccountRepository;
import org.sadtech.bot.core.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Integer add(Account account) {
        account.setAccountStatus(AccountStatus.EXPOSED);
        return accountRepository.add(account);
    }

    @Override
    public Boolean pay(Integer accountId, Integer extinguishedPersonId, Double sum) {
        Account account = accountRepository.findById(accountId);
        if (account.getTotalSum().equals(sum)) {
            account.setAccountStatus(AccountStatus.CLOSED);
            account.setExtinguishedPersonId(extinguishedPersonId);
            accountRepository.edit(accountId, account);
        } else {
            account.setAccountStatus(AccountStatus.EXCEPTION);
            accountRepository.edit(accountId, account);
            throw new PaymentException(2, "Неверная сумма");
        }
        return true;
    }

    @Override
    public Boolean paymentVerification(Integer accountId) {
        return AccountStatus.CLOSED.equals(accountRepository.findById(accountId).getAccountStatus());
    }
}
