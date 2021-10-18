package fernandes.alisson.sosystem.data.datasources.dtos;

import fernandes.alisson.sosystem.domain.model.Technician;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import java.io.Serializable;
@Getter
@Setter
public class TechnicianDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    @CPF
    private String cpf;
    private String phone;

    public TechnicianDTO() {
    }

    public TechnicianDTO(Technician obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.phone = obj.getPhone();
    }
}
