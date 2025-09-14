package com.edutech.cl.edutech;

import com.edutech.cl.edutech.model.Tutor;
import com.edutech.cl.edutech.repository.TutorRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("es")); // Faker en español
        Random random = new Random();

        for (int i = 0; i < 10; i++) { // Cambia 10 por la cantidad que quieras
            Tutor tutor = new Tutor();
            tutor.setNombre(faker.name().firstName());
            tutor.setApellido(faker.name().lastName());
            tutor.setEmail(faker.internet().emailAddress());
            tutor.setEspecialidad(faker.job().field());

            tutorRepository.save(tutor);
        }

        System.out.println("Tutores falsos insertados correctamente.");
    }
}
