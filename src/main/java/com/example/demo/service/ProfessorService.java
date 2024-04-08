package com.example.demo.service;

import com.example.demo.domain.dto.v1.ProfessorDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProfessorService implements IProfessorService {
    private final List<ProfessorDto> professores = new ArrayList<>();
    private int id = 1;

    @Override
    public int criarProfessor(ProfessorDto novoProfessor) {

        professores.add(new ProfessorDto(id, novoProfessor.getNome(), novoProfessor.getCpf(), novoProfessor.getEmail()));
        return id++;
    }

    @Override
    public List<ProfessorDto> listarProfessores() {
        return professores;
    }

    @Override
    public ProfessorDto buscarProfessor(@PathVariable("id") int id) {
        return professores.stream().filter(it -> it.getId() == id).findFirst().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void atualizarProfessor(int id, ProfessorDto pedido) {
        final ProfessorDto professor = buscarProfessor(id);
        professores.remove(professor);
        professores.add(new ProfessorDto(professor.getId(), pedido.getNome(), pedido.getCpf(), pedido.getEmail()));
    }
}
