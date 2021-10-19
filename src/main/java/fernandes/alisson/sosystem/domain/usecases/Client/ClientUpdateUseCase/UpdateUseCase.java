package fernandes.alisson.sosystem.domain.usecases.Client.ClientUpdateUseCase;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.domain.model.Technician;

public interface UpdateUseCase {
    public Technician execute(Long id, TechnicianDTO objDto);
}
