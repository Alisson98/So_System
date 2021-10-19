package fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByCpfUseCase;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.domain.model.Technician;

public interface GetByCpfUseCase {
    public Technician execute(TechnicianDTO objDTO);
}
