package br.com.motocode.service;

import br.com.motocode.domain.User;
import br.com.motocode.exceptions.BadRequestException;
import br.com.motocode.mapper.UserMapper;
import br.com.motocode.repository.UserRepository;
import br.com.motocode.requests.UserPostRequestBody;
import br.com.motocode.requests.UserPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Page<User> listAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public List<User>  listAllNoPageable() {
        return userRepository.findAll();
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public User findByIdOrThrowBadRequestException(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not Found"));
    }

    public User save(UserPostRequestBody userPostRequestBody) {
        System.out.println(userPostRequestBody);
        return userRepository.save(UserMapper.INSTANCE.toUser(userPostRequestBody));
    }

    public void delete(long id) {
        userRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(UserPutRequestBody userPutRequestBody) {
        User savedUser = findByIdOrThrowBadRequestException(userPutRequestBody.getId());
        User user = UserMapper.INSTANCE.toUser(userPutRequestBody);
        user.setId(savedUser.getId());
        userRepository.save(user);
    }

}
