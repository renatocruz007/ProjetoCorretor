/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.ClienteDAO;
import dao.ClientecontatoDAO;
import entities.Cliente;
import entities.Clientecontato;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rcruzsil
 */
@Resource
public class ContatoController {

    private ClienteDAO dao;
    private ClientecontatoDAO daoContato;
    private final Result result;

    public ContatoController(Result result) {
        this.dao = new ClienteDAO();
        this.daoContato = new ClientecontatoDAO();
        this.result = result;
    }

    @Post("/contato")
    public String adiciona(Cliente cliente, Clientecontato clienteContato) {
        try {
            clienteContato.setIdclienteId(cliente);
            
            daoContato.adiciona(clienteContato);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "Um erro ocorreu";
        }
        return "Contato adicionado com sucesso!";
    }

    @Delete("/contato/{id}")
    public String remove(Integer id) throws Exception {
        String teste = "";
        try {
            daoContato.remove(id);
        } catch (Exception e) {
            teste = "Um erro ocorreu";
            return teste;
        }
        teste = "Contato deletado com sucesso!";
        return teste;
    }

    @Get("/contato/{id}")
    public Cliente formulario(Integer id) {
        Cliente cliente = null;
        try {
            cliente = dao.findById(id);
        } catch (Exception ex) {
            //Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Get("/contato/lista/{id}")
    public List<Clientecontato> lista(Integer id) {
        try {
            return daoContato.listaContatos(id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            result.include("erro", "Um erro ocorreu");
            return null;
        }
    }

    @Get("/contato/edita/{id}")
    public Clientecontato edita(Integer id) {
        Clientecontato contato = null;
        try {
            contato = daoContato.findById(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return contato;
    }

    @Put("/contato/{clienteContato.id}")
    public String altera(Clientecontato clienteContato) {
        try {
            daoContato.atualiza(clienteContato);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "Um erro ocorreu";
        }
        return "Contato editado com sucesso!";
    }
}
