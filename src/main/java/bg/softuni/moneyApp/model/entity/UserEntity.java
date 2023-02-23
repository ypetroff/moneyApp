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

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany
    private List<UserRoleEntity> userRole;

    @ManyToMany
    private List<StockEntity> stocks;

    @OneToMany
    private List<AccountEntity> accounts;

    @OneToMany
    private List<CryptoEntity> crypto;

    @OneToMany
    private List<CommodityEntity> commodities;

    @OneToOne
    private DebtEntity debt;
}
