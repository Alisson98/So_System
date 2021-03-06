package fernandes.alisson.sosystem.domain.usecases.Os.OsUpdateUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.OsDTO;
import fernandes.alisson.sosystem.data.repositories.OsRepository;
import fernandes.alisson.sosystem.domain.model.Client;
import fernandes.alisson.sosystem.domain.model.Os;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByIdUseCase.ClientGetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.Os.OsUpdateUseCase.OsUpdateUseCase;
import fernandes.alisson.sosystem.domain.usecases.Os.OsGetByIdUseCase.OsGetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByIdUseCase.TechnicianGetByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OsUpdateUseCaseImpl implements OsUpdateUseCase {

    @Autowired
    private OsRepository repository;

    @Autowired
    private OsGetByIdUseCase osGetByIdUseCase;

    @Autowired
    private TechnicianGetByIdUseCase technicianGetByIdUseCase;

    @Autowired
    private ClientGetByIdUseCase clientGetByIdUseCase;

    @Override
    public Os execute(OsDTO objDTO){
        osGetByIdUseCase.execute(objDTO.getId());
        Os newObj = new Os();
        newObj.setId(objDTO.getId());
        newObj.setObs(objDTO.getObs());
        newObj.setPriority((objDTO.getPriority()));
        newObj.setStatus((objDTO.getStatus()));

        Technician tec = technicianGetByIdUseCase.execute(objDTO.getTechnician());
        Client cli = clientGetByIdUseCase.execute(objDTO.getClient());

        newObj.setTechnician(tec);
        newObj.setClient(cli);

        if(newObj.getStatus().getCode().equals(2))
            newObj.setClosingDate(LocalDateTime.now());
        return repository.save(newObj);
    }
}
