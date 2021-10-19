package fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianUpdateUseCase;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.domain.model.Technician;

public interface TechnicianUpdateUseCase {
    public Technician execute(Long id, TechnicianDTO objDto);
}
