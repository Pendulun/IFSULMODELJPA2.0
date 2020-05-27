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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name="compra_item")
public class CompraItem implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_compra_item",sequenceName =  "seq_compra_item_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_compra_item", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message="A quantidade deve ser informada")
    @Min(value = 0, message="A quantidade não pode ser negativa")
    @Column(name="quantidade",nullable=false,columnDefinition = "numeric(10,2)")
    private Double quantidade;
    @NotNull(message="O valor unitário deve ser informado")
    @Min(value = 0, message="O valor unitário não pode ser negativo")
    @Column(name="valor_unitario",nullable=false,columnDefinition = "numeric(10,2)")
    private Double valorUnitario;
    @NotNull(message="O valor total deve ser informado")
    @Min(value = 0, message="O valor total não pode ser negativo")
    @Column(name="valor_total",nullable=false,columnDefinition = "numeric(10,2)")
    private Double valorTotal;
    @NotNull(message="O produto deve ser informado")
    @ManyToOne
    @JoinColumn(name = "produto", referencedColumnName = "id", nullable=false)
    private Produto produto;
    @NotNull(message="A compra deve ser informada")
    @ManyToOne
    private Compra compra;

    public CompraItem() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final CompraItem other = (CompraItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
}