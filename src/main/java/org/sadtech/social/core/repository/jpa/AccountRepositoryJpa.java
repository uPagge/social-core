package org.sadtech.social.core.repository.jpa;

import org.sadtech.social.core.domain.money.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author upagge [27/07/2019]
 */
@Repository
public interface AccountRepositoryJpa extends JpaRepository<Account, Integer> {

}
