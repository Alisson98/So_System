package fernandes.alisson.sosystem.domain.usecases.Client.ClientCreateUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.ClientDTO;
import fernandes.alisson.sosystem.data.repositories.ClientRepository;
import fernandes.alisson.sosystem.domain.model.Client;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientCreateUseCase.ClientCreateUseCase;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByCpfUseCase.ClientGetByCpfUseCase;
import fernandes.alisson.sosystem.domain.usecases.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientCreateUseCaseImpl implements ClientCreateUseCase {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientGetByCpfUseCase clientGetByCpfUseCase;

    @Override
    public Client execute(ClientDTO objDTO) {
        if(clientGetByCpfUseCase.execute(objDTO) !=null)
            throw new DataIntegrityViolationException("CPF is already in use!");
        return repository.save(new Client(null, objDTO.getName(), objDTO.getCpf(), objDTO.getPhone()));

    }
}
