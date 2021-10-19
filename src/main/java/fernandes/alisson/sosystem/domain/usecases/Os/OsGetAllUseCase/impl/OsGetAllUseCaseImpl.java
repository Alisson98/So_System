package fernandes.alisson.sosystem.domain.usecases.Os.OsGetAllUseCase.impl;

import fernandes.alisson.sosystem.data.repositories.OsRepository;
import fernandes.alisson.sosystem.domain.model.Os;
import fernandes.alisson.sosystem.domain.usecases.Os.OsGetAllUseCase.OsGetAllUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OsGetAllUseCaseImpl implements OsGetAllUseCase {

    @Autowired
    private OsRepository repository;

    @Override
    public List<Os> execute() {
        return repository.findAll();
    }
}
