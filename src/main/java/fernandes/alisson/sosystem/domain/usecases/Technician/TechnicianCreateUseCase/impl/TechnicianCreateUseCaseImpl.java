package fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianCreateUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianCreateUseCase.TechnicianCreateUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByCpfUseCase.TechnicianGetByCpfUseCase;
import fernandes.alisson.sosystem.domain.usecases.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicianCreateUseCaseImpl implements TechnicianCreateUseCase {

    @Autowired
    private TechnicianRepository repository;

    @Autowired
    private TechnicianGetByCpfUseCase technicianGetByCpfUseCase;

    @Override
    public Technician execute(TechnicianDTO objDTO) {
        if(technicianGetByCpfUseCase.execute(objDTO) !=null)
            throw new DataIntegrityViolationException("CPF is already in use!");
        return repository.save(new Technician(null, objDTO.getName(), objDTO.getCpf(), objDTO.getPhone()));

    }
}
