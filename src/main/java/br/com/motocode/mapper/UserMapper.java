package br.com.motocode.mapper;

import br.com.motocode.domain.User;
import br.com.motocode.requests.UserPostRequestBody;
import br.com.motocode.requests.UserPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract User toUser(UserPostRequestBody userPostRequestBody);

    public abstract User toUser(UserPutRequestBody userPutRequestBody);
}
