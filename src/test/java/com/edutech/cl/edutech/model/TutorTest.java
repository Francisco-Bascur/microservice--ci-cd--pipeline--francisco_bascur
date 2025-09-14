package com.edutech.cl.edutech.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;



class TutorTest {

    private Tutor tutor;

    @BeforeEach
    void setUp() {
        tutor = Tutor.builder()
                .id(1L)
                .nombre("pablod")
                .apellido("roko")
                .especialidad("Matemáticas")
                .email("francisco@edutech.com")
                .build();
    }

    @Test
    void deberiaCrearTutorUsandoBuilder() {

        Tutor nuevoTutor = Tutor.builder()
                .nombre("Ana")
                .apellido("García")
                .especialidad("Ciencias")
                .email("ana@edutech.com")
                .build();


        assertAll("Verificar todos los campos del tutor",
                () -> assertEquals("Ana", nuevoTutor.getNombre()),
                () -> assertEquals("García", nuevoTutor.getApellido()),
                () -> assertEquals("Ciencias", nuevoTutor.getEspecialidad()),
                () -> assertEquals("ana@edutech.com", nuevoTutor.getEmail())
        );
    }

    @Test

    void deberiaCrearTutorConConstructorIdNombre() {

        Tutor tutorSimple = new Tutor(2L, "Pedro");


        assertEquals(2L, tutorSimple.getId());
        assertEquals("Pedro", tutorSimple.getNombre());
        assertNull(tutorSimple.getApellido());
        assertNull(tutorSimple.getEspecialidad());
        assertNull(tutorSimple.getEmail());
    }

    @Test

    void deberiaPermitirModificarEspecialidad() {

        String nuevaEspecialidad = "Física";


        tutor.setEspecialidad(nuevaEspecialidad);


        assertEquals(nuevaEspecialidad, tutor.getEspecialidad());
    }

    @Test

    void deberiaPermitirModificarEmail() {

        String nuevoEmail = "nuevo.email@edutech.com";


        tutor.setEmail(nuevoEmail);


        assertEquals(nuevoEmail, tutor.getEmail());
    }

    @Test

    void deberiaCrearTutorConConstructorVacio() {

        Tutor tutorVacio = new Tutor();


        assertNotNull(tutorVacio);
        assertNull(tutorVacio.getId());
        assertNull(tutorVacio.getNombre());
        assertNull(tutorVacio.getApellido());
        assertNull(tutorVacio.getEspecialidad());
        assertNull(tutorVacio.getEmail());
    }



    @Test

    void deberiaValidarGettersYSetters() {

        Tutor nuevoTutor = new Tutor();
        Long id = 10L;
        String nombre = "Carmen";
        String apellido = "López";
        String especialidad = "Química";
        String email = "carmen@edutech.com";


        nuevoTutor.setId(id);
        nuevoTutor.setNombre(nombre);
        nuevoTutor.setApellido(apellido);
        nuevoTutor.setEspecialidad(especialidad);
        nuevoTutor.setEmail(email);


        assertEquals(id, nuevoTutor.getId());
        assertEquals(nombre, nuevoTutor.getNombre());
        assertEquals(apellido, nuevoTutor.getApellido());
        assertEquals(especialidad, nuevoTutor.getEspecialidad());
        assertEquals(email, nuevoTutor.getEmail());
    }

    @Test

    void Deberia_ValidarBuilderCompleto() {

        Tutor tutorBuilder = Tutor.builder()
                .id(5L)
                .nombre("Roberto")
                .apellido("Silva")
                .especialidad("Inglés")
                .email("roberto@edutech.com")
                .build();


        assertNotNull(tutorBuilder);
        assertEquals(5L, tutorBuilder.getId());
        assertEquals("Roberto", tutorBuilder.getNombre());
        assertEquals("Silva", tutorBuilder.getApellido());
        assertEquals("Inglés", tutorBuilder.getEspecialidad());
        assertEquals("roberto@edutech.com", tutorBuilder.getEmail());
    }
}
