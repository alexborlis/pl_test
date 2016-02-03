package net.smartrss.admin.model.entity.filter.location;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.smartrss.admin.model.entity.PrimaryKey;

/**
 * Created by Alexander on 03.02.2016.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SubRegionEntity {

    @Getter
    @Setter
    @EmbeddedId
    private PrimaryKey primaryKey;

    @Getter
    @Setter
    @Column(name = "created", nullable = false)
    private Long created = System.currentTimeMillis();

    @Getter
    @Setter
    @Column(name = "updated", nullable = false)
    private Long updated = System.currentTimeMillis();

}
