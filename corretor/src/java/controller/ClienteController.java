/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import dao.ClientecontatoDAO;
import dao.ClienteDAO;
import entities.Cliente;
import entities.Clientecontato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexey
 */
 @Resource
public class ClienteController {
    private ClienteDAO dao;
    private ClientecontatoDAO daoContato;

    public ClienteController() {
        this.dao = new ClienteDAO();
        this.daoContato = new ClientecontatoDAO();
    }
    
    @Get("/cliente")
    public List<Cliente> lista() {
        return dao.listaClientes();
    }
    
    @Delete("/cliente/{id}")
    public void remove (Integer id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        dao.remove(cliente);
    }
    
    @Post("/cliente")
    public void adiciona(Cliente cliente, Clientecontato clienteContato) {
       // List<Clientecontato> listaClienteContatos = new ArrayList<Clientecontato>();
       // listaClienteContatos.add(clienteContato);
       // cliente.setClientecontatoList(listaClienteContatos);
        dao.adiciona(cliente);
      //  Long idCliente = dao.retornaId(cliente.getNome());
      //  cliente.setId(cliente.getId());
        clienteContato.setIdclienteId(cliente);
        daoContato.adiciona(clienteContato);
    }
    
    @Get("/cliente/novo")
    public void formulario () {
    }
    @Get("/cliente/{id}")
    public Cliente edita (Integer id) {
        return dao.edita(id);
    }
}
