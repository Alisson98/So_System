package fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianCreateUseCase;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.domain.model.Technician;

public interface CreateUseCase {
    public Technician execute(TechnicianDTO objDTO);
}
