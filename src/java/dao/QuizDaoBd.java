/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Quiz;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class QuizDaoBd implements InterfaceDao<Quiz>{
    
   
   
    private Session sessao;
    private Transaction trans;

    @Override
    public void inserir(Quiz quiz) {
        try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                
                Quiz q = new Quiz();
                q.setInicioQuiz(quiz.getInicioQuiz());
                q.setFinalQuiz(quiz.getFinalQuiz());
                q.setPublicar(quiz.getPublicar());
                
                sessao.save(q);
                trans.commit();
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
            sessao.close();
        }
       }

    @Override
    public void deletar(Quiz quiz) {
        try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                
                sessao.delete(quiz);
                trans.commit();
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
                sessao.close();
        }
    }

    @Override
    public void atualizar(Quiz quiz) {
        try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                
                sessao.update(quiz);
                trans.commit();
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
                sessao.close();
        }
    }      

    @Override
    public List<Quiz> listar() {
         try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                List lista =sessao.createQuery("from Quiz").list();
                //Criteria cri = sessao.createCriteria(Quiz.class);
                lista.size();
                trans.commit();
                return lista;
         }
         catch(Exception ex){
             throw ex;
                
         }
         finally{
             if(sessao!=null){
             sessao.close();}
         }
         
    }
    
}
