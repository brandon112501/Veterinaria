package com.example.Veterinaria.service.Impl;

import com.example.Veterinaria.Exception.ResourceNotFoundException;
import com.example.Veterinaria.Repository.PropietarioRepository;
import com.example.Veterinaria.entity.Propietario;
import com.example.Veterinaria.service.PropietarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PropietarioServiceImpl implements PropietarioService {

        private final PropietarioRepository repository;

        @Override
        @Transactional(readOnly = true)
        public List<Propietario> listarTodos() {
            return repository.findAll();
        }

        @Override
        @Transactional(readOnly = true)
        public Propietario buscarPorId(Long id) {

            return repository.findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Propietario no encontrado: " + id));
        }

        @Override
        @Transactional
        public Propietario guardar(
                Propietario propietario
        ) {
            return repository.save(propietario);
        }

        @Override
        @Transactional
        public Propietario actualizar(
                Long id,
                Propietario datos
        ) {

            Propietario actual = buscarPorId(id);

            actual.setNombre(datos.getNombre());
            actual.setDocumento(datos.getDocumento());
            actual.setTelefono(datos.getTelefono());
            actual.setCorreo(datos.getCorreo());

            return repository.save(actual);
        }

        @Override
        @Transactional
        public void eliminar(Long id) {

            Propietario propietario =
                    buscarPorId(id);

            repository.delete(propietario);
        }

}
