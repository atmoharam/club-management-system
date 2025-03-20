package dev.sport.service.infrastructure.adapter;

import dev.sport.service.domain.repository.SportSessionRepositoryInterface;
import dev.sport.service.infrastructure.model.entites.SportSession;
import dev.sport.service.infrastructure.model.repository.SportSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportSessionDB implements SportSessionRepositoryInterface {
    final SportSessionRepository sportSessionRepository;

    public SportSessionDB(SportSessionRepository sportSessionRepository) {
        this.sportSessionRepository = sportSessionRepository;
    }

    @Override
    public SportSession save(SportSession sportSession) {
        return sportSessionRepository.save(sportSession);
    }
}
