package fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByCpfUseCase;

import fernandes.alisson.sosystem.application.dtos.ClientDTO;
import fernandes.alisson.sosystem.domain.model.Client;

public interface ClientGetByCpfUseCase {
    public Client execute(ClientDTO objDTO);
}
