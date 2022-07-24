package com.horticola.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "CLIENTE")
@RequiredArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENTE_ID", nullable = false)
    private Long id;

    @NotNull(message = "Nome é obrigatório.")
    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    public Cliente(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

}
