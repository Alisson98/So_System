package fernandes.alisson.sosystem.config;

import fernandes.alisson.sosystem.domain.usecases.DBService.impl.DBServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestProfileConfig {
    @Autowired
    private DBServiceImpl dbServiceImpl;
    @Bean
    public void instancyDB (){
        this.dbServiceImpl.instancyDB();
    }


}
