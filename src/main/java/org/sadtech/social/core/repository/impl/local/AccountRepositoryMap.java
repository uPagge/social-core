package org.sadtech.social.core.repository.impl.local;

import lombok.NonNull;
import org.sadtech.social.core.domain.money.Account;
import org.sadtech.social.core.repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccountRepositoryMap implements AccountRepository {

    private final Map<Integer, Account> saveMap = new HashMap<>();
    private int id = 1;

    @Override
    public Account save(@NonNull Account account) {
        if (existsById(account.getId())) {
            account.setId(id);
            return saveMap.put(id++, account);
        } else {
            return saveMap.put(id, account);
        }
    }

    @Override
    public Optional<Account> findById(@NonNull Integer accountId) {
        return Optional.ofNullable(saveMap.get(accountId));
    }

    public boolean existsById(Integer id) {
        return !saveMap.containsKey(id);
    }

}
