package com.example.personal.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="personal")
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="rut")
    @NotNull
    String rut;

    @Column(name="nombre")
    @NotNull
    String nombre;

    @Column(name="apellidos")
    @NotNull
    String apellidos;

    @Column(name="anno_Servicios")
    @NotNull
    int anno_Servicios;

    @Column(name="sueldo_fijo")
    @NotNull
    int sueldo_fijo;

    @Column(name="categoria")
    @NotNull
    char categoria;


}
