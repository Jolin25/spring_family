package top.jrl.redisdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jrl.redisdemo.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
