package bg.softuni.moneyApp.model.entity;

import bg.softuni.moneyApp.model.enums.CommodityType;
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
@Table(name = "commodities")
public class CommodityEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CommodityType commodityType;

    @Column(name = "ticker", nullable = false)
    private String ticker;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "bought_at_price", nullable = false)
    private BigDecimal boughtAtPrice;

    @Column(name = "date_and_time_of_purchase", nullable = false)
    private LocalDateTime dateAndTimeOfPurchase;
}
