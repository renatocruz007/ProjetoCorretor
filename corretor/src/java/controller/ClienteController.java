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
import br.com.caelum.vraptor.Result;
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
    private final Result result;

    public ClienteController(Result result) {
        this.dao = new ClienteDAO();
        this.daoContato = new ClientecontatoDAO();
        this.result = result;
    }

    @Get("/cliente/lista")
    public List<Cliente> lista() {
        try {
            return dao.listaClientes();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            result.include("erro", "Um erro ocorreu");
            return null;
        }
    }

    @Delete("/cliente/remove/{id}")
    public String remove(Integer id) {
        try {

            dao.remove(id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "Um erro ocorreu";
        }
        return "Cliente deletado com sucesso!";
    }

    @Post("/cliente")
    public String adiciona(Cliente cliente, Clientecontato clienteContato) {
        try {            
            dao.adiciona(cliente);
            if (clienteContato.getDesccontato() != null || clienteContato.getSiglatipo() != null
                    || clienteContato.getSiglatipocontato() != null) {
                clienteContato.setIdclienteId(cliente);
                
                daoContato.adiciona(clienteContato);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "Um erro ocorreu";
        }
        return "Cliente adicionado com sucesso!";
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
    public String altera(Cliente cliente) {
        try {
            dao.atualiza(cliente);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "Um erro ocorreu";
        }
        return "Cliente alterado com sucesso!";
    }

    public List<Cliente> busca(String nome) {
        try {
            result.include("nome", nome);
            return dao.busca(nome);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            result.include("erro", "Um erro ocorreu");
            return null;
        }
    }
}
