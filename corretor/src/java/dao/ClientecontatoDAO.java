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
    
    public void adiciona(Clientecontato clienteContato) throws Exception {
        try {
            em.getTransaction().begin();
            //em.persist(clienteContato.getIdCliente());
            
            em.persist(clienteContato);
            
            em.getTransaction().commit();
            em.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
    
    public void remove(Integer id) throws Exception {
        try {
           em.getTransaction().begin();
            Query query = em.createQuery("delete from Clientecontato c "
                    + " where c.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage());
        }

    }
    
    public Clientecontato findById (Integer id) {
        Clientecontato clienteContato = null;
        try {
            Query query = em.createQuery("select c from Clientecontato c where c.id = :id", Clientecontato.class);
            query.setParameter("id", id);
            clienteContato =  (Clientecontato) query.getSingleResult();
            return  clienteContato;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return  null;
    }
    
    public void atualiza(Clientecontato clienteContato) throws Exception {
        try {
             em.getTransaction().begin();
             em.merge(clienteContato);
             em.getTransaction().commit();
             em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage());
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
