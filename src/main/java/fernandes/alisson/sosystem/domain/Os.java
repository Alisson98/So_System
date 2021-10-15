package fernandes.alisson.sosystem.domain;

import fernandes.alisson.sosystem.domain.enuns.Priority;
import fernandes.alisson.sosystem.domain.enuns.Status;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Os {

    private Integer id;
    private LocalDateTime openDate;
    private LocalDateTime closingDate;
    private Integer priority;
    private Integer  status;
    private String obs;
    private Technician technician;
    private Client client;

    public Os() {
        this.setOpenDate(LocalDateTime.now());
        this.setPriority(Priority.LOW);
        this.setStatus(Status.OPEN);
    }

    public Os(Integer id, LocalDateTime openDate, Priority priority, Status status, String obs, Technician technician, Client client) {
        this.id = id;
        this.setOpenDate(LocalDateTime.now());
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
