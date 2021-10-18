package fernandes.alisson.sosystem.domain.usecases.Technician.DeleteUseCase.impl;

import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.DeleteUseCase.DeleteUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.GetByIdUseCase.GetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUseCaseImpl implements DeleteUseCase {

    @Autowired
    private TechnicianRepository repository;

    @Autowired
    private GetByIdUseCase getByIdUseCase;
    @Override
    public void execute(Long id) {
        Technician obj = getByIdUseCase.execute(id);
        if(!obj.getOsList().isEmpty())
            throw new DataIntegrityViolationException("Technician has open service orders!");
        repository.deleteById(id);
    }
}
