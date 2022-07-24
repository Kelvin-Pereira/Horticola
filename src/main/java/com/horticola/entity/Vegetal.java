package com.horticola.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "VEGETAL")
@RequiredArgsConstructor
public class Vegetal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VEGETAL_ID", nullable = false)
    private Long id;

    @NotNull(message = "O nome é obrigatório.")
    @Column(name = "NOME", nullable = false)
    private String nome;

    @NotNull(message = "O ciclo de dias é obrigatório.")
    @Column(name = "CICLO_DIAS", nullable = false)
    private Integer ciclosDias;

    public Vegetal(String nome, Integer ciclosDias) {
        this.nome = nome;
        this.ciclosDias = ciclosDias;
    }
}
