package br.com.motocode.repository;

import br.com.motocode.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByName(String name);
}
