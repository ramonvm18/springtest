package com.example.demo.service;

import com.example.demo.domain.dto.v1.AlunoDto;
import com.example.demo.domain.dto.v1.ProfessorDto;
import com.example.demo.domain.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class AlunoService implements IAlunoService {
    private final List<AlunoDto> alunos = new ArrayList<>();
    private int id = 1;

    @Override
    public AlunoDto criarAluno(AlunoDto novoAluno) {
        final AlunoDto p = new AlunoDto(
                id++,
                novoAluno.getNome(),
                novoAluno.getCpf(),
                novoAluno.getEmail()
        );
        alunos.add(p);
        return p;
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return alunos;
    }

    @Override
    public AlunoDto buscarAluno(int id) throws NotFoundException {
        return alunos
                .stream()
                .filter(it -> it.getId()==id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(AlunoDto.class, String.valueOf(id)));
    }

    @Override
    public AlunoDto atualizarAluno(int id, AlunoDto pedido) {
        final AlunoDto aluno = alunos.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
        if (aluno == null) {
            return null;
        }
        alunos.remove(aluno);
        final AlunoDto p = new AlunoDto(aluno.getId(), pedido.getNome(), pedido.getCpf(), pedido.getEmail());
        alunos.add(p);
        return p;
    }

    @Override
    public void removerAluno(int id) throws NotFoundException {
        final AlunoDto aluno = buscarAluno(id);
        alunos.remove(aluno);
    }

    @Override
    public AlunoDto buscarPorCpf(String cpf) throws NotFoundException {
        return null;
    }
}
