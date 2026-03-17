package com.example.ac1.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ac1.models.Aluno;
import com.example.ac1.models.Curso;
import com.example.ac1.repositories.AlunoRepository;
import com.example.ac1.repositories.CursoRepository;

@Configuration
public class DadosIniciais {

    @Bean
    public CommandLineRunner init(CursoRepository cRepo, AlunoRepository aRepo) {
        return args -> {
            Curso c1 = new Curso(null, "Engenharia");
            Curso c2 = new Curso(null, "Direito");
            cRepo.inserir(c1);
            cRepo.inserir(c2);

            aRepo.inserir(new Aluno(null, "João", 2023, c1));
            aRepo.inserir(new Aluno(null, "Maria", 2024, c2));

            System.out.println("--- CURSOS ---");
            cRepo.selecionarTodos().forEach(System.out::println);
            System.out.println("--- ALUNOS ---");
            aRepo.selecionarTodos().forEach(System.out::println);
        };
    }
}
