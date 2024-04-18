package com.example.demo.domain.dto.v1;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties

public class AlunoDto {

    private int id;

    @NotBlank
    private String nome;

    @CPF
    private String cpf;

    @Email
    private String email;

    @Null
    private String activity;
}
