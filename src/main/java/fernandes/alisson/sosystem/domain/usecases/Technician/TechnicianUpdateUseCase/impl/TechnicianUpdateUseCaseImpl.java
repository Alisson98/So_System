package fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianUpdateUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByCpfUseCase.TechnicianGetByCpfUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByIdUseCase.TechnicianGetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianUpdateUseCase.TechnicianUpdateUseCase;
import fernandes.alisson.sosystem.domain.usecases.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicianUpdateUseCaseImpl implements TechnicianUpdateUseCase {

    @Autowired
    private TechnicianRepository repository;

    @Autowired
    private TechnicianGetByIdUseCase technicianGetByIdUseCase;

    @Autowired
    private TechnicianGetByCpfUseCase technicianGetByCpfUseCase;

    @Override
    public Technician execute(Long id, TechnicianDTO objDto){
       Technician oldObj = technicianGetByIdUseCase.execute(id);
       if(technicianGetByCpfUseCase.execute(objDto) != null && technicianGetByCpfUseCase.execute(objDto).getId() != id)
           throw new DataIntegrityViolationException("CPF is already in use!");
       oldObj.setName(objDto.getName());
       oldObj.setCpf(objDto.getCpf());
       oldObj.setPhone(objDto.getPhone());
       return repository.save(oldObj);
    }
}
