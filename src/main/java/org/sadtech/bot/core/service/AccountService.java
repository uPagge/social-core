package org.sadtech.bot.core.service;

import org.sadtech.bot.core.domain.money.Account;

public interface AccountService {

    Integer add(Account account);

    Boolean pay(Integer accountId, Integer extinguishedPersonId, Double sum);

    Boolean paymentVerification(Integer accountId);

}
