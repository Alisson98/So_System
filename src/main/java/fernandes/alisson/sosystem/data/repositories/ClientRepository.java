package fernandes.alisson.sosystem.data.repositories;

import fernandes.alisson.sosystem.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
