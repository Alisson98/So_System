package fernandes.alisson.sosystem.application.controllers.TechnicianController;

import fernandes.alisson.sosystem.application.dtos.TechnicianDTO;
import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.CreateUseCase.CreateUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.GetAllUseCase.GetAllUseCase;
import fernandes.alisson.sosystem.domain.usecases.Technician.GetByIdUseCase.GetByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
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
    public ResponseEntity<TechnicianDTO> create(@RequestBody TechnicianDTO objDTO) {
        Technician obj = createUseCase.execute(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
