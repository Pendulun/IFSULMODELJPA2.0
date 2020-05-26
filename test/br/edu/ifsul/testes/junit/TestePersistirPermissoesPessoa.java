/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.com.ifsul.modelo.Permissao;
import br.com.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.jpa.EntityManagerUtil;
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
public class TestePersistirPermissoesPessoa {
    EntityManager em;
    
    public TestePersistirPermissoesPessoa() {
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
            Permissao p1 = em.find(Permissao.class, "Administrador");
            Permissao p2 = em.find(Permissao.class, "Usuario");
            pf.getPermissoes().add(p1);
            pf.getPermissoes().add(p2);
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
