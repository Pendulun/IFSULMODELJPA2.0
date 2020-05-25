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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Daniel
 */

/*A serialização em Java é o processo no qual a instância de um objeto é
transformada em uma sequência de bytes e é útil quando precisamos enviar
objetos pela rede, salvar no disco, ou comunicar de uma JVM com outra.
Isso porque o estado atual do objeto é “congelado” e na outra “ponta” nós
podemos “descongelar” este objeto sem perder nenhuma informação.
<https://www.devmedia.com.br/use-a-serializacao-em-java-com-seguranca/29012>
*/

/*Três coisas que tornam uma classe Java em um BEAN:
Implementar SERIALIZABLE;
Tornar os atributos privados com getters e setters;
Construtor sem receber argumentos
*/

@Entity
@Table(name = "pais")
public class Pais implements Serializable{
    @Id
    /*Caso no próprio banco já esteja definido com auto_increment, só é necessário
    o comando GeneratedValue sem o generator="seq_pais" mas com o strategy*/
    @SequenceGenerator(name="seq_pais", sequenceName = "seq_pais_id", allocationSize=1)
    @GeneratedValue(generator="seq_pais", strategy=GenerationType.SEQUENCE)
    private Integer id;
    @Length(max=50, message="O nome não pode ter mais do que {max} caracteres")
    @NotBlank(message= "O nome deve ser informado")
    @NotNull(message="O nome não pode ser nulo")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Length(max=3, message="O ISO não pode ter mais do que {max} caracteres")
    @NotBlank(message= "O ISO deve ser informado")
    @NotNull(message="O ISO não pode ser nulo")
    @Column(name="iso", nullable = false, length=3)
    private String iso;
    
    public Pais(){
        //Construtor sem argumentos
    }

    
    //equals e hashCode usados para comparar os objetos. Gerados automaticamente
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Pais other = (Pais) obj;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
}
