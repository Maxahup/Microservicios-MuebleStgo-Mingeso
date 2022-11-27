package com.example.justificativo.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="registros_just")
public class Justificativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="rut")
    @NotNull
    private String rut;

    @Column(name="dia")
    @NotNull
    private int dia;

    @Column(name="mes")
    @NotNull
    private int mes;

    @Column(name="anno")
    @NotNull
    private int anno;

    @Column(name="justificado")
    @NotNull
    private boolean justificado;

    public Justificativo(String rut, int dia, int mes, int anno, boolean justificado) {
        this.rut = rut;
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
        this.justificado = justificado;
    }
}
