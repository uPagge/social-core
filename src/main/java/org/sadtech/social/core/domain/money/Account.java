package org.sadtech.social.core.domain.money;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sadtech.social.core.utils.Description;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    @Description("Идентификатор счета")
    private Integer id;

    @NotNull
    @Column(name = "totalSum")
    @Description("Сумма к оплате")
    private Integer totalSum;

    @Column(name = "belongs_person_id")
    @Description("Идентификатор пользователя, которому выставлен счет")
    private Integer belongsPersonId;

    @Column(name = "extinguished_person_id")
    @Description("Идентификатор пользователя, который оплатил счет")
    private Integer extinguishedPersonId;

    @Column(name = "description")
    @Description("Описание платежа")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Description("Статус оплаты счета")
    private AccountStatus accountStatus;

}
