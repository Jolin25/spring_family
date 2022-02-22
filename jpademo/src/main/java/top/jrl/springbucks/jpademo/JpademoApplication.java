package top.jrl.springbucks.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.jrl.springbucks.jpademo.repository.CoffeeRepository;

/**
 * @author Joly
 */
@SpringBootApplication
public class JpademoApplication implements CommandLineRunner {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpademoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        coffeeRepository.findAll();
    }
}
