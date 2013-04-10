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
import dao.HistoricoDAO;
import entities.Cliente;
import entities.Historico;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rcruzsil
 */
@Resource
public class HistoricoController {

    private ClienteDAO dao;
    private HistoricoDAO daoHistorico;
    private final Result result;

    public HistoricoController(Result result) {
        this.dao = new ClienteDAO();
        this.daoHistorico = new HistoricoDAO();
        this.result = result;
    }

    @Post("/historico")
    public String adiciona(Cliente cliente, Historico historico) {
        try {
            historico.setIdclienteId(cliente);
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
            historico.setData(calendar);
            
            daoHistorico.adiciona(historico);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "Um erro ocorreu";
        }
        return "Histórico adicionado com sucesso!";
    }

    @Delete("/historico/{id}")
    public String remove(Integer id) throws Exception {
        String teste = "";
        try {
            daoHistorico.remove(id);
        } catch (Exception e) {
            teste = "Um erro ocorreu";
            return teste;
        }
        teste = "Histórico deletado com sucesso!";
        return teste;
    }

    @Get("/historico/{id}")
    public Cliente formulario(Integer id) {
        Cliente cliente = null;
        try {
            cliente = dao.findById(id);
        } catch (Exception ex) {
            //Logger.getLogger(HistoricoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Get("/historico/lista/{id}")
    public List<Historico> lista(Integer id) {
        try {
            return daoHistorico.listaHistoricos(id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            result.include("erro", "Um erro ocorreu");
            return null;
        }
    }

    @Get("/historico/edita/{id}")
    public Historico edita(Integer id) {
        Historico historico = null;
        try {
            historico = daoHistorico.findById(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return historico;
    }

    @Put("/historico/{historico.id}")
    public String altera(Historico historico) {
        try {
            daoHistorico.atualiza(historico);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "Um erro ocorreu";
        }
        return "Histórico editado com sucesso!";
    }
}
