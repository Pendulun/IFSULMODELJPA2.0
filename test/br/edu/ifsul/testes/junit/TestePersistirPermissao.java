/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.com.ifsul.modelo.Permissao;
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
public class TestePersistirPermissao {
    EntityManager em;
    
    public TestePersistirPermissao() {
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
            Permissao p1 = new Permissao();
            p1.setNome("Administrador");
            p1.setDescricao("Administrador do sistema");
            Permissao p2 = new Permissao();
            p2.setNome("Usuario");
            p2.setDescricao("Usuario do sistema");
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
