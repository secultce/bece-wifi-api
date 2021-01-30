package com.bece.wifi.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bece.wifi.api.entities.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
	Boolean existsByCpf(String cpf);
	Optional<Visitor> findById(Integer id);
	void deleteById(Integer id);
}
