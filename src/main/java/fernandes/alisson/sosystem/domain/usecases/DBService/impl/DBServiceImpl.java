package fernandes.alisson.sosystem.domain.usecases.DBService.impl;

import fernandes.alisson.sosystem.domain.model.Client;
import fernandes.alisson.sosystem.domain.model.Os;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.model.enuns.Priority;
import fernandes.alisson.sosystem.domain.model.enuns.Status;
import fernandes.alisson.sosystem.data.repositories.ClientRepository;
import fernandes.alisson.sosystem.data.repositories.OsRepository;
import fernandes.alisson.sosystem.data.repositories.TechnicianRepository;
import fernandes.alisson.sosystem.domain.usecases.DBService.DBService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBServiceImpl implements DBService {

    private final TechnicianRepository technicianRepository;

    private final ClientRepository clientRepository;

    private final OsRepository osRepository;

    public DBServiceImpl(TechnicianRepository technicianRepository, ClientRepository clientRepository, OsRepository osRepository) {
        this.technicianRepository = technicianRepository;
        this.clientRepository = clientRepository;
        this.osRepository = osRepository;
    }

    @Override
    public void instancyDB (){
        Technician t1 = new Technician(null, "Marcos","654.432.120-60", "(99) 99999999");
        Technician t2 = new Technician(null, "Alisson","654.432.120-60", "(99) 99999999");
        Client c1 = new Client(null, "Betina Campos", "881.259.350-02", "(99) 99999999" );
        Os os1= new Os(null, Priority.HIGH, Status.PROGRESS, "Teste create OS", t1, c1);

        t1.getOsList().add(os1);
        c1.getOsList().add(os1);

        technicianRepository.saveAll(List.of(t1,t2));
        clientRepository.saveAll(List.of(c1));
        osRepository.saveAll(List.of(os1));
    }
}
