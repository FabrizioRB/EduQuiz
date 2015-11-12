/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.sun.xml.xsom.impl.scd.Iterators;
import dao.QuestionarioDaoBd;
import dao.RespostaDaoBD;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Questionario;
import model.Quiz;
import model.Resposta;

/**
 *
 * @author Fabregas
 */
@ManagedBean
@SessionScoped
public class QuestionarioMB {
    
    private Questionario quest = new Questionario();
    private Quiz quiz = new Quiz();
    private Resposta[] resposta;
    private QuestionarioDaoBd questionarioDao = new QuestionarioDaoBd();
    RespostaDaoBD respostaDaoBD=new RespostaDaoBD();
    private DataModel listaQuestionario;
    private DataModel listaResposta;
    private String[] algo = new String[20];
    
    public QuestionarioMB() {
        /*resposta = new Resposta[retornaListaDeQuestionario().getRowCount()];

        for(int i=0; i<resposta.length; i++) {
            resposta[i] = new Resposta();
        }*/
        //algo = new String[retornaListaDeQuestionario().getRowCount()];
    }
    public String carregarQuiz(Quiz q){
         this.quiz = q;
         return "responderQuiz";
   }
     public DataModel retornaListaDeQuestionario() {
        List<Questionario> lista = questionarioDao.listarQuestionario(quiz);
        Iterator<Questionario> iterques=lista.iterator();
        while(iterques.hasNext()){
            Questionario quest=iterques.next();
            quest.setRespostaList(respostaDaoBD.listarQuestionario(quest));
        }
        listaQuestionario = new ListDataModel(lista);
        
         return listaQuestionario;        
    }
    
     public DataModel listaderespostas() {
        List<Resposta> lista = quest.getRespostaList();//respostaDaoBD.listarQuestionario(quest);
        
        listaResposta = new ListDataModel(lista);
        
         return listaResposta;        
    }
     
    public List vai() {
        List<Resposta> lista = new ArrayList<>();
        for(int i=0; i<resposta.length; i++) {
            Resposta r = new Resposta();
            r.setIdresposta(resposta[i].getIdresposta());
            
            r.setResposta(resposta[i].getResposta());
            
            lista.add(r);
        }    
        return lista;
    }
     
    public String respostasDeUsuario(){
        return "teste";
    }

    public Questionario getQuest() {
        return quest;
    }

    public void setQuest(Questionario quest) {
        this.quest = quest;
    }

    public Resposta[] getResposta() {
        return resposta;
    }

    public void setResposta(Resposta[] resposta) {
        this.resposta = resposta;
    }

    public String[] getAlgo() {
        return algo;
    }

    public void setAlgo(String[] algo) {
        this.algo = algo;
    }

    

    
    
    
}
