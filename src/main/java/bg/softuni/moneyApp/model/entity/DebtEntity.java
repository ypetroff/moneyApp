package bg.softuni.moneyApp.model.entity;

import bg.softuni.moneyApp.model.enums.Currency;
import bg.softuni.moneyApp.model.enums.DebtType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
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
