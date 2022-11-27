package com.example.marca.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="registros_entradas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="rut")
    @NotNull
    private String rut;
    @Column(name="min_10")
    @NotNull
    private int min_10;
    @Column(name="min_25")
    @NotNull
    private int min_25;
    @Column(name="min_45")
    @NotNull
    private int min_45;
    @Column(name="ausencia")
    @NotNull
    private int ausencia;

    public Marca(String rut, int min_10, int min_25, int min_45, int ausencia) {
        this.rut = rut;
        this.min_10 = min_10;
        this.min_25 = min_25;
        this.min_45 = min_45;
        this.ausencia = ausencia;
    }
}
