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
import dao.HistoricoDAO;
import dao.ClienteDAO;
import entities.Cliente;
import entities.Historico;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Alexey
 */
@Resource
public class ClienteController {

    private ClienteDAO dao;
    private HistoricoDAO daoHistorico;
    private final Result result;

    public ClienteController(Result result) {
        this.dao = new ClienteDAO();
        this.daoHistorico = new HistoricoDAO();
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
    public String adiciona(Cliente cliente, Historico historico) {
        try {
            dao.adiciona(cliente);
            if (historico.getDescricao() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
               
                historico.setIdclienteId(cliente);
                historico.setData(calendar);
                daoHistorico.adiciona(historico);
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
