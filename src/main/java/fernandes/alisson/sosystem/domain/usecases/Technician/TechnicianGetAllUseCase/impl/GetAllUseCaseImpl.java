package fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetAllUseCase.impl;

import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetAllUseCase.GetAllUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUseCaseImpl implements GetAllUseCase {

    @Autowired
    private TechnicianRepository repository;

    @Override
    public List<Technician> execute() {
        return repository.findAll();
    }
}
