package com.example.demo.domain.mappers;

import com.example.demo.domain.entities.Professor;
import com.example.demo.domain.dto.v1.ProfessorDto;

public class ProfessorMapper {

    public static Professor toEntity(ProfessorDto dto) {
        return Professor
                .builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .build();
    }

    public static ProfessorDto toDto(Professor entity, String activity) {
        return new ProfessorDto(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail(),
                activity);
    }
}
