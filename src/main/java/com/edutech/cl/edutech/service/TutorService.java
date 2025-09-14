package com.edutech.cl.edutech.service;

import com.edutech.cl.edutech.model.Tutor;
import com.edutech.cl.edutech.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TutorService {
    private String Apellido;
    private String Especialidad;
    private String Email;

    @Autowired
    private TutorRepository tutorRepository;

    public List<Tutor> findAll() {
        return tutorRepository.findAll();
    }

    public Tutor save(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Tutor findById(Integer id) {
        return tutorRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Tutor no Encontrado"));
    }

    public void deleteById(Integer id) {
        tutorRepository.deleteById(1L);
    }
}
