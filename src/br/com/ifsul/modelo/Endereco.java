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
@Table(name="endereco")
public class Endereco implements Serializable{
    @Id
    @SequenceGenerator(name="seq_endereco",sequenceName="seq_endereco_id",allocationSize = 1)
    @GeneratedValue(generator="seq_endereco",strategy=GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="nickname", length = 20, nullable = false)
    @NotNull(message="O apelido não pode ser nulo")
    @NotBlank(message="O apelido não pode estar vazia")
    @Length(max = 20,message = "O apelido não deve ter mais de {max} caracteres")
    private String nickname;
    @Column(name="endereco", length = 50, nullable = false)
    @NotNull(message="O endereco não pode ser nulo")
    @NotBlank(message="O endereco não pode estar vazia")
    @Length(max = 50,message = "O endereco não deve ter mais de {max} caracteres")
    private String endereco;
    @Column(name="numero", length = 10, nullable = false)
    @NotNull(message="O numero não pode ser nulo")
    @NotBlank(message="O numero não pode estar vazia")
    @Length(max = 10,message = "O numero não deve ter mais de {max} caracteres")
    private String numero;
    @Column(name="complemento", length = 20, nullable = true)
    @NotNull(message="O complemento não pode ser nulo")
    @NotBlank(message="O complemento não pode estar vazia")
    @Length(max = 20,message = "O complemento não deve ter mais de {max} caracteres")
    private String complemento;
    @Column(name="cep", length = 9, nullable = false)
    @NotNull(message="O cep não pode ser nulo")
    @NotBlank(message="O cep não pode estar vazio")
    @Length(max = 9,message = "O cep não deve ter mais de {max} caracteres")
    private String cep;
    @Column(name="bairro", length = 40, nullable = false)
    @NotNull(message="O bairro não pode ser nulo")
    @NotBlank(message="O bairro não pode estar vazio")
    @Length(max = 40,message = "O bairro não deve ter mais de {max} caracteres")
    private String bairro;
    @Column(name="referencia", length = 30, nullable = false)
    @NotNull(message="A referencia não pode ser nulo")
    @NotBlank(message="A referencia não pode estar vazio")
    @Length(max = 30,message = "A referencia não deve ter mais de {max} caracteres")
    private String referencia;
    @NotNull(message="A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name="pessoa_id",referencedColumnName = "id", nullable=false)
    @ForeignKey(name="fk_pessoa_id")
    private Pessoa pessoa;
    @NotNull(message="O tipo do endereco deve ser informada")
    @ManyToOne
    @JoinColumn(name="tipo_endereco",referencedColumnName = "id", nullable=false)
    @ForeignKey(name="fk_tipo_endereco_id")
    private TipoEndereco tipoEndereco;

    public Endereco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.getId());
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }
    
    
}
