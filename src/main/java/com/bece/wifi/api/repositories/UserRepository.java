package com.bece.wifi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bece.wifi.api.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Boolean existsByEmail(String email);
}
