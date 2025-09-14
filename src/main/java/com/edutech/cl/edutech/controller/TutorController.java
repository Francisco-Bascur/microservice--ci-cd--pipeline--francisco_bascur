package com.edutech.cl.edutech.controller;
import com.edutech.cl.edutech.model.Tutor;
import com.edutech.cl.edutech.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping
    public ResponseEntity<List<Tutor>> listar() {
        List<Tutor> tutores = tutorService.findAll();
        if (tutores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tutores);
    }

    @PostMapping
    public ResponseEntity<Tutor> guardar(@RequestBody Tutor tutor) {
        Tutor nuevoTutor = tutorService.save(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTutor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> buscar(@PathVariable Integer id) {
        try {
            Tutor tutor = tutorService.findById(id);
            return ResponseEntity.ok(tutor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> actualizar(@PathVariable Integer id, @RequestBody Tutor tutor) {
        try {
            Tutor tutorExistente = tutorService.findById(id);
            tutorExistente.setNombre(tutor.getNombre());
            tutorExistente.setApellido(tutor.getApellido());
            tutorExistente.setEspecialidad(tutor.getEspecialidad());
            tutorExistente.setEmail(tutor.getEmail());

            Tutor tutorActualizado = tutorService.save(tutorExistente);
            return ResponseEntity.ok(tutorActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            tutorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


           // ...........................................................................................................