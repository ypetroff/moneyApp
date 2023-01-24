package bg.softuni.moneyApp.model.entity;

import bg.softuni.moneyApp.model.enums.AccountType;
import bg.softuni.moneyApp.model.enums.Currency;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class AccountEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Column(name = "amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;

}
