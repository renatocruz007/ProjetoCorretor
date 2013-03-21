/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexey
 */
@Resource
public class Mundo {

    public String boasVindas() {
        return "olá mundo!";
    }

    public List<String> paises() {
        List<String> result = new ArrayList<String>();
        result.add("Brasil");
        result.add("Portugal");
        result.add("Japão");
        result.add("Canadá");
        result.add("Paraguai");
        return result;
    }

    public int inteiro() {
        return 5;
    }
}
