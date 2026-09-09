package com.example.Veterinaria.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veterinario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El documento es obligatorio")
    @Column(nullable = false, unique = true)
    private String targetaProfesional;

    @NotBlank(message = "la especialidad no puede estar vacia")
    @Column(nullable = false)
    private String especialidad;

    @Email
    @NotBlank(message = "El correo es obligatorio")
    @Column(nullable = false)
    private String correo;

    @ManyToMany(mappedBy = "veterinario")
    @JsonIgnoreProperties("veterinario")
    private List<Mascota> mascotas = new ArrayList<>();

}
