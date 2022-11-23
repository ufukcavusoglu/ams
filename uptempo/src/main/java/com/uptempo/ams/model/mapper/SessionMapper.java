package com.uptempo.ams.model.mapper;

import com.uptempo.ams.model.entity.Session;
import com.uptempo.ams.model.request.CreateSessionRequest;
import com.uptempo.ams.model.response.SessionResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SessionMapper {

    Session toSession(CreateSessionRequest createSessionRequest);

    SessionResponse toSessionResponse(Session session);

    List<SessionResponse> toSessionResponseList(List<Session> sessionList);

}
