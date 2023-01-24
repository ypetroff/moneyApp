package bg.softuni.moneyApp.model.entity;

import bg.softuni.moneyApp.model.enums.Currency;
import bg.softuni.moneyApp.model.enums.DebtType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "debts")
public class DebtEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private DebtType debtType;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;
}
