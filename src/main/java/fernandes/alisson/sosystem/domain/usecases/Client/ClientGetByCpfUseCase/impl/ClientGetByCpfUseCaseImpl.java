package fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByCpfUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.ClientDTO;
import fernandes.alisson.sosystem.data.repositories.ClientRepository;
import fernandes.alisson.sosystem.domain.model.Client;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByCpfUseCase.ClientGetByCpfUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientGetByCpfUseCaseImpl implements ClientGetByCpfUseCase {

    @Autowired
    private ClientRepository repository;

    @Override
    public Client execute(ClientDTO objDTO) {
        return repository.findByCPF(objDTO.getCpf());
    }
}
