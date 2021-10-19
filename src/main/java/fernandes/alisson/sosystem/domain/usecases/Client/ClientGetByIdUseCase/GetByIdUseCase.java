package fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByIdUseCase;

import fernandes.alisson.sosystem.domain.model.Client;

public interface GetByIdUseCase {
    public Client execute(Long id);
}
