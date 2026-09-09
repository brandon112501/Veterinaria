package com.example.Veterinaria.service;

import com.example.Veterinaria.entity.Mascota;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MascotaService {
    Mascota buscarPorId(Long id);

    Mascota guardar (Mascota mascota, Long propietarioId);


    Mascota actualizar(Long id, Mascota datos);

    void eliminar (Long id);

    List<Mascota> buscarPorPropietario(Long propietarioId);

    Mascota asignarVeterinario(Long mascotaId, Long veterinarioId);


}
