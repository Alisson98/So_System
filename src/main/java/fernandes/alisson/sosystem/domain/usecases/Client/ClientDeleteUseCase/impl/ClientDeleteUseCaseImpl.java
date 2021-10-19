package fernandes.alisson.sosystem.domain.usecases.Client.ClientDeleteUseCase.impl;

import fernandes.alisson.sosystem.data.repositories.ClientRepository;
import fernandes.alisson.sosystem.domain.model.Client;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientDeleteUseCase.ClientDeleteUseCase;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByIdUseCase.ClientGetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientDeleteUseCaseImpl implements ClientDeleteUseCase {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientGetByIdUseCase clientGetByIdUseCase;
    @Override
    public void execute(Long id) {
        Client obj = clientGetByIdUseCase.execute(id);
        if(!obj.getOsList().isEmpty())
            throw new DataIntegrityViolationException("Client has open service orders!");
        repository.deleteById(id);
    }
}
