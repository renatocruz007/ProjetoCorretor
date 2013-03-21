/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.caelum.vraptor.ioc.Component;
import entities.ClienteContato;
import javax.persistence.EntityManager;

/**
 *
 * @author Alexey
 */


public class ClienteContatoDAO {

  //  @PersistenceContext(name = "corretorPU")
    EntityManager em;

    public ClienteContatoDAO() {
        this.em = new JPAUtil().getEntityManager();
    }
    
    
    
    public void adiciona(ClienteContato clienteContato) {
        try {
            em.getTransaction().begin();
            //em.persist(clienteContato.getIdCliente());
            
            em.persist(clienteContato);
            
            em.getTransaction().commit();
            em.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }
    
    public void atualiza(ClienteContato clienteContato) {
        try {
             em.getTransaction().begin();
            em.merge(clienteContato);
             em.getTransaction().commit();
             em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }
    
}
