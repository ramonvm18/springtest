package com.example.demo.repositories;

import com.example.demo.domain.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Optional<Aluno> findByCpf(String cpf);

    boolean existsByCpf(@Param("cpf") String cpf);
}
