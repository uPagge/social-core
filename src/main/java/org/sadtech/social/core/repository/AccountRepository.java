package org.sadtech.social.core.repository;

import lombok.NonNull;
import org.sadtech.social.core.domain.money.Account;

import java.util.Optional;

/**
 * Репозиторий для взаимодействия с хранилищем счетов {@link Account}.
 *
 * @author upagge [08/07/2019]
 */
public interface AccountRepository {

    Account save(@NonNull Account account);

    Optional<Account> findById(@NonNull Integer accountId);

    boolean existsById(Integer id);

}
