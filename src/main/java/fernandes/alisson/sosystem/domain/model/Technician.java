package fernandes.alisson.sosystem.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "TB_TECHNICIAN")
public class Technician extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public Technician() {
    }
    public Technician(Long id, String name, @CPF String cpf, String phone) {
        super(id, name, cpf, phone);
    }
    @JsonIgnore
    @OneToMany(mappedBy = "technician")
    private List<Os> osList= new ArrayList<>();
}
