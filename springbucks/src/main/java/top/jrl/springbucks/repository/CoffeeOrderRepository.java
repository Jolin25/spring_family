package top.jrl.springbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jrl.springbucks.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
