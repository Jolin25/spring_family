package top.jrl.springbucks.jpademo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import top.jrl.springbucks.jpademo.model.CoffeeOrder;

/**
 * @author Joly
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
