/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.com.ifsul.modelo.Categoria;
import br.com.ifsul.modelo.Foto;
import br.com.ifsul.modelo.Marca;
import br.com.ifsul.modelo.Produto;
import br.edu.ifsul.jpa.EntityManagerUtil;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class TestePersistirFoto {
    EntityManager em;
    
    public TestePersistirFoto() {
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
            Foto f = new Foto();
            f.setNome("Celular Samsung");
            f.setDescricao("Foto do produto");
            Path path = Paths.get("C:\\Users\\Daniel\\Documents\\NetBeansProjects\\IFSUL.ModelJPA2.0\\src\\celular.jpg");
            f.setArquivo(Files.readAllBytes(path));
            p.adicionarFoto(f);
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
