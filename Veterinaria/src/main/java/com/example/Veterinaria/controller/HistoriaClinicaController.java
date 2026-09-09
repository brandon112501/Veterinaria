package com.example.Veterinaria.controller;

import com.example.Veterinaria.entity.HistoriaClinica;
import com.example.Veterinaria.service.HistoriaClinicaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/HistoriaClinica")
@AllArgsConstructor
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    @GetMapping("/listar")
    public ResponseEntity<List<HistoriaClinica>> listarTodas() {
        return ResponseEntity.ok(historiaClinicaService.listarTodas());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<HistoriaClinica> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(historiaClinicaService.buscarPorId(id));
    }

    @PostMapping("/guardar/{mascotaId}")
    public ResponseEntity<HistoriaClinica> crear(@RequestBody HistoriaClinica historia, @PathVariable Long mascotaId) {
        return ResponseEntity.ok(historiaClinicaService.crear(historia, mascotaId));
    }

    @PutMapping("/Actualizar/{id}")
    public ResponseEntity<HistoriaClinica> actualizar(@PathVariable Long id, @RequestBody HistoriaClinica historia) {
        return ResponseEntity.ok(historiaClinicaService.actualizar(id, historia));
    }

    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historiaClinicaService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}