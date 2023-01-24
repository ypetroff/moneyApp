package bg.softuni.moneyApp.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "new_worths")
public class NetWorth extends BaseEntity {

    @OneToOne
    private UserEntity user;

    @ManyToMany
    private List<StockEntity> stocks;

    //TODO: Create transaction entity or think of other solution for relation between user and stocks
}
