/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name="venda")
public class Venda implements Serializable{
    @Id
    @SequenceGenerator(name="seq_venda",sequenceName="seq_venda_id",allocationSize=1)
    @GeneratedValue(generator="seq_venda",strategy = GenerationType.SEQUENCE)
    private Integer Id;
    @Temporal(TemporalType.DATE)
    @Column(name="data", nullable=false)
    @NotNull(message="A data não pode ser nula")
    private Calendar data;
    @Column(name="valor_total",nullable=false,columnDefinition = "decimal(12,2)")
    @NotNull(message="O valor total deve ser informado")
    @Min(value=0,message="O valor total não pode ser negativo")
    private Double valorTotal;
    @Column(name="parcelas",nullable=false)
    @NotNull(message="A parcela não pode ser negativo")
    @Min(value=0,message="A quantidade de parcelas não pode ser negativo")
    private Integer parcelas;
    @ManyToOne
    @JoinColumn(name="pessoa_fisica",referencedColumnName = "id",nullable=false)
    @NotNull(message="A pessao física não pode ser nula")
    private PessoaFisica pessoaFisica;
    @OneToMany(mappedBy = "venda",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<VendaItens> itens = new ArrayList<>();

    public Venda() {
        this.valorTotal=0.0;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.Id);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
    
    public void adicionarItem(VendaItens obj){
        obj.setVenda(this);
        this.valorTotal+=obj.getValorTotal();
        this.itens.add(obj);
    }
    
    public void removerItem(int index){
        VendaItens obj = this.itens.get(index);
        this.valorTotal-=obj.getValorTotal();
        this.itens.remove(index);
    }
    
    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public List<VendaItens> getItens() {
        return itens;
    }

    public void setItens(List<VendaItens> itens) {
        this.itens = itens;
    }
}
