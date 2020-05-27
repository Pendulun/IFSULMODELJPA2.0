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

/*@Embeddable serve para identificar que a classe é embutida ou seja
não terá uma tabela própria
e seus atributos serão salvos nas tabelas das classes que a contém
*/

@Embeddable
public class ParcelaID implements Serializable{
    @Column(name="numero",nullable = false)
    @NotNull(message="O número não pode ser nulo")
    private Integer numero;
    @NotNull(message="A venda não pode ser nula")
    @ManyToOne
    @JoinColumn(name="venda",referencedColumnName = "id",nullable = false)
    private Venda venda;

    public ParcelaID() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.numero);
        hash = 13 * hash + Objects.hashCode(this.venda);
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
        final ParcelaID other = (ParcelaID) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        return true;
    }

    
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
}
