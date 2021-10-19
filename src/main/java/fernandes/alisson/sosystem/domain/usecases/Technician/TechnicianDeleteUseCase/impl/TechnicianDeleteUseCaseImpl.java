package fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianDeleteUseCase.impl;

import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianDeleteUseCase.TechnicianDeleteUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByIdUseCase.TechnicianGetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicianDeleteUseCaseImpl implements TechnicianDeleteUseCase {

    @Autowired
    private TechnicianRepository repository;

    @Autowired
    private TechnicianGetByIdUseCase technicianGetByIdUseCase;
    @Override
    public void execute(Long id) {
        Technician obj = technicianGetByIdUseCase.execute(id);
        if(!obj.getOsList().isEmpty())
            throw new DataIntegrityViolationException("Technician has open service orders!");
        repository.deleteById(id);
    }
}
