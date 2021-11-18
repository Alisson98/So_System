package fernandes.alisson.sosystem.config;

import fernandes.alisson.sosystem.domain.usecases.DBService.impl.DBServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdProfileConfig {
    @Autowired
    private DBServiceImpl dbServiceImpl;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;
    @Bean
    public boolean instancyDB (){
        if(ddl.equals("create-drop")) this.dbServiceImpl.instancyDB();
        return false;
    }


}
