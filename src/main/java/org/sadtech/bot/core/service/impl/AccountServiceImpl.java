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
    public Boolean pay(Integer accountId, Integer extinguishedPersonId, Integer sum) {
        Account account = accountRepository.findById(accountId);
        if (validStatus(account.getAccountStatus())) {
            if (account.getTotalSum().equals(sum)) {
                account.setAccountStatus(AccountStatus.CLOSED);
                account.setExtinguishedPersonId(extinguishedPersonId);
                accountRepository.edit(accountId, account);
            } else {
                account.setAccountStatus(AccountStatus.EXCEPTION);
                accountRepository.edit(accountId, account);
                throw new PaymentException(2, "Неверная сумма");
            }
        } else {
            throw new PaymentException(3, "Счет уже оплачен");
        }
        return true;
    }

    private boolean validStatus(AccountStatus accountStatus) {
        return AccountStatus.EXCEPTION.equals(accountStatus) || AccountStatus.EXPOSED.equals(accountStatus);
    }

    @Override
    public Boolean paymentVerification(Integer accountId) {
        return AccountStatus.CLOSED.equals(accountRepository.findById(accountId).getAccountStatus());
    }
}
