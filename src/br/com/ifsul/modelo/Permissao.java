/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name="permissao")
public class Permissao implements Serializable{
    @Id
    @Column(name="nome",length=30, nullable=false)
    @NotBlank(message="O nome não pode ser vazio.")
    @NotNull(message="O nome deve ser informado.")
    @Length(max=30, message="O nome não pode ter mais do que {max} caracteres.")
    private String nome;
    @Column(name="descricao",length=40, nullable=false)
    @NotBlank(message="A descrição não pode ser vazio")
    @NotNull(message="A descrição deve ser informado")
    @Length(max=40, message="A descriçaõ não pode ter mais do que {max} caracteres.")
    private String descricao;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Permissao other = (Permissao) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public Permissao() {
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
