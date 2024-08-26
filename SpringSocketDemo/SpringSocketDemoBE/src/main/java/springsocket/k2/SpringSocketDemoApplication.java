package springsocket.k2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import springsocket.k2.entity.NumberEntity;
import springsocket.k2.repository.NumberRepository;

@SpringBootApplication
@EntityScan(basePackages = "springsocket.k2.entity") // Adjust this if necessary
public class SpringSocketDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSocketDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(NumberRepository repository) {
        return args -> {
            NumberEntity numberEntity = new NumberEntity();
            numberEntity.setValue(1L);
            numberEntity.setIdentifier("magic");
            repository.save(numberEntity);
        };
    }
}
