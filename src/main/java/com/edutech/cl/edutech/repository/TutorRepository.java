package com.edutech.cl.edutech.repository;

import com.edutech.cl.edutech.model.Tutor;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/// .........
@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

    @Query("SELECT t FROM Tutor t WHERE t.nombre = :nombre ")
    Optional<Tutor> findByNombreWithiJPQL(String nombre);

    Optional<Tutor> findByNombre(String nombre);
    Optional<Tutor> findByNombreIgnoreCase(String nombre);


}