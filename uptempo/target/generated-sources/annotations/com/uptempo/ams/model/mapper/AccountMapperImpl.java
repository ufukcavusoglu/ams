package com.uptempo.ams.model.mapper;

import com.uptempo.ams.model.entity.Account;
import com.uptempo.ams.model.request.CreateAccountRequest;
import com.uptempo.ams.model.request.UpdateAccountRequest;
import com.uptempo.ams.model.response.AccountResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-23T12:17:24+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Azul Systems, Inc.)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toAccount(CreateAccountRequest createSessionRequest) {
        if ( createSessionRequest == null ) {
            return null;
        }

        Account account = new Account();

        account.setPassword( AccountMapper.encryptPassword( createSessionRequest ) );
        account.setEmail( createSessionRequest.getEmail() );

        return account;
    }

    @Override
    public AccountResponse toAccountResponse(Account account) {
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

    @Override
    public List<AccountResponse> toAccountResponseList(List<Account> accountList) {
        if ( accountList == null ) {
            return null;
        }

        List<AccountResponse> list = new ArrayList<AccountResponse>( accountList.size() );
        for ( Account account : accountList ) {
            list.add( toAccountResponse( account ) );
        }

        return list;
    }

    @Override
    public void updateAccount(UpdateAccountRequest UpdateAccountRequest, Account account) {
        if ( UpdateAccountRequest == null ) {
            return;
        }

        account.setEmail( UpdateAccountRequest.getEmail() );
        if ( UpdateAccountRequest.getMarkedForDeletion() != null ) {
            account.setMarkedForDeletion( UpdateAccountRequest.getMarkedForDeletion() );
        }
    }
}
