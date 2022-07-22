package com.horticola.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TIPOVEGETAL")
public class TipoVegetal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPOVEGETAL_ID", nullable = false)
    private Long id;

    @NotNull(message = "Nome é obrigatório.")
    @Column(name = "NOME", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "tipoVegetal")
    private List<Vegetal> vegetals = new ArrayList<>();

}
