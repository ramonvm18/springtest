package com.example.demo.service;

import com.example.demo.domain.dto.v1.AlunoDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AlunoService implements IAlunoService {
    private final List<AlunoDto> alunos = new ArrayList<>();
    private int id = 1;

    @Override
    public int criarAluno(AlunoDto novoAluno) {

        alunos.add(new AlunoDto(id, novoAluno.getNome(), novoAluno.getCpf(), novoAluno.getEmail()));
        return id++;
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return alunos;
    }

    @Override
    public AlunoDto buscarAluno(@PathVariable("id") int id) {
        return alunos.stream().filter(it -> it.getId() == id).findFirst().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void atualizarAluno(int id, AlunoDto pedido) {
        final AlunoDto aluno = buscarAluno(id);
        alunos.remove(aluno);
        alunos.add(new AlunoDto(aluno.getId(), pedido.getNome(), pedido.getCpf(), pedido.getEmail()));
    }
}
