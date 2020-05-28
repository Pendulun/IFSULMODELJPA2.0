/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.com.ifsul.modelo.Cidade;
import br.edu.ifsul.jpa.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Daniel
 */
public class TesteListarCidade {
    EntityManager em;
    
    public TesteListarCidade() {
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
            //Selecionamos de acordo com o nome da classe e não o da tabela
            String jpql = "from Cidade order by nome";
            List<Cidade> lista = em.createQuery(jpql).getResultList();
            for(Cidade c : lista){
                System.out.println("ID: "+c.getId()+" Nome: "+c.getNome()+" Estado: "+c.getEstado().getNome());
            }
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
