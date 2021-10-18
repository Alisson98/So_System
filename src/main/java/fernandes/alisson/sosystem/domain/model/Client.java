package fernandes.alisson.sosystem.domain.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "TB_CLIENT")
public class Client extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public Client() {
    }

    public Client(Long id, String name, @CPF String cpf, String phone) {
        super(id, name, cpf, phone);
    }

    @OneToMany(mappedBy = "client")
    private List<Os> osList= new ArrayList<>();
}
