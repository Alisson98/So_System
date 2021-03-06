package fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByIdUseCase.impl;

import fernandes.alisson.sosystem.domain.usecases.exceptions.ObjectNotFoundException;
import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByIdUseCase.TechnicianGetByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TechnicianGetByIdUseCaseImpl implements TechnicianGetByIdUseCase {

    @Autowired
    private TechnicianRepository repository;

    @Override
    public Technician execute(Long id) {
        Optional<Technician> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found! ID:" + id + " Type: " + Technician.class.getName()));
    }
}
