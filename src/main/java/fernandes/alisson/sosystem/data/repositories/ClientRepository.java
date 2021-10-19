package fernandes.alisson.sosystem.data.repositories;

import fernandes.alisson.sosystem.domain.model.Client;
import fernandes.alisson.sosystem.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT obj FROM TB_CLIENT obj WHERE obj.cpf =:cpf")
    Client findByCPF(@Param("cpf") String cpf);
}
