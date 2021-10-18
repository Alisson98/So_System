package fernandes.alisson.sosystem.domain.usecases.Technician.GetByCpfUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.GetByCpfUseCase.GetByCpfUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetByCpfUseCaseImpl implements GetByCpfUseCase {

    @Autowired
    private TechnicianRepository repository;

    @Override
    public Technician execute(TechnicianDTO objDTO) {
        return repository.findByCPF(objDTO.getCpf());
    }
}
