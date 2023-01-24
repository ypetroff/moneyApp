package bg.softuni.moneyApp.model.entity;

import bg.softuni.moneyApp.model.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$")
    @Column(name = "email", nullable = false)
    private String email;

    @Size(min = 4, max = 15)
    @Column(name = "username", nullable = false)
    private String userName;

    @NotEmpty
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany
    private List<UserRoleEntity> userRole;
}
