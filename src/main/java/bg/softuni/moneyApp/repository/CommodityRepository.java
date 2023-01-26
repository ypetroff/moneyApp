package bg.softuni.moneyApp.repository;

import bg.softuni.moneyApp.model.entity.CommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityRepository extends JpaRepository<CommodityEntity, Long> {
}
