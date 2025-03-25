package dev.sport.service.application;

import dev.sport.service.infrastructure.adapter.SportDB;
import dev.sport.service.infrastructure.adapter.SportSessionDB;
import dev.sport.service.infrastructure.model.entites.Sport;
import dev.sport.service.infrastructure.model.entites.SportSession;
import dev.sport.service.interface_adapters.dto.SessionDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class SessionUseCase {
    SportSessionDB sportSessionDB;
    SportDB sportDB;

    public SportSession createSession(SessionDTO session) {
        log.info("Creating new session {}" , session.getSportId());
        Sport sport = sportDB.findById
                (UUID.fromString(session.getSportId())).orElse(null);
        if (sport != null) {
            SportSession sportSession = SportSession.builder()
                    .sport(sport)
                    .startTime(Instant.parse(session.getStartTime()))
                    .endTime(Instant.parse(session.getStartTime()))
                    .trainerId(UUID.fromString(session.getTarinerId()))
                    .location(session.getLocation())
                .build();
            return sportSessionDB.save(sportSession);
        }
        return null;
    }
    public SportSession getSession(UUID sessionId) {
        return sportSessionDB.getById(sessionId).orElse(null);
    }
    public List<SportSession> getSessionBySportName(String sportName) {
        return sportSessionDB.getSessionsBySportName(sportName).stream().toList();
    }
    public List<SportSession> getSessionByTrainerId(UUID trainerId) {
        return sportSessionDB.getSessionsByTrainerId(trainerId).stream().toList();

    }

}
