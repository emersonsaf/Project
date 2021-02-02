package com.example.telegrambot.repositorymysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

import com.example.telegrambot.modelmysql.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "Select username from user ", nativeQuery = true)
	List<String> usernameListNative();
}
