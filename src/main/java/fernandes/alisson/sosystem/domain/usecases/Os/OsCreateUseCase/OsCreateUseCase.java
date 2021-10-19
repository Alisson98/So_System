package fernandes.alisson.sosystem.domain.usecases.Os.OsCreateUseCase;

import fernandes.alisson.sosystem.application.dtos.OsDTO;
import fernandes.alisson.sosystem.domain.model.Os;

public interface OsCreateUseCase {
    public Os execute(OsDTO objDTO);
}
