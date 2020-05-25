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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Daniel
 */

/*
A classe que poderá se herdada deve ter a anotação Inheritance com uma strategy
Nesse caso, 
*/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Pessoa implements Serializable{
    @Id
    @SequenceGenerator(name="seq_pessoa",sequenceName="seq_pessoa_id", allocationSize=1)
    @GeneratedValue(generator ="seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="nome",length=50, nullable=false)
    @NotNull(message="O nome não pode ser nulo")
    @NotBlank(message="O nome não pode ser em branco")
    @Length(max = 50, message="O nome não pode ter mais do que {max} caracteres")
    private String nome;
    @Column(name="email",length=50, nullable=false)
    @NotNull(message="O email não pode ser nulo")
    @NotBlank(message="O email não pode ser em branco")
    @Length(max = 50, message="O email não pode ter mais do que {max} caracteres")
    private String email;
    @Column(name="telefone",length=14, nullable=false)
    @NotNull(message="O telefone não pode ser nulo")
    @NotBlank(message="O telefone não pode ser em branco")
    @Length(max = 14, message="O telefone não pode ter mais do que {max} caracteres")
    private String telefone;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Pessoa() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
