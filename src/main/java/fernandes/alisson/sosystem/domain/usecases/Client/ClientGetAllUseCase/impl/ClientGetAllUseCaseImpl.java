package fernandes.alisson.sosystem.domain.usecases.Client.ClientGetAllUseCase.impl;

import fernandes.alisson.sosystem.data.repositories.ClientRepository;
import fernandes.alisson.sosystem.domain.model.Client;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientGetAllUseCase.ClientGetAllUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientGetAllUseCaseImpl implements ClientGetAllUseCase {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> execute() {
        return repository.findAll();
    }
}
