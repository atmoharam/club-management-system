package dev.security.gate.service.infrastructure.adapter;

import dev.common.domain.cons.Action;
import dev.security.gate.service.domain.repository.SecurityLogsRepositoryInterface;
import dev.security.gate.service.infrastructure.model.entity.SecurityLog;
import dev.security.gate.service.infrastructure.model.repository.SecurityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SecurityLogsDB implements SecurityLogsRepositoryInterface {
    @Autowired
    private SecurityLogRepository securityLogRepository;

    @Override
    public SecurityLog save(SecurityLog securityLog) {
        return securityLogRepository.save(securityLog);
    }

    @Override
    public Optional<SecurityLog> findByUserId(UUID userId) {
        return securityLogRepository.findByUserId(userId);
    }

    @Override
    public Optional<SecurityLog> findByGate(String gate) {
        return securityLogRepository.findByGate(gate);
    }

    @Override
    public long countCurrentCheckInsWithoutCheckOut() {
        return securityLogRepository.countByAction(Action.Check_in.toString())
                - securityLogRepository.countByAction(Action.Check_out.toString());
    }

    @Override
    public Optional<SecurityLog> isUserLastActionCheckIn(UUID userId) {
        return securityLogRepository.findTopByUserIdOrderByTimestampDesc(userId);
    }
}
