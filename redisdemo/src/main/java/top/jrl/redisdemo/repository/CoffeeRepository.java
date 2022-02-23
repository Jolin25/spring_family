package top.jrl.redisdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jrl.redisdemo.model.Coffee;

/**
 * @author 小虫子的小日常
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
