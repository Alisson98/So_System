package fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByIdUseCase.impl;

import fernandes.alisson.sosystem.data.repositories.ClientRepository;
import fernandes.alisson.sosystem.domain.model.Client;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByIdUseCase.GetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetByIdUseCaseImpl implements GetByIdUseCase {

    @Autowired
    private ClientRepository repository;

    @Override
    public Client execute(Long id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found! ID:" + id + " Type: " + Client.class.getName()));
    }
}
