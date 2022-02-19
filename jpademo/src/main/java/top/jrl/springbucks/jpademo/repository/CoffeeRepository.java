package top.jrl.springbucks.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jrl.springbucks.jpademo.model.Coffee;

/**
 * 继承jpa提供的接口，就可以自动生成对应的sql
* @author jrl
* @date 2022/2/19
*/
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {

}
