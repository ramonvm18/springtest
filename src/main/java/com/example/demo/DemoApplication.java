package com.example.demo;

import com.example.demo.domain.dto.v1.AlunoDto;
import com.example.demo.service.IAlunoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.CommandLineRunner;
import lombok.RequiredArgsConstructor;


@Controller
@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients

public class DemoApplication implements CommandLineRunner {

	private final IAlunoService alunoServico;

	public static void main(String... args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws InterruptedException {
		Thread.sleep(2000);
		var aluno = new AlunoDto(1, "rgreggg", "80405526210", "string@email.com", null);
		alunoServico.criarAluno(aluno);
	}

}
