package fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByIdUseCase;

import fernandes.alisson.sosystem.domain.model.Client;

public interface ClientGetByIdUseCase {
    public Client execute(Long id);
}
