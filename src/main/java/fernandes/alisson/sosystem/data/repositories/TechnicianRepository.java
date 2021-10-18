package fernandes.alisson.sosystem.data.repositories;

import fernandes.alisson.sosystem.domain.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {

    @Query("SELECT obj FROM TB_TECHNICIAN obj WHERE obj.cpf =:cpf")
    Technician findByCPF(@Param("cpf") String cpf);

}
