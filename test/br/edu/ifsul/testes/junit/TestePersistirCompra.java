/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.com.ifsul.modelo.Compra;
import br.com.ifsul.modelo.CompraID;
import br.com.ifsul.modelo.CompraItem;
import br.com.ifsul.modelo.PessoaJuridica;
import br.com.ifsul.modelo.Produto;
import br.edu.ifsul.jpa.EntityManagerUtil;
import java.util.Calendar;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Daniel
 */
public class TestePersistirCompra {
    EntityManager em;
    
    public TestePersistirCompra() {
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
            Produto p = em.find(Produto.class, 1);
            PessoaJuridica pj = em.find(PessoaJuridica.class, 3);
            CompraID id = new CompraID();
            Compra obj = new Compra();
            id.setPessoaJuridica(pj);
            id.setNumeroNota(12345);
            obj.setId(id);
            obj.setData(Calendar.getInstance());
            CompraItem item = new CompraItem();
            item.setProduto(p);
            item.setValorUnitario(p.getPreco());
            item.setQuantidade(5.0);
            item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
            obj.adicionarItem(item);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
