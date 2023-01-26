package bg.softuni.moneyApp.repository;

import bg.softuni.moneyApp.model.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtRepository extends JpaRepository<DebtEntity, Long> {
}
