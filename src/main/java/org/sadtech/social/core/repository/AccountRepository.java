package org.sadtech.social.core.repository;

import org.sadtech.social.core.domain.money.Account;

/**
 * Репозиторий для взаимодействия с хранилищем счетов {@link Account}.
 *
 * @author upagge [08/07/2019]
 */
public interface AccountRepository {

    Integer add(Account account);

    void edit(Integer accountId, Account account);

    Account findById(Integer accountId);

}
