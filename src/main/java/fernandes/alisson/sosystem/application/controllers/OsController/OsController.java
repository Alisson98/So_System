package fernandes.alisson.sosystem.application.controllers.OsController;


import fernandes.alisson.sosystem.application.dtos.OsDTO;
import fernandes.alisson.sosystem.domain.usecases.Os.OsCreateUseCase.OsCreateUseCase;
import fernandes.alisson.sosystem.domain.usecases.Os.OsGetAllUseCase.OsGetAllUseCase;
import fernandes.alisson.sosystem.domain.usecases.Os.OsGetByIdUseCase.OsGetByIdUseCase;
import fernandes.alisson.sosystem.domain.usecases.Os.OsUpdateUseCase.OsUpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/os")
public class OsController {

    @Autowired
    private OsGetByIdUseCase osGetByIdUseCase;

    @Autowired
    private OsGetAllUseCase osGetAllUseCase;

    @Autowired
    private OsCreateUseCase osCreateUseCase;

    @Autowired
    private OsUpdateUseCase osUpdateUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<OsDTO> findById(@PathVariable Long id){
        OsDTO obj = new OsDTO(osGetByIdUseCase.execute(id));
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<OsDTO>> findAll(){
        List<OsDTO> listDTO =  osGetAllUseCase.execute()
                .stream().map(OsDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<OsDTO> create(@Valid @RequestBody OsDTO objDTO) {
        objDTO = new OsDTO(osCreateUseCase.execute(objDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(objDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(objDTO);
    }
    @PutMapping
    public ResponseEntity<OsDTO> update(@Valid @RequestBody OsDTO objDTO){
        objDTO = new OsDTO(osUpdateUseCase.execute(objDTO));
        return ResponseEntity.ok().body(objDTO);
    }
}
