package org.app.mealmap.user.service;

import org.app.mealmap.user.dto.AuthRequest;
import org.app.mealmap.user.dto.AuthResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthService {

    public Mono<AuthResponse> login(Mono<AuthRequest> authRequestMono) {
        return null;
    }

    public Mono<AuthResponse> register(Mono<AuthRequest> authRequestMono) {
        return null;
    }
}
