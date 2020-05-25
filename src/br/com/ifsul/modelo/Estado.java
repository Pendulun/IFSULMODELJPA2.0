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
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name="Estado")
public class Estado implements Serializable{
    @Id
    @SequenceGenerator(name="seq_estado",sequenceName="seq_estado_id", allocationSize=1)
    @GeneratedValue(generator = "seq_estado",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max=50, message="O nome não pode ter mais do que {max} caracteres")
    @NotBlank(message= "O nome deve ser informado")
    @NotNull(message="O nome não pode ser nulo")
    @Column(name="nome",length=50,nullable=false)
    private String nome;
    @Length(max=2, message="A UF não pode ter mais do que {max} caracteres")
    @NotBlank(message= "A UF deve ser informada")
    @NotNull(message="A UF não pode ser nula")
    @Column(name="uf",length=2,nullable=false)
    private String uf;
    /*
    O país pode ter vários estados, logo, ManyToOne;
    Além disso, como vamos referenciar à tabela de País, devemos usar o JoinColumn
    indicando a coluna a ser referenciada.
    */
    @NotNull(message="O país deve ser informado")
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_pais")
    private Pais pais;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Estado() {
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
