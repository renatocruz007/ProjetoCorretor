/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.caelum.vraptor.ioc.Component;
import entities.Clientecontato;
import javax.persistence.EntityManager;

/**
 *
 * @author Alexey
 */


public class ClientecontatoDAO {

  //  @PersistenceContext(name = "corretorPU")
    EntityManager em;

    public ClientecontatoDAO() {
        this.em = new JPAUtil().getEntityManager();
    }
    
    
    
    public void adiciona(Clientecontato clienteContato) {
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
    
    public void atualiza(Clientecontato clienteContato) {
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
