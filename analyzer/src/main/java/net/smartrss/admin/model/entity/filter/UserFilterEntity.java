package net.smartrss.admin.model.entity.filter;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.smartrss.admin.model.entity.PrimaryKey;
import net.smartrss.admin.model.entity.filter.category.CategoryEntity;

/**
 * Created by Alexander on 02.02.2016.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserFilterEntity<CTG extends CategoryEntity> implements Serializable {

    @Getter
    @Setter
    @EmbeddedId
    private PrimaryKey primaryKey;

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "description", nullable = true)
    private String description;

    @Getter
    @Setter
    @OneToOne
    private CTG category;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "filter_to_package",
            joinColumns = {
                    @JoinColumn(name = "filterProviderId", referencedColumnName = "providerId"),
                    @JoinColumn(name = "filterId", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "packageProviderId", referencedColumnName = "providerId"),
                    @JoinColumn(name = "packageId", referencedColumnName = "id")
            })
    private Set<UserFilterPackageEntity> packages;

    @Getter
    @Setter
    @Column(name = "created", nullable = false)
    private Long created = System.currentTimeMillis();

    @Getter
    @Setter
    @Column(name = "updated", nullable = false)
    private Long updated = System.currentTimeMillis();

}
