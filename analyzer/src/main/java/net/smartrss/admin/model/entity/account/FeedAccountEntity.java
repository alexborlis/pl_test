package net.smartrss.admin.model.entity.account;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.smartrss.admin.model.entity.PrimaryKey;
import net.smartrss.admin.model.entity.enumerated.FeedAccountStatus;
import net.smartrss.admin.model.entity.filter.UserFilterPackageEntity;
import net.smartrss.admin.model.entity.user.UserEntity;

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
public abstract class FeedAccountEntity implements Serializable {

    @Getter
    @Setter
    @EmbeddedId
    private PrimaryKey primaryKey;

    @Getter
    @Setter
    @Column(name = "credentialsId")
    private UUID credentialsId;

    @Getter
    @Setter
    @Column(name = "status", nullable = false)
    private FeedAccountStatus status;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "userProviderId", referencedColumnName = "id"),
            @JoinColumn(name = "userId", referencedColumnName = "id")
    })
    private UserEntity user;

    @Getter
    @Setter
    @Column(name = "created", nullable = false)
    private Long created = System.currentTimeMillis();

    @Getter
    @Setter
    @Column(name = "updated", nullable = false)
    private Long updated = System.currentTimeMillis();

    @Getter
    @Setter
    private Set<UserFilterPackageEntity> filterPackages;
}
