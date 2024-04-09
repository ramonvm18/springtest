package com.example.demo.service;

import com.example.demo.domain.dto.v1.AlunoDto;

import java.util.List;

public interface IAlunoService {
    int criarAluno(AlunoDto pedido);
    List<AlunoDto> listarAlunos();
    AlunoDto buscarAluno(int id);
    void atualizarAluno(int id, AlunoDto pedido);
}
