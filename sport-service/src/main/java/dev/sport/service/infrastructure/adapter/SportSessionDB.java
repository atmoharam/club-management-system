package dev.sport.service.infrastructure.adapter;

import dev.sport.service.domain.repository.SportSessionRepositoryInterface;
import dev.sport.service.infrastructure.model.entites.Sport;
import dev.sport.service.infrastructure.model.entites.SportSession;
import dev.sport.service.infrastructure.model.repository.SportSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SportSessionDB implements SportSessionRepositoryInterface {
    final SportSessionRepository sportSessionRepository;
    final SportDB sportDB;

    @Override
    public SportSession save(SportSession sportSession) {
        return sportSessionRepository.save(sportSession);
    }

    @Override
    public Optional<SportSession> getById(UUID sessionId) {
        return sportSessionRepository.findById(sessionId);
    }

    @Override
    public List<SportSession> getSessionsBySportName(String sportName) {
        Sport sport = sportDB.findBySportName(sportName).orElse(null);
        if (sport != null) {
            return sportSessionRepository.findAllBySport(sport);
        }
        return null;
    }

    @Override
    public List<SportSession> getSessionsByTrainerId(UUID trainerId) {
        return sportSessionRepository.findAllByTrainerId(trainerId);
    }
}
