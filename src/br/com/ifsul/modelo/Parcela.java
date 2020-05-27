/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name="parcela")
public class Parcela implements Serializable{
    /*Isso significa que os valores da classe ParcelaID serão salvos na mesma
    tabela da classe parcela. Isso já foi indicado na classe ParcelaID com
    @Embeddable
    Com o uso do @EmbeddedId, significa que, além de ser outra classe que está
    sendo embutida, ela servirá como o id da classe. Poderia ser @Embedded apenas
    caso não fosse o Id
    */
    @EmbeddedId
    private ParcelaID parcelaID;
    @Column(name="valor",nullable=false,columnDefinition = "decimal(12,2)")
    @NotNull(message="O valor deve ser informado")
    @Min(value=0,message="O valor não pode ser negativo")
    private Double valor;
    @Temporal(TemporalType.DATE)
    @Column(name="vencimento", nullable=false)
    @NotNull(message="O vencimento não pode ser nulo")
    private Calendar vencimento;
    @Column(name="valor_pagamento",columnDefinition = "decimal(12,2)")
    @Min(value=0,message="O valor do pagamento não pode ser negativo")
    private Double valorPagamento;
    @Temporal(TemporalType.DATE)
    @Column(name="data_pagamento")
    private Calendar dataPagamento;

    public Parcela() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.parcelaID);
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
        final Parcela other = (Parcela) obj;
        if (!Objects.equals(this.parcelaID, other.parcelaID)) {
            return false;
        }
        return true;
    }

    
    
    public ParcelaID getParcelaID() {
        return parcelaID;
    }

    public void setParcelaID(ParcelaID parcelaID) {
        this.parcelaID = parcelaID;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
}
