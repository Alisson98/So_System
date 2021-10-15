package fernandes.alisson.sosystem;

import fernandes.alisson.sosystem.domain.Client;
import fernandes.alisson.sosystem.domain.Os;
import fernandes.alisson.sosystem.domain.Technician;
import fernandes.alisson.sosystem.domain.enuns.Priority;
import fernandes.alisson.sosystem.domain.enuns.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SosystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SosystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Technician t1 = new Technician(null, "Alisson","654.432.120-60", "(99) 99999999");
		Client c1 = new Client(null, "Betina Campos", "881.259.350-02", "(99) 99999999" );
		Os os1= new Os(null, Priority.HIGH, Status.PROGRESS, "Teste create OS", t1, c1);


	}
}
