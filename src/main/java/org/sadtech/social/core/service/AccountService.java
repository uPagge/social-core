package org.sadtech.social.core.service;

import org.sadtech.social.core.domain.money.Account;

/**
 * Интерфейс сервиса по работе с оплатой.
 *
 * @author upagge [08/07/2019]
 */
public interface AccountService {

    Integer add(Account account);

    /**
     * Метод для оплаты счета
     *
     * @param accountId            Идентификатор счета
     * @param extinguishedPersonId Идентификатор пользователя, который внес оплату
     * @param sum                  Сумма оплаты
     * @return true - в случае успешной оплаты
     */
    Boolean pay(Integer accountId, Integer extinguishedPersonId, Integer sum);

    /**
     * Проверка оплаты счета
     *
     * @param accountId Идентификатор счета
     * @return true - если счет оплачен
     */
    Boolean paymentVerification(Integer accountId);

}
