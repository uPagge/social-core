package org.sadtech.social.core.repository.jpa;

import org.sadtech.social.core.domain.money.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO: Добавить описание интерфейса.
 *
 * @author upagge [27/07/2019]
 */
public interface AccountRepositoryJpa extends JpaRepository<Account, Integer> {

}
