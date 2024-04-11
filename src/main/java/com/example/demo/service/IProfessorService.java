package com.example.demo.service;

import com.example.demo.domain.dto.v1.ProfessorDto;
import com.example.demo.domain.dto.v1.exception.NotFoundException;

import java.util.List;

public interface IProfessorService {
    ProfessorDto criarProfessor(ProfessorDto pedido);

    List<ProfessorDto> listarProfessores();

    ProfessorDto buscarProfessor(int id) throws NotFoundException;

    ProfessorDto atualizarProfessor(int id, ProfessorDto pedido);

    void removerProfessor(int id) throws NotFoundException;


}
