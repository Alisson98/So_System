package fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByCpfUseCase;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.domain.model.Technician;

public interface TechnicianGetByCpfUseCase {
    public Technician execute(TechnicianDTO objDTO);
}
