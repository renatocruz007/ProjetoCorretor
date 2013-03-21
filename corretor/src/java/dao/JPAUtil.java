/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alexey
 */

public class JPAUtil {
     private final EntityManagerFactory entityManagerFactory 
             = Persistence.createEntityManagerFactory("default");

     public EntityManager getEntityManager() {
     return entityManagerFactory.createEntityManager();
     } 

    
}
