package fernandes.alisson.sosystem.application.dtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import fernandes.alisson.sosystem.domain.model.Os;
import fernandes.alisson.sosystem.domain.model.enuns.Priority;
import fernandes.alisson.sosystem.domain.model.enuns.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class OsDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime openDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime closingDate;
    private Integer priority;
    private Integer  status;

    @NotEmpty(message = "mandatory obs field")
    private String obs;

    private Long technician;
    private Long client;

    public OsDTO() {
    }

    public OsDTO(Os obj) {
        this.id = obj.getId();
        this.openDate = obj.getOpenDate();
        this.closingDate = obj.getClosingDate();
        this.priority = obj.getPriority().getCode();
        this.status = obj.getStatus().getCode();
        this.obs = obj.getObs();
        this.technician = obj.getTechnician().getId();
        this.client = obj.getClient().getId();
    }
    public Status getStatus(){
        return Status.toEnum(this.status);
    }
    public Priority getPriority(){
        return Priority.toEnum(this.priority);
    }
}
