/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.com.ifsul.modelo.Categoria;
import br.com.ifsul.modelo.Marca;
import br.com.ifsul.modelo.PessoaFisica;
import br.com.ifsul.modelo.Produto;
import br.com.ifsul.modelo.Venda;
import br.com.ifsul.modelo.VendaItens;
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
public class TestePersistirVenda {
    EntityManager em;
    
    public TestePersistirVenda() {
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
            PessoaFisica pf = em.find(PessoaFisica.class, 2);
            Venda v = new Venda();
            v.setData(Calendar.getInstance());
            v.setParcelas(3);
            v.setPessoaFisica(pf);
            VendaItens vi = new VendaItens();
            vi.setProduto(p);
            vi.setQuantidade(5.0);
            vi.setValorUnitario(p.getPreco());
            vi.setValorTotal(vi.getQuantidade()*vi.getValorUnitario());
            v.adicionarItem(vi);
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
