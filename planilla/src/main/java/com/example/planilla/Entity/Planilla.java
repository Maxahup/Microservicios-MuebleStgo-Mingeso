package com.example.planilla.Entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="planilla")
public class Planilla {

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

    @Column(name="categoria")
    @NotNull
    char categoria;

    @Column(name="sueldo_fijo")
    @NotNull
    int sueldo_fijo;

    @Column(name="bonificacion_annos_servicios")
    @NotNull
    double bonificacion_annos_servicios;

    @Column(name="bonificacion_horas_extras")
    @NotNull
    double bonificacion_horas_extras;

    @Column(name="descuentos")
    @NotNull
    double descuentos;


    @Column(name="sueldo_bruto")
    @NotNull
    double sueldo_bruto;

    @Column(name="cotizacion_previsional")
    @NotNull
    double cotizacion_previsonal;

    @Column(name="cotizacion_salud")
    @NotNull
    double cotizacion_salud;

    @Column(name="sueldo_liquido")
    @NotNull
    double sueldo_liquido;

    public Planilla(String rut, String nombre, String apellidos, int anno_Servicios,char categoria, int sueldo_fijo, double bonificacion_annos_servicios, double bonificacion_horas_extras,double descuentos, double sueldo_bruto, double cotizacion_previsonal, double cotizacion_salud, double sueldo_liquido) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anno_Servicios = anno_Servicios;
        this.categoria = categoria;
        this.sueldo_fijo = sueldo_fijo;
        this.bonificacion_annos_servicios = bonificacion_annos_servicios;
        this.bonificacion_horas_extras = bonificacion_horas_extras;
        this.descuentos = descuentos;
        this.sueldo_bruto = sueldo_bruto;
        this.cotizacion_previsonal = cotizacion_previsonal;
        this.cotizacion_salud = cotizacion_salud;
        this.sueldo_liquido = sueldo_liquido;
    }
}
