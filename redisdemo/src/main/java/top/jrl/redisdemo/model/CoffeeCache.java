package top.jrl.redisdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * 这个类是给redisRepository用的
 *
 * @author 小虫子的小日常
 */
@RedisHash(value = "springbucks-coffee", timeToLive = 60)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeCache {
    @Id
    private Long id;
    // 这个注解是redis提供的，用于指定二级索引，也就是说可以直接根据name来在redis里面进行搜索
    @Indexed
    private String name;
    private Money price;
}
