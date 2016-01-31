package org.playtech.test.model.sql.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Alexander on 31.01.2016.
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PrimaryKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Column(name = "providerId", nullable = false, length = 64)
    private String providerId;

    @Getter
    @Setter
    @Column(name = "id", nullable = false)
    private String id;

}
