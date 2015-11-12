/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Questionario;
import model.Quiz;
import model.Resposta;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class RespostaDaoBD implements InterfaceDao<Resposta>{

    private Session sessao;
    private Transaction trans;
    
    @Override
    public void inserir(Resposta bean) {
        
    }

    @Override
    public void deletar(Resposta bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Resposta bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public List<Resposta> listarQuestionario(Questionario q) {
      try{
                sessao = HibernateUtil.getSessionFactory().openSession();
                trans = sessao.beginTransaction();
                List lista =sessao.createQuery("from Resposta where idquestionario ="+q.getIdquestionario()).list();//+q.getIdquestionario()).list();
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
