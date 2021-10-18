package fernandes.alisson.sosystem.application.controllers.TechnicianController;

import fernandes.alisson.sosystem.domain.model.Technician;
import fernandes.alisson.sosystem.domain.usecases.Technician.GetById.GetByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technician")
public class TechnicianController {

    @Autowired
    private GetByIdUseCase getByIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Technician> findById(@PathVariable Long id){
        Technician obj = getByIdUseCase.execute(id);
        return ResponseEntity.ok().body(obj);
    }
}
