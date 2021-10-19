package fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianCreateUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianCreateUseCase.CreateUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByCpfUseCase.GetByCpfUseCase;
import fernandes.alisson.sosystem.domain.usecases.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUseCaseImpl implements CreateUseCase {

    @Autowired
    private TechnicianRepository repository;

    @Autowired
    private GetByCpfUseCase getByCpfUseCase;

    @Override
    public Technician execute(TechnicianDTO objDTO) {
        if(getByCpfUseCase.execute(objDTO) !=null)
            throw new DataIntegrityViolationException("CPF is already in use!");
        return repository.save(new Technician(null, objDTO.getName(), objDTO.getCpf(), objDTO.getPhone()));

    }
}
