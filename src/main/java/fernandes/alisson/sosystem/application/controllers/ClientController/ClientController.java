package fernandes.alisson.sosystem.application.controllers.ClientController;

import fernandes.alisson.sosystem.application.dtos.ClientDTO;
import fernandes.alisson.sosystem.domain.model.Client;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientCreateUseCase.ClientCreateUseCase;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientDeleteUseCase.ClientDeleteUseCase;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientGetAllUseCase.ClientGetAllUseCase;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientGetByIdUseCase.ClientGetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.Client.ClientUpdateUseCase.ClientUpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientGetByIdUseCase clientGetByIdUseCase;

    @Autowired
    private ClientGetAllUseCase clientGetAllUseCase;

    @Autowired
    private ClientCreateUseCase clientCreateUseCase;

    @Autowired
    private ClientUpdateUseCase clientUpdateUseCase;

    @Autowired
    private ClientDeleteUseCase clientDeleteUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        ClientDTO objDTO = new ClientDTO(clientGetByIdUseCase.execute(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll(){
        List<ClientDTO> listDto = clientGetAllUseCase.execute()
                .stream().map(ClientDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO objDTO) {
        Client obj = clientCreateUseCase.execute(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @Valid @RequestBody ClientDTO objDTO) {
        ClientDTO obj = new ClientDTO(clientUpdateUseCase.execute(id, objDTO));
        return ResponseEntity.ok().body(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientDeleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}
