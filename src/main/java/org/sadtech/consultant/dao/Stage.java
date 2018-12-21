package org.sadtech.consultant.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Stage {

    @Id
    private long id;
    private String text;
    private String wordKeys;

}
