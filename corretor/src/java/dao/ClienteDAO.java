/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.caelum.vraptor.ioc.Component;
import entities.Cliente;
import entities.Clientecontato;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Alexey
 */
//@Stateless
//@LocalBean
public class ClienteDAO {

    //@PersistenceContext(name = "corretorPU")    
    EntityManager em;

    public ClienteDAO() {
        this.em = new JPAUtil().getEntityManager();
    }

    public void adiciona(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            // long aux = em.createQuery("select c.id from cliente c ").getFirstResult();

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }

    }

    public void remove(Integer id) {
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("delete from Cliente c "
                    + " where c.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }

    }

    public Integer retornaId(String nome) {
        Cliente cliente = new Cliente();
        try {
            Query query = em.createQuery("select c from Cliente c where c.nome = :nome",
                    Cliente.class);
            query.setParameter("nome", nome);
            cliente = (Cliente) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return cliente.getId();
    }

    public Cliente findById(Integer id) throws Exception {
        Cliente cliente = new Cliente();
        try {
            Query query = em.createQuery("select c from Cliente c where c.id = :id");
            query.setParameter("id", id);
            cliente = (Cliente) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return cliente;
    }

    public void atualiza(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }

    public List<Cliente> listaClientes() {
        try {
            List<Cliente> listaClientes = new ArrayList<Cliente>();
            listaClientes = em.createQuery("select c from Cliente c ").getResultList();
            return listaClientes;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<Cliente> busca(String nome) {
        
        try {
            List<Cliente> listaClientes = new ArrayList<Cliente>();
            Query query = em.createQuery("select c from Cliente c where "
                    + " c.nome like :nome");
            query.setParameter("nome", "%"+ nome +"%");
            listaClientes = query.getResultList();
            return listaClientes;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
