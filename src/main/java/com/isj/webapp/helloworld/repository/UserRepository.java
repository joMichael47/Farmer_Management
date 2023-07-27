package com.isj.webapp.helloworld.repository;

import com.isj.webapp.helloworld.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}