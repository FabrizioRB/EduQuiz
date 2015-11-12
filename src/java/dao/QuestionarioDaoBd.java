/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Questionario;
import model.Quiz;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class QuestionarioDaoBd implements InterfaceDao<Questionario>{
    
    private Session sessao;
    private Transaction trans;

    @Override
    public void inserir(Questionario questionario) {
        try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                
                Questionario q = new Questionario();
                q.setIdquiz(questionario.getIdquiz());
                q.setPergunta(questionario.getPergunta());
                q.setPeso(questionario.getPeso());
                q.setMateria(questionario.getMateria());
                
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
    public void deletar(Questionario questionario) {
        
        try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                
                sessao.delete(questionario);
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
    public void atualizar(Questionario questionario) {
        
         try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                
                sessao.update(questionario);
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
    public List<Questionario> listar() {
      try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                List lista =sessao.createQuery("from Questionario, Resposta where idquiz=1").list();
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
    
     public List<Questionario> listarQuestionario(Quiz q) {
      try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                List lista =sessao.createQuery("from Questionario where idquiz ="+q.getIdquiz()).list();
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
