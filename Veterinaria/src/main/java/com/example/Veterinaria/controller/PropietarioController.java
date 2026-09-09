package com.example.Veterinaria.controller;

import com.example.Veterinaria.Exception.ResourceNotFoundException;
import com.example.Veterinaria.entity.Propietario;
import com.example.Veterinaria.service.PropietarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Propietario")
@AllArgsConstructor
public class PropietarioController {
    private final PropietarioService propietarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Propietario>> listarTodos() {
        return ResponseEntity.ok(propietarioService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Propietario> buscarPorId(@PathVariable Long id, @RequestBody Propietario propietario) {

        return ResponseEntity.ok(propietarioService.buscarPorId(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<Propietario>  guardar(@RequestBody Propietario propietario){
        return ResponseEntity.ok(propietarioService.guardar(propietario));

    }

    @PutMapping("/Actualizar/{id}")
    public ResponseEntity<Propietario> actualizar(@PathVariable Long id,@RequestBody Propietario propietario){
        return ResponseEntity.ok(propietarioService.actualizar(id, propietario));


    }

    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity <Void> eliminar(@PathVariable Long id) {
        propietarioService.eliminar(id);
        return ResponseEntity.ok().build();




    }



}
