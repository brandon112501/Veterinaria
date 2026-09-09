package com.example.Veterinaria.controller;

import com.example.Veterinaria.entity.Mascota;
import com.example.Veterinaria.service.MascotaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Mascota")
@AllArgsConstructor
public class MascotaController {

    private final MascotaService mascotaService;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Mascota> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.buscarPorId(id));
    }

    @PostMapping("/guardar/{propietarioId}")
    public ResponseEntity<Mascota> guardar(@RequestBody Mascota mascota, @PathVariable Long propietarioId) {
        return ResponseEntity.ok(mascotaService.guardar(mascota, propietarioId));
    }

    @PutMapping("/Actualizar/{id}")
    public ResponseEntity<Mascota> actualizar(@PathVariable Long id, @RequestBody Mascota mascota) {
        return ResponseEntity.ok(mascotaService.actualizar(id, mascota));
    }

    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mascotaService.eliminar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/propietario/{propietarioId}")
    public ResponseEntity<List<Mascota>> buscarPorPropietario(@PathVariable Long propietarioId) {
        return ResponseEntity.ok(mascotaService.buscarPorPropietario(propietarioId));
    }

    @PutMapping("/asignar-veterinario/{mascotaId}/{veterinarioId}")
    public ResponseEntity<Mascota> asignarVeterinario(@PathVariable Long mascotaId, @PathVariable Long veterinarioId) {
        return ResponseEntity.ok(mascotaService.asignarVeterinario(mascotaId, veterinarioId));
    }
}