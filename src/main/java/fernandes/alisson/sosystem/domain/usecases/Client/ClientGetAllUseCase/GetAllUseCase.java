package fernandes.alisson.sosystem.domain.usecases.Client.ClientGetAllUseCase;

import fernandes.alisson.sosystem.domain.model.Technician;

import java.util.List;

public interface GetAllUseCase {
    public List<Technician> execute();
}
