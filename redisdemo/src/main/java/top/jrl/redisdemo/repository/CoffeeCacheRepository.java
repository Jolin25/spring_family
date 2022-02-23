package top.jrl.redisdemo.repository;

import org.springframework.data.repository.CrudRepository;
import top.jrl.redisdemo.model.CoffeeCache;

import java.util.Optional;

/**
 * 这个类是给redisRepository用的
 * @author 小虫子的小日常
 */
public interface CoffeeCacheRepository extends CrudRepository<CoffeeCache, Long> {
    Optional<CoffeeCache> findOneByName(String name);
}
