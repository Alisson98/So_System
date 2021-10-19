package fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByCpfUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByCpfUseCase.TechnicianGetByCpfUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicianGetByCpfUseCaseImpl implements TechnicianGetByCpfUseCase {

    @Autowired
    private TechnicianRepository repository;

    @Override
    public Technician execute(TechnicianDTO objDTO) {
        return repository.findByCPF(objDTO.getCpf());
    }
}
