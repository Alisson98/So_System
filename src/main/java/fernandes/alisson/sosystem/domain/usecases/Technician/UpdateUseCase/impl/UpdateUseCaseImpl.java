package fernandes.alisson.sosystem.domain.usecases.Technician.UpdateUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.GetByCpfUseCase.GetByCpfUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.GetByIdUseCase.GetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.UpdateUseCase.UpdateUseCase;
import fernandes.alisson.sosystem.domain.usecases.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUseCaseImpl implements UpdateUseCase {

    @Autowired
    private TechnicianRepository repository;

    @Autowired
    private GetByIdUseCase getByIdUseCase;

    @Autowired
    private GetByCpfUseCase getByCpfUseCase;

    @Override
    public Technician execute(Long id, TechnicianDTO objDto){
       Technician oldObj = getByIdUseCase.execute(id);
       if(getByCpfUseCase.execute(objDto) != null && getByCpfUseCase.execute(objDto).getId() != id)
           throw new DataIntegrityViolationException("CPF is already in use!");
       oldObj.setName(objDto.getName());
       oldObj.setCpf(objDto.getCpf());
       oldObj.setPhone(objDto.getPhone());
       return repository.save(oldObj);
    }
}
