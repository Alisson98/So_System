package fernandes.alisson.sosystem.data.repositories;


import fernandes.alisson.sosystem.domain.model.Os;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsRepository extends JpaRepository<Os, Long> {
}
