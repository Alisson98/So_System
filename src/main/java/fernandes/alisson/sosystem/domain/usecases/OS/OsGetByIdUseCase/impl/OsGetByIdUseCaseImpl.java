package fernandes.alisson.sosystem.domain.usecases.OS.OsGetByIdUseCase.impl;

import fernandes.alisson.sosystem.data.repositories.OsRepository;
import fernandes.alisson.sosystem.domain.model.Os;
import fernandes.alisson.sosystem.domain.usecases.OS.OsGetByIdUseCase.OsGetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OsGetByIdUseCaseImpl implements OsGetByIdUseCase {

    @Autowired
    private OsRepository repository;

    @Override
    public Os execute(Long id) {
        Optional<Os> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found! ID:" + id + " Type: " + Os.class.getName()));
    }
}
