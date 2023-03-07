package bg.softuni.moneyApp.model.entity;

import bg.softuni.moneyApp.model.enums.Currency;
import bg.softuni.moneyApp.model.enums.ExpenseCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expenses")
public class ExpenseEntity extends BaseEntity{

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
    @Column(name = "date_of_purchase")
    private LocalDateTime dateOfPurchase;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "currency") //TODO: check possible submit of null value
    private Currency currency; //TODO: currency exchange api
}
