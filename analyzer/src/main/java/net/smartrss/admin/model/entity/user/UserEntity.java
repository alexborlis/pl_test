package net.smartrss.admin.model.entity.user;

import java.util.Set;
import javax.persistence.OneToMany;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import net.smartrss.admin.model.entity.account.FeedAccountEntity;
import net.smartrss.admin.model.entity.PrimaryKey;

/**
 * Created by Alexander on 31.01.2016.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserEntity {

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
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<FeedAccountEntity> accounts;
}
