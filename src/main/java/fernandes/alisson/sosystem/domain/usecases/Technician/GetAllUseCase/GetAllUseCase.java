package fernandes.alisson.sosystem.domain.usecases.Technician.GetAllUseCase;

import fernandes.alisson.sosystem.domain.model.Technician;

import java.util.List;

public interface GetAllUseCase {
    public List<Technician> execute();
}
