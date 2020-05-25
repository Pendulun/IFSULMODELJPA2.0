/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.com.ifsul.modelo.Estado;
import br.com.ifsul.modelo.Pais;
import br.com.ifsul.modelo.PessoaFisica;
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
public class TestePersistirPessoaFisica {
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
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
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf("704.363.080-02");
            pf.setEmail("danielcampos14@hotmail.com.br");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Daniel Souza de Campos");
            pf.setNomeUsuario("userDaniel");
            pf.setRg("1234567890");
            pf.setSenha("usuario");
            pf.setTelefone("3561-0440 ");
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
