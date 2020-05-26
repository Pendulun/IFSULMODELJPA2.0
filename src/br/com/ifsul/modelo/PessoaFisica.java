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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Daniel
 */
/*Como essa classe herda de Pessoa, não é preciso gerar o equals e o hashCode*/
@Entity
@Table(name="pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable{
    @Column(name="rg",length=10, nullable=false)
    @NotNull(message="O RG não pode ser nulo")
    @NotBlank(message="O RG não pode ser em branco")
    @Length(max = 10, message="O RG não pode ter mais do que {max} caracteres")
    private String rg;
    //Atenção a anotação @CPF
    @Column(name="cpf",length=14, nullable=false)
    @NotNull(message="O CPF não pode ser nulo")
    @NotBlank(message="O CPF não pode ser em branco")
    @Length(max = 14, message="O CPF não pode ter mais do que {max} caracteres")
    @CPF(message = "O CPF deve ser válido")
    private String cpf;
    //Atenção à anotação @Temporal
    @NotNull(message="O nascimento não pode ser nulo")
    @Column(name="nascimento",nullable=false)
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    @Column(name="nome_usuario",length=20, nullable=false, unique = true)
    @NotNull(message="O nome de usuário não pode ser nulo")
    @NotBlank(message="O nome de usuário não pode ser em branco")
    @Length(max = 20, message="O nome de usuário não pode ter mais do que {max} caracteres")
    private String nomeUsuario;
    @Column(name="senha",length=10, nullable=false)
    @NotNull(message="A senha de usuário não pode ser nula")
    @NotBlank(message="A senha de usuário não pode ser em branco")
    @Length(max = 10, message="A senha não pode ter mais do que {max} caracteres")
    private String senha;
    /*Primeiramente, como uma pessoa pode ter vários produtos e um mesmo produto
    pode ter várias pessoas, a relação indicada aqui e em produto é manytomany;
    
    Em segundo, é preciso indicar usando jointable uma tabela conjunta para ambos
    usarem, nesse caso 'desejos', tanto em joinColumns e inverseJoinColumns;
    
    Em terceiro, indicamos a restrição de que pessoa_fisica e produto não podem 
    aparecer mais do que uma vez combinados com uniqueCOnstraints
    
    Tudo isso foi feito em Produto também
    */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="desejos",
            joinColumns = 
                    @JoinColumn(name="pessoa_fisica", referencedColumnName = "id", nullable=false),
            inverseJoinColumns = 
                    @JoinColumn(name="produto",referencedColumnName = "id", nullable=false),
            uniqueConstraints = @UniqueConstraint(columnNames = {"pessoa_fisica","produto"}))
    private List<Produto> desejos = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="permissoes",
            joinColumns = 
                    @JoinColumn(name="nome_usuario", referencedColumnName = "nome_usuario", nullable=false),
            inverseJoinColumns = 
                    @JoinColumn(name="permissao",referencedColumnName = "nome", nullable=false),
            uniqueConstraints = @UniqueConstraint(columnNames = {"nome_usuario","permissao"}))
    private List<Permissao> permissoes = new ArrayList<>();
    
    public PessoaFisica() {
    }
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Produto> getDesejos() {
        return desejos;
    }

    public void setDesejos(List<Produto> desejos) {
        this.desejos = desejos;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}
