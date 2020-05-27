/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Daniel
 */
@Embeddable
public class CompraID implements Serializable{
    @NotNull(message="O número da nota deve ser informado")
    @Column(name="numero_nota",nullable=false)
    private Integer numeroNota;
    @NotNull(message="A pessoa juerídica deve ser informada")
    //Muitas compras para a mesma pessoa
    @ManyToOne
    @JoinColumn(name = "pessoa_juridica",referencedColumnName = "id", nullable=false)
    private PessoaJuridica pessoaJuridica;

    public CompraID() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.numeroNota);
        hash = 37 * hash + Objects.hashCode(this.pessoaJuridica);
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
        final CompraID other = (CompraID) obj;
        if (!Objects.equals(this.numeroNota, other.numeroNota)) {
            return false;
        }
        if (!Objects.equals(this.pessoaJuridica, other.pessoaJuridica)) {
            return false;
        }
        return true;
    }
    
    

    public Integer getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Integer numeroNota) {
        this.numeroNota = numeroNota;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }
    
}
