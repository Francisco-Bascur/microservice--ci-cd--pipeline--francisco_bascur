package com.edutech.cl.edutech.controller;

import com.edutech.cl.edutech.model.Curso;
import com.edutech.cl.edutech.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> cursos = cursoService.findAll(); //
        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<Curso> guardar(@RequestBody Curso curso) {
        Curso cursoNuevo = cursoService.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscar(@PathVariable Integer id) {
        try {
            Curso curso = cursoService.findById(id); //
            return ResponseEntity.ok(curso);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        try {
            Curso cur = cursoService.findById(id); //
            cur.setId(id);
            cur.setDescripcion(curso.getDescripcion());
            cur.setNombre(curso.getNombre());
            cur.setDiasTotales(curso.getDiasTotales());
            cur.setTotalAlumnos(curso.getTotalAlumnos());
            cur.setTutor(curso.getTutor());

            Curso cursoActualizado = cursoService.save(cur);
            return ResponseEntity.ok(cursoActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            cursoService.deleteById(id); //
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}