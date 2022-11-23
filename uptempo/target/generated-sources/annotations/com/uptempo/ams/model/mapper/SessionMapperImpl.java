package com.uptempo.ams.model.mapper;

import com.uptempo.ams.model.entity.Account;
import com.uptempo.ams.model.entity.Session;
import com.uptempo.ams.model.request.CreateSessionRequest;
import com.uptempo.ams.model.response.AccountResponse;
import com.uptempo.ams.model.response.SessionResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-23T12:17:25+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Azul Systems, Inc.)"
)
@Component
public class SessionMapperImpl implements SessionMapper {

    @Override
    public Session toSession(CreateSessionRequest createSessionRequest) {
        if ( createSessionRequest == null ) {
            return null;
        }

        Session session = new Session();

        return session;
    }

    @Override
    public SessionResponse toSessionResponse(Session session) {
        if ( session == null ) {
            return null;
        }

        SessionResponse sessionResponse = new SessionResponse();

        sessionResponse.setId( session.getId() );
        sessionResponse.setIpAddress( session.getIpAddress() );
        sessionResponse.setAccount( accountToAccountResponse( session.getAccount() ) );

        return sessionResponse;
    }

    @Override
    public List<SessionResponse> toSessionResponseList(List<Session> sessionList) {
        if ( sessionList == null ) {
            return null;
        }

        List<SessionResponse> list = new ArrayList<SessionResponse>( sessionList.size() );
        for ( Session session : sessionList ) {
            list.add( toSessionResponse( session ) );
        }

        return list;
    }

    protected AccountResponse accountToAccountResponse(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountResponse accountResponse = new AccountResponse();

        accountResponse.setId( account.getId() );
        accountResponse.setEmail( account.getEmail() );
        accountResponse.setRegisteredAt( account.getRegisteredAt() );
        accountResponse.setMarkedForDeletion( account.isMarkedForDeletion() );

        return accountResponse;
    }
}
