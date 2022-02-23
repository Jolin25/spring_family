package top.jrl.redisdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import top.jrl.redisdemo.model.Coffee;
import top.jrl.redisdemo.service.CoffeeService;

import java.util.Optional;

@Slf4j
@SpringBootApplication
public class RedisdemoApplication implements ApplicationRunner {
    @Autowired
    private CoffeeService coffeeService;

    /*在这里往spring上下文里注入了RedisTemplate*/
    @Bean
    public RedisTemplate<String, Coffee> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Coffee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisdemoApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Coffee> latte = coffeeService.findOneCoffee("latte");
        latte.ifPresent(coffee -> log.info("find {} ", coffee));
        // 测试一下是从缓存里拿的
        for (int i = 0; i < 5; i++) {
            Optional<Coffee> coffee = coffeeService.findOneCoffee("latte");
            log.info("======================find from redis===================={}",coffee);
        }
    }
}
