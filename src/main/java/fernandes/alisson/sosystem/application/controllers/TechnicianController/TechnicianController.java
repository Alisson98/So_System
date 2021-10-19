package fernandes.alisson.sosystem.application.controllers.TechnicianController;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianCreateUseCase.CreateUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianDeleteUseCase.DeleteUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetAllUseCase.GetAllUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianGetByIdUseCase.GetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.TechnicianUpdateUseCase.UpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/technician")
public class TechnicianController {

    @Autowired
    private GetByIdUseCase getByIdUseCase;

    @Autowired
    private GetAllUseCase getAllUseCase;

    @Autowired
    private CreateUseCase createUseCase;

    @Autowired
    private UpdateUseCase updateUseCase;

    @Autowired
    private DeleteUseCase deleteUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable Long id){
        TechnicianDTO objDTO = new TechnicianDTO(getByIdUseCase.execute(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> findAll(){
        List<TechnicianDTO> listDto = getAllUseCase.execute()
                .stream().map(TechnicianDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<TechnicianDTO> create(@Valid @RequestBody TechnicianDTO objDTO) {
        Technician obj = createUseCase.execute(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnicianDTO> update(@PathVariable Long id, @Valid @RequestBody TechnicianDTO objDTO) {
        TechnicianDTO obj = new TechnicianDTO(updateUseCase.execute(id, objDTO));
        return ResponseEntity.ok().body(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}
