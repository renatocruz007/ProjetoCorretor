/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
    
    public List<Cliente> lista() {
        return dao.listaClientes();
    }
    public void adiciona(Cliente cliente, Clientecontato clienteContato) {
        List<Clientecontato> listaClienteContatos = new ArrayList<Clientecontato>();
        listaClienteContatos.add(clienteContato);
        cliente.setClientecontatoList(listaClienteContatos);
        dao.adiciona(cliente);
      //  Long idCliente = dao.retornaId(cliente.getNome());
      //  cliente.setId(cliente.getId());
        clienteContato.setIdclienteId(cliente);
        daoContato.atualiza(clienteContato);
    }
    
    public void formulario () {
    }
}
