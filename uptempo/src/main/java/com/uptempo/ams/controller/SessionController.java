package com.uptempo.ams.controller;

import com.uptempo.ams.model.entity.Session;
import com.uptempo.ams.model.mapper.SessionMapper;
import com.uptempo.ams.model.request.CreateSessionRequest;
import com.uptempo.ams.model.response.CreateSessionResponse;
import com.uptempo.ams.model.response.SessionResponse;
import com.uptempo.ams.security.JwtTokenUtility;
import com.uptempo.ams.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;
    private final SessionMapper sessionMapper;
    private final JwtTokenUtility jwtTokenUtility;



    @PostMapping
    public ResponseEntity<CreateSessionResponse> createSession(@RequestBody CreateSessionRequest createSessionRequest){
        Session session = sessionService.save(createSessionRequest);
        CreateSessionResponse createSessionResponse = new CreateSessionResponse();
        createSessionResponse.setSession(sessionMapper.toSessionResponse(session));
        createSessionResponse.setToken(jwtTokenUtility.generateAccessToken(session.getAccount()));
        return ResponseEntity.ok(createSessionResponse);
    }

    @GetMapping
    public ResponseEntity<Page<SessionResponse>> getSessions(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "20") Integer size){
        Page<Session> sessionList = sessionService.findAll(page, size);
        Page<SessionResponse> responsePage = sessionList.map(sessionMapper::toSessionResponse);
        return ResponseEntity.ok(responsePage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable("id") UUID id){
        sessionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
