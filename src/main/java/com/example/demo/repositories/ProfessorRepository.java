package com.example.demo.repositories;

import com.example.demo.domain.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Optional<Professor> findByCpf(String cpf);

    boolean existsByCpf(@Param("cpf") String cpf);
}
