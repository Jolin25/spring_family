package top.jrl.springbucks;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import top.jrl.springbucks.service.CoffeeService;

import java.util.Map;

/**
 * @author 小虫子的小日常
 */
@Slf4j
@SpringBootApplication
public class SpringBucksApplication implements ApplicationRunner {
    @Autowired
    private CoffeeService coffeeService;
    // 官方提供的类，但是是我们自己给创建bean并且注入的
    // 官方提供的类，但是我们可以自定义修改
    @Autowired
    private JedisPoolConfig jedisPoolConfig;
    @Autowired
    private JedisPool jedisPool;


    // 这里就把JedisPoolConfig给作为一个bean传进来了，根据配置文件里面redis为前缀的属性进行了赋值
    @Bean
    @ConfigurationProperties("redis")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    // 创建JedisPool实例
    @Bean(destroyMethod = "close")
    public JedisPool jedisPool(@Value("${redis.host}") String host) {
        return new JedisPool(jedisPoolConfig(), host);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBucksApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("jedisConfig===>,{}", jedisPoolConfig);
        try (Jedis jedis = jedisPool.getResource()) {
            coffeeService.findAllCoffee().forEach(coffee -> {
                jedis.hset("springbucks-menu", coffee.getName(), Long.toString(coffee.getPrice().getAmountMinorLong()));
            });
            Map<String, String> menu = jedis.hgetAll("springbucks-menu");
            log.info("menu===>{}", menu);
            String price = jedis.hget("springbucks-menu", "espresso");
            log.info("espresso ===> {}",
                    Money.ofMinor(CurrencyUnit.of("CNY"), Long.parseLong(price)));
        }
    }
}
