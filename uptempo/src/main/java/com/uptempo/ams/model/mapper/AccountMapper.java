package com.uptempo.ams.model.mapper;

import com.uptempo.ams.model.entity.Account;
import com.uptempo.ams.model.request.CreateAccountRequest;
import com.uptempo.ams.model.request.UpdateAccountRequest;
import com.uptempo.ams.model.response.AccountResponse;
import org.mapstruct.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Mapping(source = "createSessionRequest", target = "password", qualifiedByName = "encryptPassword")
    Account toAccount(CreateAccountRequest createSessionRequest);

    AccountResponse toAccountResponse(Account account);

    List<AccountResponse> toAccountResponseList(List<Account> accountList);

    @InheritInverseConfiguration
    void updateAccount(UpdateAccountRequest UpdateAccountRequest, @MappingTarget Account account);

    @Named("encryptPassword")
    static String encryptPassword(CreateAccountRequest createAccountRequest) {
        return new BCryptPasswordEncoder().encode(createAccountRequest.getPassword());
    }
}
