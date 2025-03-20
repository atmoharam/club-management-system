package dev.security.gate.service.domain.model.entites;

import dev.common.domain.cons.Action;

import java.time.Instant;
import java.util.UUID;

public class DomainSecurityLog {
    private UUID userId;
    private String gate;
    private Instant timestamp;
    private Action action;
}
