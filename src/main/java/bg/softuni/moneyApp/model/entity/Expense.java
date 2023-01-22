package bg.softuni.moneyApp.model.entity;

import bg.softuni.moneyApp.model.enums.Currency;
import bg.softuni.moneyApp.model.enums.ExpenseCategory;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
public class Expense extends BaseEntity{

    @Enumerated(value = EnumType.STRING)
    @Column(name = "expense_category", nullable = false)
    private ExpenseCategory category;

    @Column(name = "name", nullable = false)
    private String name;

    //TODO: When the user inputs totalPrice, pricePerUnit and numberOfUnits could be null
    @Column(name = "price_per_unit")
    private BigDecimal pricePerUnit;

    @Column(name = "number_of_units")
    private Integer numberOfUnits;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    //NOTE: another option - set a default param for expenseDTO OR set default in the controller
    @Column(name = "date_of_purchase", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateOfPurchase;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "currency", columnDefinition = "BGN") //TODO: check possible submit of null value
    private Currency currency; //TODO: currency exchange api
}
