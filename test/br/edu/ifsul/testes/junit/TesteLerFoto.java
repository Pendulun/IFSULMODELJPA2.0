/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.com.ifsul.modelo.Foto;
import br.edu.ifsul.jpa.EntityManagerUtil;
import java.io.File;
import java.io.FileOutputStream;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Daniel
 */
public class TesteLerFoto {
    EntityManager em;
    
    public TesteLerFoto() {
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
            Foto f = em.find(Foto.class,1);
            File file = new File("C:\\Users\\Daniel\\Documents\\NetBeansProjects\\IFSUL.ModelJPA2.0\\src\\celular.jpeg");
            FileOutputStream out = new FileOutputStream(file);
            out.write(f.getArquivo());
            out.close();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
