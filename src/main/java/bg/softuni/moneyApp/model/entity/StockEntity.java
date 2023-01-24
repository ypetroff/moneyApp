package bg.softuni.moneyApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "stocks")
public class StockEntity extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ticker", nullable = false)
    private String ticker;

    @Column(name = "shares_count", nullable = false)
    private Integer sharesCount;

    @Column(name = "shares_bought_at_price", nullable = false)
    private BigDecimal sharesBoughtAtPrice;

    @Column(name = "date_and_time_of_purchase", nullable = false)
    private LocalDateTime dateAndTimeOfPurchase;
}
