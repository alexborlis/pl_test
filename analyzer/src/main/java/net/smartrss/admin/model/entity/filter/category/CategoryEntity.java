package net.smartrss.admin.model.entity.filter.category;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.smartrss.admin.model.entity.PrimaryKey;

/**
 * Created by Alexander on 02.02.2016.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CategoryEntity implements Serializable {

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
