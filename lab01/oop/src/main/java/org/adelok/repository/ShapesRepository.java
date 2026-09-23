package org.adelok.repository;

import org.adelok.models.Shapes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShapesRepository extends JpaRepository <Shapes, Long> {
    Optional<Shapes> findFirstByOrderByAreaDesc();
}
