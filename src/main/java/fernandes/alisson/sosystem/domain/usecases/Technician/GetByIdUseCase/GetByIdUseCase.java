package fernandes.alisson.sosystem.domain.usecases.Technician.GetByIdUseCase;

import fernandes.alisson.sosystem.domain.model.Technician;

public interface GetByIdUseCase {
    public Technician execute(Long id);
}
