package bg.softuni.moneyApp.repository;

import bg.softuni.moneyApp.model.entity.CryptoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepository extends JpaRepository<CryptoEntity, Long> {
}
