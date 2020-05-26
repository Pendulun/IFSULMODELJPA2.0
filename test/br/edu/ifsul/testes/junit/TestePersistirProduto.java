/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.com.ifsul.modelo.Categoria;
import br.com.ifsul.modelo.Marca;
import br.com.ifsul.modelo.Produto;
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
public class TestePersistirProduto {
    EntityManager em;
    
    public TestePersistirProduto() {
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
            Produto p = new Produto();
            p.setNome("Celular caro");
            p.setPreco(4000.0);
            p.setDescricao("Um celular caro e moderno");
            p.setCategoria(em.find(Categoria.class, 1));
            p.setMarca(em.find(Marca.class, 1));
            p.setQuantidadeEstoque(200.0);
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
