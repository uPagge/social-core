package org.sadtech.bot.core.repository;

import org.sadtech.bot.core.domain.money.Account;

public interface AccountRepository {

    Integer add(Account account);

    void edit(Integer accountId, Account account);

    Account findById(Integer accountId);

}
