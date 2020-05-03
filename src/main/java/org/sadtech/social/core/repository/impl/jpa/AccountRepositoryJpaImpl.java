package org.sadtech.social.core.repository.impl.jpa;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.sadtech.social.core.domain.money.Account;
import org.sadtech.social.core.repository.AccountRepository;
import org.sadtech.social.core.repository.jpa.AccountRepositoryJpa;

import java.util.Optional;

/**
 * @author upagge [27/07/2019]
 */
@RequiredArgsConstructor
public class AccountRepositoryJpaImpl implements AccountRepository {

    private final AccountRepositoryJpa accountRepositoryJpa;

    @Override
    public Account save(@NonNull Account account) {
        return accountRepositoryJpa.save(account);
    }

    @Override
    public Optional<Account> findById(@NonNull Integer accountId) {
        return accountRepositoryJpa.findById(accountId);
    }

    @Override
    public boolean existsById(Integer id) {
        return accountRepositoryJpa.existsById(id);
    }

}
