package fernandes.alisson.sosystem.config;

import fernandes.alisson.sosystem.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestProfileConfig {
    @Autowired
    private DBService dbService;
    @Bean
    public void instancyDB (){
        this.dbService.instancyDB();
    }


}
