package br.com.motocode.client;

import br.com.motocode.domain.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<User> entity = new RestTemplate().getForEntity("http://localhost:8080/users/{id}", User.class, 2);
        log.info(entity);

        User object = new RestTemplate().getForObject("http://localhost:8080/users/{id}", User.class, 2);
        log.info(object);

        User[] users = new RestTemplate().getForObject("http://localhost:8080/users/all", User[].class);
        log.info(Arrays.toString(users));

        ResponseEntity<List<User>> exchange = new RestTemplate().exchange(
                "http://localhost:8080/users/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                });
        log.info(exchange.getBody());
    }
}
