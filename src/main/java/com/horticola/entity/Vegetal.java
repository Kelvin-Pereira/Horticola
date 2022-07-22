package com.horticola.entity;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "VEGETAL")
public class Vegetal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEGETAL_ID", nullable = false)
    private Long id;

    @NotNull(message = "O nome é obrigatório.")
    @Column(name = "NOME",  nullable = false)
    private String nome;

    @NotNull(message = "A categoria é obrigatório.")
    @Column(name = "CATEGORIA",  nullable = false)
    private String categoria;

    @NotNull(message = "O tipo do vegetal é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "TIPOVEGETAL_ID",  nullable = false)
    private TipoVegetal tipoVegetal;

}
