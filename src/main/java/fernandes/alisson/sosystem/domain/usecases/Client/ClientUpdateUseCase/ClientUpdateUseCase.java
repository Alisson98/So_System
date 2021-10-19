package fernandes.alisson.sosystem.domain.usecases.Client.ClientUpdateUseCase;

import fernandes.alisson.sosystem.application.dtos.ClientDTO;
import fernandes.alisson.sosystem.domain.model.Client;

public interface ClientUpdateUseCase {
    public Client execute(Long id, ClientDTO objDto);
}
