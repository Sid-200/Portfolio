package portfolio.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.example.demo.entity.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
