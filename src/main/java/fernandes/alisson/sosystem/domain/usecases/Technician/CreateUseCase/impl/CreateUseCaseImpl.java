package fernandes.alisson.sosystem.domain.usecases.Technician.CreateUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.CreateUseCase.CreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUseCaseImpl implements CreateUseCase {

    @Autowired
    private TechnicianRepository repository;

    @Override
    public Technician execute(TechnicianDTO objDTO) {
        return repository.save(new Technician(null, objDTO.getName(), objDTO.getCpf(), objDTO.getPhone()));
    }
}
