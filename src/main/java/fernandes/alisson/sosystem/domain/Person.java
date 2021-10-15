package fernandes.alisson.sosystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {

    private Long id;
    private String name;
    private String cpf;
    private String phone;
}
