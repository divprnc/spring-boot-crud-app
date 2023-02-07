package com.restful.ws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.ws.entity.User;


//@Transactional -> all the methods is implemented by a SimpleJpaRepository class are by default transactional
// By default all public methods in SimpleJpaRepository are transactional
public interface UserRepository extends JpaRepository<User, Long>{ 
	Optional<User> findByEmail(String email);
}
