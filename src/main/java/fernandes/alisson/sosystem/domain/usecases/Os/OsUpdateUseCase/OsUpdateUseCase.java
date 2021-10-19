package fernandes.alisson.sosystem.domain.usecases.Os.OsUpdateUseCase;

import fernandes.alisson.sosystem.application.dtos.OsDTO;
import fernandes.alisson.sosystem.domain.model.Os;

public interface OsUpdateUseCase {
    public Os execute(OsDTO objDTO);
}
