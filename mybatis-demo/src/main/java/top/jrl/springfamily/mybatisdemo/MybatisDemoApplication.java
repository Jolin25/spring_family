package top.jrl.springfamily.mybatisdemo;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.jrl.springfamily.mybatisdemo.mapper.CoffeeMapper;
import top.jrl.springfamily.mybatisdemo.model.Coffee;


/**
 * todo ApplicationRunner是个啥
 *
 * @author Joly
 */
@Slf4j
@MapperScan("top.jrl.springfamily.mybatisdemo.mapper")
@SpringBootApplication
public class MybatisDemoApplication implements ApplicationRunner {
    @Autowired
    private CoffeeMapper coffeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Coffee coffeeOne = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
        log.info("coffeeOne to insert:{}", coffeeOne);
        coffeeMapper.save(coffeeOne);
        Coffee byId = coffeeMapper.findById(coffeeOne.getId());
        log.info("coffee find by id:{}", byId);
    }
}
