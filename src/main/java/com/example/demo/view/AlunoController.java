package com.example.demo.view;
import com.example.demo.domain.dto.v1.AlunoDto;
import com.example.demo.domain.exception.NotFoundException;
import com.example.demo.service.IAlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AlunoDto>> lerAlunos() {
        return ResponseEntity.ok(servico.listarAlunos());
    }


    @PostMapping
    public ResponseEntity<AlunoDto> criarAluno(
            @RequestBody @Valid AlunoDto pedido
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.criarAluno(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> atualizarAluno(
            @PathVariable("id") int id,
            @RequestBody AlunoDto pedido
    ) {
        final AlunoDto p = servico.atualizarAluno(id, pedido);

        if (p == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> buscarAluno(
            @PathVariable("id") int id
    ) throws NotFoundException {
        return ResponseEntity.ok(servico.buscarAluno(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAluno(
            @PathVariable("id") int id
    ) throws NotFoundException {
        servico.removerAluno(id);
        return ResponseEntity.noContent().build();
    }

}
