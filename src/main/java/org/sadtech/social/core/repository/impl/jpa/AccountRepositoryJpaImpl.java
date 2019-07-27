package org.sadtech.social.core.repository.impl.jpa;

import org.sadtech.social.core.domain.money.Account;
import org.sadtech.social.core.repository.AccountRepository;
import org.sadtech.social.core.repository.jpa.AccountRepositoryJpa;
import org.springframework.stereotype.Repository;

/**
 * TODO: Добавить описание класса.
 *
 * @author upagge [27/07/2019]
 */
@Repository
public class AccountRepositoryJpaImpl implements AccountRepository {

    private final AccountRepositoryJpa accountRepositoryJpa;

    public AccountRepositoryJpaImpl(AccountRepositoryJpa accountRepositoryJpa) {
        this.accountRepositoryJpa = accountRepositoryJpa;
    }

    @Override
    public Integer add(Account account) {
        return accountRepositoryJpa.saveAndFlush(account).getId();
    }

    @Override
    public void edit(Integer accountId, Account account) {
        account.setId(accountId);
        accountRepositoryJpa.saveAndFlush(account);
    }

    @Override
    public Account findById(Integer accountId) {
        return accountRepositoryJpa.getOne(accountId);
    }
}
