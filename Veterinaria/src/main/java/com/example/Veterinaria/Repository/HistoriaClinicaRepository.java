package com.example.Veterinaria.Repository;


import com.example.Veterinaria.entity.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
}
