package fernandes.alisson.sosystem.application.dtos;

import fernandes.alisson.sosystem.domain.model.Technician;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "mandatory name field")
    private String name;

    @CPF
    @NotEmpty(message = "mandatory cpf field")
    private String cpf;

    @NotEmpty(message = "mandatory phone field")
    private String phone;

    public ClientDTO() {
    }

    public ClientDTO(Technician obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.phone = obj.getPhone();
    }
}
