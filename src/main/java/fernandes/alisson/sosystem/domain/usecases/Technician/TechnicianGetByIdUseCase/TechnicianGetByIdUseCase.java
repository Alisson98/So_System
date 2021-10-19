package fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByIdUseCase;

import fernandes.alisson.sosystem.domain.model.Technician;

public interface TechnicianGetByIdUseCase {
    public Technician execute(Long id);
}
