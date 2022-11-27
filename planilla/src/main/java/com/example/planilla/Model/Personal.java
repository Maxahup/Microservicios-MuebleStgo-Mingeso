package com.example.planilla.Model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Personal {

    private int id;
    private String rut;
    private String nombre;
    private String apellidos;
    private int anno_Servicios;
    private int sueldo_fijo;
    private char categoria;


}
