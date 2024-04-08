package com.example.demo.view;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.demo.domain.dto.v1.ProfessorDto;
import com.example.demo.service.IProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {


    private final IProfessorService servico;

    @Autowired
    public ProfessorController(IProfessorService servico) {
        this.servico = servico;
    }

    @GetMapping
    public List<ProfessorDto> lerProfessores() {
        return servico.listarProfessores();
    }


    @PostMapping
    public int criarProfessor(@RequestBody @Valid ProfessorDto pedido) {
        return servico.criarProfessor(pedido);
    }

    @PutMapping("/{id}")
    public void atualizarProfessor(@PathVariable("id") int id,
                                   @RequestBody ProfessorDto pedido
    ) {
        servico.atualizarProfessor(id, pedido);

    }

    @GetMapping("/{id}")
    public ProfessorDto buscarProfessor(@PathVariable("id") int id) {
        return servico.buscarProfessor(id);
    }

}
