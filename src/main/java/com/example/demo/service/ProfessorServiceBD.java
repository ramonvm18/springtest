package com.example.demo.service;

import com.example.demo.domain.entities.Professor;
import com.example.demo.domain.exception.NotFoundException;
import com.example.demo.domain.mappers.ProfessorMapper;
import com.example.demo.domain.dto.v1.ProfessorDto;
import com.example.demo.external.FeignBoredApi;
import com.example.demo.external.RestBoredApi;
import com.example.demo.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class ProfessorServiceBD implements IProfessorService {

    private final ProfessorRepository repositorio;
    private final FeignBoredApi boredApi;

    @Override
    public ProfessorDto criarProfessor(ProfessorDto pedido) {

        Professor p = ProfessorMapper.toEntity(pedido);

        return ProfessorMapper.toDto(repositorio.save(p), boredApi.getActivity().activity());
    }

    @Override
    public List<ProfessorDto> listarProfessores() {
        return repositorio
                .findAll()
                .stream()
                .map(ent -> ProfessorMapper.toDto(ent, boredApi.getActivity().activity()))
                .toList();
    }

    @Override
    public ProfessorDto buscarProfessor(int id) throws NotFoundException {
        System.out.println(boredApi.getActivity());
        return ProfessorMapper.toDto(buscarProfessorPorId(id), boredApi.getActivity().activity());
    }

    @Override
    public ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) throws NotFoundException {
        final Professor p = repositorio.findById(id).orElseThrow(() -> new NotFoundException(Professor.class, String.valueOf(id)));
        p.setCpf(pedido.getCpf());
        p.setNome(pedido.getNome());
        p.setEmail(pedido.getEmail());

        return ProfessorMapper.toDto(repositorio.save(p), boredApi.getActivity().activity());
    }

    @Override
    public void removerProfessor(int id) throws NotFoundException {

        final Professor p = repositorio.findById(id).orElseThrow(() -> new NotFoundException(Professor.class, String.valueOf(id)));
        repositorio.delete(p);
        repositorio.deleteById(id);

    }

    private Professor buscarProfessorPorId(int id) throws NotFoundException {
        return repositorio.findById(id).orElseThrow(() -> new NotFoundException(Professor.class, String.valueOf(id)));
    }

    @Override
    public ProfessorDto buscarPorCpf(String cpf) throws NotFoundException {
        return ProfessorMapper.toDto(repositorio.findByCpf(cpf).orElseThrow(() -> new NotFoundException(Professor.class, cpf)), boredApi.getActivity()
                .activity());
    }
}
