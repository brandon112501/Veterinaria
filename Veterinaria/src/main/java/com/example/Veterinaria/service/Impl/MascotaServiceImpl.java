package com.example.Veterinaria.service.Impl;

import com.example.Veterinaria.Exception.ResourceNotFoundException;
import com.example.Veterinaria.Repository.MascotaRepository;
import com.example.Veterinaria.Repository.PropietarioRepository;
import com.example.Veterinaria.Repository.VeterinarioRepository;
import com.example.Veterinaria.entity.Mascota;
import com.example.Veterinaria.entity.Propietario;
import com.example.Veterinaria.entity.Veterinario;
import com.example.Veterinaria.service.MascotaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.ResolutionException;
import java.util.List;


@Service
@AllArgsConstructor

public class MascotaServiceImpl implements MascotaService {


    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;
    private final VeterinarioRepository veterinarioRepository;


    @Override
    @Transactional(readOnly = true)
    public Mascota buscarPorId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(()->
                        new ResolutionException("mascota no encontrada"+id));

    }

    @Override
    @Transactional
    public Mascota guardar(Mascota mascota, Long propietarioId) {
        Propietario propietario = propietarioRepository.findById(propietarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Propietario no encontrado: " + propietarioId));

        mascota.setPropietario(propietario);
        return mascotaRepository.save(mascota);
    }

    @Transactional
    @Override
    public Mascota actualizar(Long id, Mascota datos) {
        Mascota actual = buscarPorId(id);

        actual.setNombre(datos.getNombre());
        actual.setEspecie(datos.getEspecie());
        actual.setRaza(datos.getRaza());
        actual.setEdad(datos.getEdad());

        return mascotaRepository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Mascota mascota = buscarPorId(id);
        mascotaRepository.delete(mascota);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> buscarPorPropietario(Long propietarioId) {
        return mascotaRepository.findByPropietarioId(propietarioId);
    }

    @Override
    @Transactional
    public Mascota asignarVeterinario(Long mascotaId, Long veterinarioId) {
        Mascota mascota = buscarPorId(mascotaId);
        Veterinario veterinario = veterinarioRepository.findById(veterinarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado: " + veterinarioId));

        mascota.setVeterinario(veterinario);
        return mascotaRepository.save(mascota);
    }
}