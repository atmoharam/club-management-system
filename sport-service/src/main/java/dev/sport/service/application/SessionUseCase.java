package dev.sport.service.application;

import dev.sport.service.infrastructure.adapter.SportDB;
import dev.sport.service.infrastructure.adapter.SportSessionDB;
import dev.sport.service.infrastructure.model.entites.Sport;
import dev.sport.service.infrastructure.model.entites.SportSession;
import dev.sport.service.interface_adapters.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionUseCase {
    @Autowired
    SportSessionDB sportSessionDB;
    @Autowired
    SportDB sportDB;

    public SportSession createSession(SessionDTO session) {
        Sport sport = sportDB.findById(session.getSportId()).orElse(null);
        if (sport != null) {
            SportSession sportSession = SportSession.builder()
                    .sport(sport)
                    .startTime(session.getStartTime())
                    .endTime(session.getEndTime())
                    .trainerId(session.getTarinerId())
                    .location(session.getLocation())
                .build();
            return sportSessionDB.save(sportSession);
        }
        return null;
    }
//    public SportSession getSession(String sessionId) {}
//    public SportSession getSessionBySportId(String sportId) {}
//    public SportSession getSessionByTrainerId(String trainerId) {}

}
