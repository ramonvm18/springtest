package com.example.demo.service;

import com.example.demo.domain.dto.v1.ProfessorDto;
import com.example.demo.domain.exception.NotFoundException;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface IProfessorService {
    ProfessorDto criarProfessor(ProfessorDto pedido);

    List<ProfessorDto> listarProfessores();

    ProfessorDto buscarProfessor(int id) throws NotFoundException;

    ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) throws NotFoundException;

    void removerProfessor(int id) throws NotFoundException;

    ProfessorDto buscarPorCpf(String cpf) throws NotFoundException;




}
