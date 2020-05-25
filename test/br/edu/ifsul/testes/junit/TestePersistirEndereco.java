/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.com.ifsul.modelo.Endereco;
import br.com.ifsul.modelo.Estado;
import br.com.ifsul.modelo.Pais;
import br.com.ifsul.modelo.PessoaFisica;
import br.com.ifsul.modelo.TipoEndereco;
import br.edu.ifsul.jpa.EntityManagerUtil;
import java.util.Calendar;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class TestePersistirEndereco {
    EntityManager em;
    
    public TestePersistirEndereco() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try{
            PessoaFisica pf = em.find(PessoaFisica.class,2);
            TipoEndereco tipoEndereco1 = new TipoEndereco();
            TipoEndereco tipoEndereco2 = new TipoEndereco();
            tipoEndereco1.setDescricao("Apartamento");
            tipoEndereco2.setDescricao("Casa");
            Endereco e = new Endereco();
            e.setBairro("Bela Vista");
            e.setCep("35450000");
            e.setComplemento("Ap tal");
            e.setEndereco("Rua xxx");
            e.setNickname("nicjname");
            e.setNumero("830");
            e.setReferencia("Do lado da Cemig");
            e.setTipoEndereco(tipoEndereco2);
            pf.adicionarEndereco(e);
            /*Ao dar persist em pf, o endereço dela também é persistido pois
            foi definido cascadeType.all em pessoa
            */
            em.getTransaction().begin();
            em.persist(tipoEndereco1);
            em.persist(tipoEndereco2);
            em.persist(pf);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
