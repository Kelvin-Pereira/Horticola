package com.horticola.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "tipoVegetal", schema = "horticula")
public class TipoVegetal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Nome é obrigatório.")
    @Column(name = "nome")
    private String nome;

    @OneToMany
    private Collection<Vegetal> vegetals;

}
