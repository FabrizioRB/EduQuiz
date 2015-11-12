/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import dao.InterfaceDao;
import dao.QuizDaoBd;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Quiz;

/**
 *
 * @author marcus.rodrigues
 */
@ManagedBean
@SessionScoped
public class QuizMB {
    
    private Quiz quiz = new Quiz();
    private QuizDaoBd quizDao = new QuizDaoBd();
    private DataModel listaQuizes;
    
    public QuizMB() {
   
    }
   
    public DataModel retornaListaDeQuiz() {
        List<Quiz> lista = quizDao.listar();
        listaQuizes = new ListDataModel(lista);
        
         return listaQuizes;        
    }
    
    public String carregarQuiz(Quiz q){
         this.quiz = q;
         return "responderQuiz";
    }
    
    
    //coisas do objeto Quiz

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.quiz);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuizMB other = (QuizMB) obj;
        if (!Objects.equals(this.quiz, other.quiz)) {
            return false;
        }
        return true;
    }
    
}
