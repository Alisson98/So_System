package fernandes.alisson.sosystem.application.controllers.OsController;


import fernandes.alisson.sosystem.application.dtos.OsDTO;
import fernandes.alisson.sosystem.domain.usecases.Os.OsGetAllUseCase.OsGetAllUseCase;
import fernandes.alisson.sosystem.domain.usecases.Os.OsGetByIdUseCase.OsGetByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/os")
public class OsController {

    @Autowired
    private OsGetByIdUseCase osGetByIdUseCase;

    @Autowired
    private OsGetAllUseCase osGetAllUseCase;

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
}
