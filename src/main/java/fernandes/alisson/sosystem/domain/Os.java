package fernandes.alisson.sosystem.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import fernandes.alisson.sosystem.domain.enuns.Priority;
import fernandes.alisson.sosystem.domain.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Os implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime openDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime closingDate;

    private Integer priority;
    private Integer  status;
    private String obs;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Os() {
        this.setOpenDate(LocalDateTime.now());
        this.setPriority(Priority.LOW);
        this.setStatus(Status.OPEN);
    }

    public Os(Integer id, Priority priority, Status status, String obs, Technician technician, Client client) {
        this.id = id;
        this.priority = (priority == null) ? 0 : priority.getCode();
        this.status = (status == null) ? 0 : status.getCode();
        this.obs = obs;
        this.technician = technician;
        this.client = client;
    }
    public Priority getPriority() {
        return Priority.toEnum(this.priority);
    }
    public void setPriority(Priority priority){ this.priority = priority.getCode(); }
    public Status getStatus() {
        return Status.toEnum(this.status);
    }
    public void setStatus(Status status){ this.status = status.getCode(); }

}
