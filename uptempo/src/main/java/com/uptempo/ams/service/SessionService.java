package com.uptempo.ams.service;

import com.uptempo.ams.config.IPAddressInterceptor;
import com.uptempo.ams.model.entity.Account;
import com.uptempo.ams.model.entity.Session;
import com.uptempo.ams.model.entity.SessionEntityGraph;
import com.uptempo.ams.model.request.CreateSessionRequest;
import com.uptempo.ams.repository.SessionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final IPAddressInterceptor ipAddressInterceptor;
    private final AccountService accountService;

    public Page<Session> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        SessionEntityGraph entityGraph = SessionEntityGraph.____().account().____.____();
        return sessionRepository.findAll(pageable, entityGraph);
    }

    @Transactional
    public void deleteById(UUID id) {
        try{
            sessionRepository.deleteById(id);
        }catch (EmptyResultDataAccessException ignored) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public Session save(CreateSessionRequest createSessionRequest){
        Account account = accountService.findByEmail(createSessionRequest.getEmail());
        validatePassword(createSessionRequest.getPassword(), account);
        Session session = new Session();
        session.setAccount(account);
        session.setIpAddress(ipAddressInterceptor.getIpAddress());
        return sessionRepository.save(session);
    }

    private static void validatePassword(String password, Account account) {
        if(account.getPassword().equals(new BCryptPasswordEncoder().encode(password)))
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
    }
}
