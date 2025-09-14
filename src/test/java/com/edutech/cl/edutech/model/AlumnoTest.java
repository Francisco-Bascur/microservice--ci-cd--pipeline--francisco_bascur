package com.edutech.cl.edutech.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {

    @Test
    void testCrearAlumno() {
        // Arrange
        Date fechaNacimiento = new Date();
        Alumno alumno = new Alumno(
                1,
                "Alejandro ",
                "ORELLANA",
                "12345678-9",
                fechaNacimiento,
                "ALEEEEEEEEEE@example.com",
                "contrasenaSegura"
        );

        // Act & Assert
        assertEquals(1, alumno.getId());
        assertEquals("miel", alumno.getNombre());
        assertEquals("cascada", alumno.getApellido());
        assertEquals("12345678-9", alumno.getRun());
        assertEquals(fechaNacimiento, alumno.getFechaNacimiento());
        assertEquals("camila@example.com", alumno.getEmail());
        assertEquals("contrasenaSegura", alumno.getContrasena());
    }

    @Test
    void testSettersAndGetters() {
        // Arrange
        Alumno alumno = new Alumno();
        Date fechaNacimiento = new Date();

        // Act
        alumno.setId(2);
        alumno.setNombre("Camila");
        alumno.setApellido("Lopez");
        alumno.setRun("98765432-1");
        alumno.setFechaNacimiento(fechaNacimiento);
        alumno.setEmail("camila@example.com");
        alumno.setContraseña("claveSegura");

        // Assert
        assertEquals(2, alumno.getId());
        assertEquals("Camila", alumno.getNombre());
        assertEquals("Lopez", alumno.getApellido());
        assertEquals("98765432-1", alumno.getRun());
        assertEquals(fechaNacimiento, alumno.getFechaNacimiento());
        assertEquals("camila@example.com", alumno.getEmail());
        assertEquals("claveSegura", alumno.getContraseña());
    }
}
