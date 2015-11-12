/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.RespostaDaoBD;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Resposta;

/**
 *
 * @author Fabregas
 */
@ManagedBean
@SessionScoped
public class RespostaMB {

    private Resposta resposta;
    private RespostaDaoBD respostaDao;
    public RespostaMB() {
        resposta = new Resposta();
        respostaDao = new RespostaDaoBD();
        
    }
    
    
}
