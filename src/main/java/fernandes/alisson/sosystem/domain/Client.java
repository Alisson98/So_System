package fernandes.alisson.sosystem.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_CLIENT")
public class Client extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "client")
    private List<Os> osList= new ArrayList<>();
}
