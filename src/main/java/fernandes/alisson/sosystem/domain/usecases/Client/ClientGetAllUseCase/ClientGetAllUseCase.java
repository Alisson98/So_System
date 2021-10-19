package fernandes.alisson.sosystem.domain.usecases.Client.ClientGetAllUseCase;

import fernandes.alisson.sosystem.domain.model.Client;

import java.util.List;

public interface ClientGetAllUseCase {
    public List<Client> execute();
}
