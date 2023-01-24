package bg.softuni.moneyApp.model.entity;

import bg.softuni.moneyApp.model.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;
}
