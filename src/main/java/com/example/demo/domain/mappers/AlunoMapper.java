package com.example.demo.domain.mappers;

import com.example.demo.domain.dto.v1.AlunoDto;
import com.example.demo.domain.entities.Aluno;

public class AlunoMapper {

    public static Aluno toEntity(AlunoDto dto) {
        return Aluno
                .builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .build();
    }

    public static AlunoDto toDto(Aluno entity) {
        return new AlunoDto(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail());
    }
}
