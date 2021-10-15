package fernandes.alisson.sosystem.repositories;


import fernandes.alisson.sosystem.domain.Os;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsRepository extends JpaRepository<Os, Long> {
}
