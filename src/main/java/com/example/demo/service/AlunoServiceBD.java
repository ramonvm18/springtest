package com.example.demo.service;

import com.example.demo.domain.dto.v1.AlunoDto;
import com.example.demo.domain.dto.v1.ProfessorDto;
import com.example.demo.domain.entities.Aluno;
import com.example.demo.domain.entities.Professor;
import com.example.demo.domain.exception.NotFoundException;
import com.example.demo.domain.mappers.AlunoMapper;
import com.example.demo.domain.mappers.ProfessorMapper;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.repositories.ProfessorRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AlunoServiceBD implements IAlunoService {

    private final AlunoRepository repositorio;

    public AlunoServiceBD(AlunoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public AlunoDto criarAluno(AlunoDto pedido) {

        Aluno p = AlunoMapper.toEntity(pedido);

        return AlunoMapper.toDto(repositorio.save(p));
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return repositorio.findAll().stream().map(AlunoMapper::toDto).toList();
    }

    @Override
    public AlunoDto buscarAluno(int id) throws NotFoundException {
        return AlunoMapper.toDto(repositorio
                .findById(id)
                .orElseThrow(() -> new NotFoundException(Aluno.class, String.valueOf(id))));
    }

    @Override
    public AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException {
        final Aluno p = repositorio.findById(id).orElseThrow(() -> new NotFoundException(Professor.class, String.valueOf(id)));
        p.setCpf(pedido.getCpf());
        p.setNome(pedido.getNome());
        p.setEmail(pedido.getEmail());

        return AlunoMapper.toDto(repositorio.save(p));
    }

    @Override
    public void removerAluno(int id) throws NotFoundException {

        final Aluno p = repositorio.findById(id).orElseThrow(() -> new NotFoundException(Professor.class, String.valueOf(id)));
        repositorio.delete(p);
        repositorio.deleteById(id);

    }

    private Aluno buscarAlunoPorId(int id) throws NotFoundException {
        return repositorio.findById(id).orElseThrow(() -> new NotFoundException(Aluno.class, String.valueOf(id)));
    }

    @Override
    public AlunoDto buscarPorCpf(String cpf) throws NotFoundException {
        return AlunoMapper.toDto(repositorio.findByCpf(cpf).orElseThrow(() -> new NotFoundException(Professor.class, cpf)));
    }
}
