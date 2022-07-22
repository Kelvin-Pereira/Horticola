package com.horticola.entity;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "vegetal", schema = "horticula")
public class Vegetal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "O nome é obrigatório.")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "A categoria é obrigatório.")
    @Column(name = "categoria")
    private String categoria;

    @NotNull(message = "O tipo do vegetal é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "tipo_vegetal_id")
    private TipoVegetal tipoVegetal;

}
