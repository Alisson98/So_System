package fernandes.alisson.sosystem.domain.usecases.Os.OsCreateUseCase.impl;

import fernandes.alisson.sosystem.application.dtos.OsDTO;
import fernandes.alisson.sosystem.data.repositories.OsRepository;
import fernandes.alisson.sosystem.domain.model.Client;
import fernandes.alisson.sosystem.domain.model.Os;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.model.enuns.Priority;
import fernandes.alisson.sosystem.domain.model.enuns.Status;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByIdUseCase.ClientGetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.Os.OsCreateUseCase.OsCreateUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByIdUseCase.TechnicianGetByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OsCreateUseCaseImpl implements OsCreateUseCase {

    @Autowired
    private OsRepository repository;

    @Autowired
    private TechnicianGetByIdUseCase technicianGetByIdUseCase;

    @Autowired
    private ClientGetByIdUseCase clientGetByIdUseCase;

    @Override
    public Os execute(OsDTO objDTO) {
        Os newObj = new Os();
        newObj.setId(objDTO.getId());
        newObj.setObs(objDTO.getObs());
        newObj.setPriority(Priority.toEnum(objDTO.getPriority()));
        newObj.setStatus(Status.toEnum(objDTO.getStatus()));

        Technician tec = technicianGetByIdUseCase.execute(objDTO.getTechnician());
        Client cli = clientGetByIdUseCase.execute(objDTO.getClient());

        newObj.setTechnician(tec);
        newObj.setClient(cli);
        return repository.save(newObj);
    }
}
