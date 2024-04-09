package com.example.demo.view;


import com.example.demo.domain.dto.v1.AlunoDto;
import com.example.demo.service.IAlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {


    private final IAlunoService servico;

    @Autowired
    public AlunoController(IAlunoService servico) {
        this.servico = servico;
    }

    @GetMapping
    public List<AlunoDto> lerAlunos() {
        return servico.listarAlunos();
    }


    @PostMapping
    public int criarAluno(@RequestBody @Valid AlunoDto pedido) {
        return servico.criarAluno(pedido);
    }

    @PutMapping("/{id}")
    public void atualizarAluno(@PathVariable("id") int id,
                                   @RequestBody AlunoDto pedido
    ) {
        servico.atualizarAluno(id, pedido);
    }

    @GetMapping("/{id}")
    public AlunoDto buscarAluno(@PathVariable("id") int id) {
        return servico.buscarAluno(id);
    }

}
