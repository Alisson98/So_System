package fernandes.alisson.sosystem.domain.usecases.Client.ClientCreateUseCase;

import fernandes.alisson.sosystem.application.dtos.ClientDTO;
import fernandes.alisson.sosystem.domain.model.Client;


public interface ClientCreateUseCase {
    public Client execute(ClientDTO objDTO);
}
