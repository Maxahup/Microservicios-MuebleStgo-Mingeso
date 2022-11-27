package com.example.autorizacion.Entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="registros")
public class Autorizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="rut")
    @NotNull
    private String rut;

    @Column(name="horas_aut")
    @NotNull
    private int horas_aut;

    public Autorizacion(String rut, int horas_aut) {
        this.rut = rut;
        this.horas_aut = horas_aut;
    }
}
