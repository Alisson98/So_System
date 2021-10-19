package fernandes.alisson.sosystem.application.controllers.OsController;


import fernandes.alisson.sosystem.application.dtos.OsDTO;
import fernandes.alisson.sosystem.domain.usecases.OS.OsGetByIdUseCase.OsGetByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/os")
public class OsController {

    @Autowired
    private OsGetByIdUseCase osGetByIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<OsDTO> findById(@PathVariable Long id){
        OsDTO obj = new OsDTO(osGetByIdUseCase.execute(id));
        return ResponseEntity.ok().body(obj);
    }
}
