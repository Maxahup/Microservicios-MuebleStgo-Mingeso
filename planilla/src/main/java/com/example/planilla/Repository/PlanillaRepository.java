package com.example.planilla.Repository;

import com.example.planilla.Entity.Planilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanillaRepository extends JpaRepository<Planilla, Integer> {
}
