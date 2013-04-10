/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.caelum.vraptor.ioc.Component;
import entities.Cliente;
import entities.Historico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Alexey
 */


public class HistoricoDAO {

  //  @PersistenceContext(name = "corretorPU")
    EntityManager em;

    public HistoricoDAO() {
        this.em = new JPAUtil().getEntityManager();
    }
    
    public void adiciona(Historico historico) throws Exception {
        try {
            em.getTransaction().begin();
            //em.persist(clienteHistorico.getIdCliente());
            
            em.persist(historico);
            
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
            Query query = em.createQuery("delete from Historico h "
                    + " where h.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage());
        }

    }
    
    public Historico findById (Integer id) {
        Historico historico = null;
        try {
            Query query = em.createQuery("select h from Historico h where h.id = :id", Historico.class);
            query.setParameter("id", id);
            historico =  (Historico) query.getSingleResult();
            return  historico;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return  null;
    }
    
    public void atualiza(Historico clienteHistorico) throws Exception {
        try {
             em.getTransaction().begin();
             em.merge(clienteHistorico);
             em.getTransaction().commit();
             em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
    public List<Historico> listaHistoricos(Integer id) {
        try {
            List<Historico> listaHistoricos = new ArrayList<Historico>();
            listaHistoricos = em.createQuery("select h from Historico h where h.idclienteId.id = :id").setParameter("id", id).getResultList();
            return listaHistoricos;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
