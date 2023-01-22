package bg.softuni.moneyApp.model.entity;

import bg.softuni.moneyApp.model.enums.Currency;
import bg.softuni.moneyApp.model.enums.ExpenseCategory;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense extends BaseEntity{

    @Enumerated(value = EnumType.STRING)
    @Column(name = "expense_category", nullable = false)
    private ExpenseCategory category;

    private String name;

    private BigDecimal pricePerUnit;

    private Integer numberOfUnits;

    private BigDecimal totalPrice;

    private LocalDate dateOfPurchase;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "currency", columnDefinition = "BGN") //TODO: check possible submit of null value
    private Currency currency; //TODO: currency exchange api
}
