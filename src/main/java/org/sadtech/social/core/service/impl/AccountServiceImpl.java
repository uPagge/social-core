package org.sadtech.social.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.sadtech.social.core.domain.money.Account;
import org.sadtech.social.core.domain.money.AccountStatus;
import org.sadtech.social.core.exception.PaymentException;
import org.sadtech.social.core.repository.AccountRepository;
import org.sadtech.social.core.service.AccountService;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

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
                throw new PaymentException("Неверная сумма");
            }
        } else {
            throw new PaymentException("Счет уже оплачен");
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
