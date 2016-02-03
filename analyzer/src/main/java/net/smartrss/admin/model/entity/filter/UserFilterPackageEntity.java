package net.smartrss.admin.model.entity.filter;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.smartrss.admin.model.entity.enumerated.UserFilterPackageStatus;
import net.smartrss.admin.model.entity.enumerated.UserFilterPackageType;
import net.smartrss.admin.model.entity.PrimaryKey;

/**
 * Created by Alexander on 02.02.2016.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserFilterPackageEntity implements Serializable {

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
    @Column(name = "description", nullable = false)
    private String description;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "filter_to_package",
            joinColumns = {
                    @JoinColumn(name = "packageProviderId", referencedColumnName = "providerId"),
                    @JoinColumn(name = "packageId", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "filterProviderId", referencedColumnName = "providerId"),
                    @JoinColumn(name = "filterId", referencedColumnName = "id")
            })
    private Set<UserFilterEntity> filters;

    @Getter
    @Setter
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private UserFilterPackageStatus status;

    @Getter
    @Setter
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "type", nullable = false)
    private UserFilterPackageType type;

    @Getter
    @Setter
    @Column(name = "validTill", nullable = false)
    private Long validTill;

    @Getter
    @Setter
    @Column(name = "created", nullable = false)
    private Long created = System.currentTimeMillis();

    @Getter
    @Setter
    @Column(name = "updated", nullable = false)
    private Long updated = System.currentTimeMillis();

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "", referencedColumnName = ""),
            @JoinColumn(name = "", referencedColumnName = "")
    })
    private
}
