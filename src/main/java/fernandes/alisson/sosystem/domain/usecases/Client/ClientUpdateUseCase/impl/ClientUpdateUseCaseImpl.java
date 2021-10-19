package fernandes.alisson.sosystem.domain.usecases.Client.ClientUpdateUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.ClientDTO;
import fernandes.alisson.sosystem.data.repositories.ClientRepository;
import fernandes.alisson.sosystem.domain.model.Client;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByCpfUseCase.ClientGetByCpfUseCase;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByIdUseCase.ClientGetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientUpdateUseCase.ClientUpdateUseCase;
import fernandes.alisson.sosystem.domain.usecases.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientUpdateUseCaseImpl implements ClientUpdateUseCase {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientGetByIdUseCase clientGetByIdUseCase;

    @Autowired
    private ClientGetByCpfUseCase clientGetByCpfUseCase;

    @Override
    public Client execute(Long id, ClientDTO objDto){
       Client oldObj = clientGetByIdUseCase.execute(id);
       if(clientGetByCpfUseCase.execute(objDto) != null && clientGetByCpfUseCase.execute(objDto).getId() != id)
           throw new DataIntegrityViolationException("CPF is already in use!");
       oldObj.setName(objDto.getName());
       oldObj.setCpf(objDto.getCpf());
       oldObj.setPhone(objDto.getPhone());
       return repository.save(oldObj);
    }
}
