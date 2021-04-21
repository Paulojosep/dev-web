package com.Paulo.devweb.dto;

import com.Paulo.devweb.domain.Linguagem;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class LinguagemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo NOME é requerido")
    private String nome;

    @NotEmpty(message = "comapo DESCRICAO é requerido")
    private String descricao;

    public LinguagemDTO(){super();}

    public LinguagemDTO(Linguagem obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
