package org.sadtech.social.core.repository.impl.local;

import org.sadtech.social.core.domain.money.Account;
import org.sadtech.social.core.exception.AccessException;
import org.sadtech.social.core.exception.NotFoundException;
import org.sadtech.social.core.exception.PaymentException;
import org.sadtech.social.core.repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccountRepositoryMap implements AccountRepository {

    private final Map<Integer, Account> saveMap = new HashMap<>();
    private Integer id = 1;

    @Override
    public Integer add(Account account) {
        if (check(account.getId())) {
            account.setId(id);
            saveMap.put(id, account);
            return id++;
        } else {
            throw new AccessException("Счет " + account.getId() + " уже существует");
        }

    }

    @Override
    public void edit(Integer accountId, Account account) {
        if (check(id)) {
            account.setId(accountId);
            saveMap.put(accountId, account);
        } else {
            throw new NotFoundException("Счет " + accountId + " не найден");
        }
    }

    @Override
    public Account findById(Integer accountId) {
        return Optional.ofNullable(saveMap.get(accountId)).orElseThrow(() -> new PaymentException("Счет " + accountId + " не найден"));
    }

    private boolean check(Integer id) {
        return !saveMap.containsKey(id);
    }
}
