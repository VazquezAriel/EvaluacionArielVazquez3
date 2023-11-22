package com.evaluacion.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.evaluacion.app.models.Publicacion;
import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

    @Query("SELECT p FROM Publicacion p WHERE p.title = :title")
    List<Publicacion> findByTitle(@Param("title") String title);

}
