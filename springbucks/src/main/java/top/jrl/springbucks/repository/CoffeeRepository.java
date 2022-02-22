package top.jrl.springbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jrl.springbucks.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
