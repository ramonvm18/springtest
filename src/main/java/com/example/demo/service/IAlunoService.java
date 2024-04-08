package com.example.demo.service;

import com.example.demo.domain.dto.v1.AlunoDto;
import com.example.demo.domain.dto.v1.ProfessorDto;

import java.util.List;

public interface IAlunoService {
    int criarAluno(String nome);
    List<AlunoDto> listarAlunos();
    AlunoDto buscarAluno(int id);
    void atualizarAluno(int id, String nome);
}
