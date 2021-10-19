package fernandes.alisson.sosystem.domain.usecases.OS.OsGetByIdUseCase;

import fernandes.alisson.sosystem.domain.model.Os;

public interface OsGetByIdUseCase {
    public Os execute(Long id);
}
