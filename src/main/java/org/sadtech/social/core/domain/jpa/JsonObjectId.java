package org.sadtech.social.core.domain.jpa;

import com.google.gson.JsonObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.sadtech.social.core.domain.BasicEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TODO: Добавить описание класса.
 *
 * @author upagge [28/07/2019]
 */
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "event")
public class JsonObjectId extends BasicEntity {

    @Column(name = "json")
    @NonNull
    private JsonObject jsonObject;

}
