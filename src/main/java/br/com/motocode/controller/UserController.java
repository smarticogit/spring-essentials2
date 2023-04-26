package br.com.motocode.controller;

import br.com.motocode.domain.User;
import br.com.motocode.requests.UserPostRequestBody;
import br.com.motocode.requests.UserPutRequestBody;
import br.com.motocode.service.UserService;
import br.com.motocode.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("users")
@Log4j2
@RequiredArgsConstructor
public class UserController {
    private final DateUtil dateUtil;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> list(Pageable pageable) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(userService.listAll(pageable));
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> listAll() {
         log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(userService.listAllNoPageable());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(userService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<User>> findById(@RequestParam String name) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(userService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody  @Valid UserPostRequestBody userPostRequestBody){
        System.out.println(userPostRequestBody);
        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody UserPutRequestBody userPutRequestBody) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
         userService.replace(userPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
