/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
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

    @Get("/cliente/lista")
    public List<Cliente> lista() {
        return dao.listaClientes();
    }

    @Delete("/cliente/remove/{id}")
    public String remove(Integer id) {
        try {
            
            dao.remove(id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return"Um erro ocorreu";
        }
        return "Cliente deletado com sucesso!";
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
    public void formulario() {
    }

    @Get("/cliente/{id}")
    public Cliente edita(Integer id) {
        Cliente cliente = null;
        try {
            cliente = dao.findById(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return cliente;
    }

    @Put("/cliente/{cliente.id}")
    public void altera(Cliente cliente) {
        try {
            dao.atualiza(cliente);
        } catch (Exception ex) {
        }
    }
}
