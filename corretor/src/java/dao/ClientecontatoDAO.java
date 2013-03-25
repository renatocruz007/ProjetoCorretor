/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.caelum.vraptor.ioc.Component;
import entities.Cliente;
import entities.Clientecontato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    public List<Clientecontato> listaContatos(Integer id) {
        try {
            List<Clientecontato> listaContatos = new ArrayList<Clientecontato>();
            listaContatos = em.createQuery("select c from Clientecontato c where c.idclienteId.id = :id").setParameter("id", id).getResultList();
            return listaContatos;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
