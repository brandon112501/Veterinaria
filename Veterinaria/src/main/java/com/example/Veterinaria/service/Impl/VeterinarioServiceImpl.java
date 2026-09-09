package com.example.Veterinaria.service.Impl;

import com.example.Veterinaria.Exception.ResourceNotFoundException;
import com.example.Veterinaria.Repository.VeterinarioRepository;
import com.example.Veterinaria.entity.Veterinario;
import com.example.Veterinaria.service.VeterinarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Veterinario> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Veterinario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado: " + id));
    }

    @Override
    @Transactional
    public Veterinario guardar(Veterinario veterinario) {
        return repository.save(veterinario);
    }

    @Override
    @Transactional
    public Veterinario actualizar(Long id, Veterinario datos) {
        Veterinario actual = buscarPorId(id);

        actual.setNombre(datos.getNombre());
        actual.setTargetaProfesional(datos.getTargetaProfesional());
        actual.setEspecialidad(datos.getEspecialidad());

        return repository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Veterinario veterinario = buscarPorId(id);
        repository.delete(veterinario);
    }
}