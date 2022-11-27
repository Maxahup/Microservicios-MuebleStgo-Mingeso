package com.example.planilla.Model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Marca {

    private int id;
    private String rut;
    private int min_10;
    private int min_25;
    private int min_45;
    private int ausencia;
}
