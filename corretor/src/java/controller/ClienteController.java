/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import dao.ClienteContatoDAO;
import dao.ClienteDAO;
import entities.Cliente;
import entities.ClienteContato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexey
 */
 @Resource
public class ClienteController {
    private ClienteDAO dao;
    private ClienteContatoDAO daoContato;

    public ClienteController() {
        this.dao = new ClienteDAO();
        this.daoContato = new ClienteContatoDAO();
    }
    
    public List<Cliente> lista() {
        return dao.listaClientes();
    }
    public void adiciona(Cliente cliente, ClienteContato clienteContato) {
        List<ClienteContato> listaClienteContatos = new ArrayList<ClienteContato>();
        listaClienteContatos.add(clienteContato);
        cliente.setClienteContatoList(listaClienteContatos);
        dao.adiciona(cliente);
      //  Long idCliente = dao.retornaId(cliente.getNome());
      //  cliente.setId(cliente.getId());
        clienteContato.setIdCliente(cliente);
        daoContato.atualiza(clienteContato);
    }
    
    public void formulario () {
    }
}
