package com.example.demo;

import com.example.demo.domain.dto.v1.ProfessorDto;
import com.example.demo.service.IProfessorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.CommandLineRunner;
import lombok.RequiredArgsConstructor;


@Controller
@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients

public class DemoApplication implements CommandLineRunner {

	private final IProfessorService professorServico;

	public static void main(String... args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws InterruptedException {
		Thread.sleep(2000);
		var professor = new ProfessorDto(1, "rgreggg", "80405526210", "string@email.com", null);
		professorServico.criarProfessor(professor);
	}

}
