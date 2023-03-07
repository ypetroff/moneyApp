package bg.softuni.moneyApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "cryptos")
public class CryptoEntity extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ticker", nullable = false)
    private String ticker;

    @Column(name = "tokens_count", nullable = false)
    private Integer sharesCount;

    @Column(name = "tokens_bought_at_price", nullable = false)
    private BigDecimal tokensBoughtAtPrice;

    @Column(name = "date_and_time_of_purchase", nullable = false)
    private LocalDateTime dateAndTimeOfPurchase;
}
