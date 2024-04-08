package com.example.demo.service;

import com.example.demo.domain.dto.v1.AlunoDto;
import com.example.demo.domain.dto.v1.ProfessorDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService implements IAlunoService {
    private final List<AlunoDto> alunos = new ArrayList<>();
    private int id = 1;

    @Override
    public int criarAluno(String nome) {

        alunos.add(new AlunoDto(id, nome));
        return id++;
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return alunos;
    }

    @Override
    public AlunoDto buscarAluno(@PathVariable("id") int id) {
        Optional<AlunoDto> aluno = alunos
                .stream()
                .filter(it -> it.getId() == id)
                .findFirst();
        return aluno.orElse(null);
    }

    @Override
    public void atualizarAluno(int id, String nome) {
        Optional<AlunoDto> aluno = alunos
                .stream()
                .filter(it -> it.getId() == id)
                .findFirst();
        if(aluno.isPresent()) {
            alunos.remove(aluno.get());
            alunos.add(new AlunoDto(id, nome));
        }
    }
}
