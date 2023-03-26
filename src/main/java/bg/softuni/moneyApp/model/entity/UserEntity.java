package bg.softuni.moneyApp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
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

    @ManyToMany
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
