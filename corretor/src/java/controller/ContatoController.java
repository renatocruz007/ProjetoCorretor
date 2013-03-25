/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import dao.ClienteDAO;
import dao.ClientecontatoDAO;
import entities.Cliente;
import entities.Clientecontato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rcruzsil
 */
@Resource
public class ContatoController {
    
    private ClienteDAO dao;
    private ClientecontatoDAO daoContato;

    public ContatoController() {
        this.dao = new ClienteDAO();
        this.daoContato = new ClientecontatoDAO();
    }
   
    
    @Post("/contato")
    public void adiciona(Cliente cliente, Clientecontato clienteContato) {
        clienteContato.setIdclienteId(cliente);
        daoContato.adiciona(clienteContato);
    }
    
    @Get("/contato/{id}")
    public Cliente formulario (Integer id) {
        return dao.edita(id);
    }
    @Get("/contato/lista/{id}")
    public List<Clientecontato> lista(Integer id) {
        return daoContato.listaContatos(id);
    }
}
