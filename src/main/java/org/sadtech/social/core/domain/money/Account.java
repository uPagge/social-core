package org.sadtech.social.core.domain.money;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sadtech.social.core.utils.Description;

/**
 * Сущность, которая отвечает за выставленный пользователю счет.
 *
 * @author upagge [08/07/2019]
 */
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Description("Идентификатор счета")
    private Integer id;

    @Description("Сумма к оплате")
    private Integer totalSum;

    @Description("Идентификатор пользователя, которому выставлен счет")
    private Integer belongsPersonId;

    @Description("Идентификатор пользователя, который оплатил счет")
    private Integer extinguishedPersonId;

    @Description("Описание платежа")
    private String description;

    @Description("Статус оплаты счета")
    private AccountStatus accountStatus;

}
