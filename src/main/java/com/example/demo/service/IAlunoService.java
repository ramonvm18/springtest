package com.example.demo.service;

import com.example.demo.domain.dto.v1.AlunoDto;
import com.example.demo.domain.exception.NotFoundException;

import java.util.List;

public interface IAlunoService {

    AlunoDto criarAluno(AlunoDto pedido);

    List<AlunoDto> listarAlunos();

    AlunoDto buscarAluno(int id) throws NotFoundException;

    AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException;

    void removerAluno(int id) throws NotFoundException;

    AlunoDto buscarPorCpf(String cpf) throws NotFoundException;
}
