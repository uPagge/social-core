package org.sadtech.bot.core.repository.impl;

import org.sadtech.bot.core.domain.money.Account;
import org.sadtech.bot.core.repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;

public class AccountRepositoryMap implements AccountRepository {

    private final Map<Integer, Account> saveMap = new HashMap<>();
    private Integer id = 0;

    @Override
    public Integer add(Account account) {
        account.setId(id);
        saveMap.put(id, account);
        return id++;
    }

    @Override
    public void edit(Integer accountId, Account account) {
        account.setId(accountId);
        saveMap.put(accountId, account);
    }

    @Override
    public Account findById(Integer accountId) {
        return saveMap.get(accountId);
    }
}
