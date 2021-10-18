package fernandes.alisson.sosystem.data.repositories;

import fernandes.alisson.sosystem.domain.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
}
