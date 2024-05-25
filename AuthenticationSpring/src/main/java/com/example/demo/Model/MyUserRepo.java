package com.example.demo.Model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Long> {
	Optional<MyUser>findByName(String username);
}
