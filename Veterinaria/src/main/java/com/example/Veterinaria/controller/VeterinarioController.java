package com.example.Veterinaria.controller;

import com.example.Veterinaria.entity.Veterinario;
import com.example.Veterinaria.service.VeterinarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Veterinario")
@AllArgsConstructor
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Veterinario>> listarTodos() {
        return ResponseEntity.ok(veterinarioService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Veterinario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(veterinarioService.buscarPorId(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<Veterinario> guardar(@RequestBody Veterinario veterinario) {
        return ResponseEntity.ok(veterinarioService.guardar(veterinario));
    }

    @PutMapping("/Actualizar/{id}")
    public ResponseEntity<Veterinario> actualizar(@PathVariable Long id, @RequestBody Veterinario veterinario) {
        return ResponseEntity.ok(veterinarioService.actualizar(id, veterinario));
    }

    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        veterinarioService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}