package com.example.demo.service;

import com.example.demo.domain.dto.v1.ProfessorDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService implements IProfessorService {
    private final List<ProfessorDto> professores = new ArrayList<>();
    private int id = 1;

    @Override
    public int criarProfessor(String nome) {

        professores.add(new ProfessorDto(id, nome));
        return id++;
    }

    @Override
    public List<ProfessorDto> listarProfessores() {
        return professores;
    }

    @Override
    public ProfessorDto buscarProfessor(@PathVariable("id") int id) {
        Optional<ProfessorDto> professor = professores
                .stream()
                .filter(it -> it.getId() == id)
                .findFirst();
        return professor.orElse(null);
    }

    @Override
    public void atualizarProfessor(int id, String nome) {
        Optional<ProfessorDto> professor = professores
                .stream()
                .filter(it -> it.getId() == id)
                .findFirst();
        if(professor.isPresent()) {
            professores.remove(professor.get());
            professores.add(new ProfessorDto(id, nome));
        }
    }
}
